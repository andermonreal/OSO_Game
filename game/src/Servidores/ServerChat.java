package Servidores;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ander Monreal
 */
public class ServerChat extends Thread{
    final int port;
    final List<ClientThreadChat> clientes = new LinkedList<>();
    
    public ServerChat (int port) {
        this.port = port;
    }
    
    @Override
    public void run(){
        try (ServerSocket serverChatSocket = new ServerSocket(port); ) {
            System.out.println("[+] Inicio servidor del chat en el puerto " + port);
            int conectados = 0;
            while (!interrupted() && conectados < 2) {
                Socket clienteSocket = serverChatSocket.accept();
                conectados++;
                ClientThreadChat clientThread = new ClientThreadChat(clientes, clienteSocket);
                clientThread.start();
            }
        }  catch (IOException ex) {
            Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private class ClientThreadChat extends Thread {
        final List<ClientThreadChat> clientes;
        final Socket socket;
        DataOutputStream out;

        public ClientThreadChat(List<ClientThreadChat> clientes, Socket socket) {
            this.clientes = clientes;
            this.socket = socket;
        }
        
        synchronized public void sendMsg (String msg) {
            try {
                out.writeUTF(msg);
            } catch (IOException ex) {
                Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        @Override
        public void run() {
            try {
                System.out.println("[+] CHAT: Conexión de " +socket.getInetAddress() + ":" + socket.getPort()); //coje la info del socket
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                // Sincronizamos los clientes y añadimos a la lista
                synchronized (clientes) { 
                    clientes.add(this);
                }
                
                // Inicio de la ejecución
                for (String line; (line = in.readUTF()) != null;) {
                    System.out.println("[CHAT] Recibo este mensaje: "+ line);
                    if(line.equals("SALIR")){
                        clientes.forEach(c -> c.sendMsg("SALIR")); // Se encarga de mandar un mensaje a los hilos 
                        break;
                    }
                    String mensaje = line;
                    // Siempre que queramos mandar algo a todos los clientes los sincronizamos
                    synchronized (clientes) { 
                        clientes.forEach(c -> c.sendMsg( mensaje ));
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
            } finally { //hemos acabado o faileado, asi que nos desconectamos de la lista
                try{ socket.close(); } catch(IOException ex){} //nos aseguramos de que cerramos el socket
                synchronized (clientes) {
                    clientes.remove(this);
                }
            }
        }  
        
    }
    
}
