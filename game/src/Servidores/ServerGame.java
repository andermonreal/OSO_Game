package Servidores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ander Monreal
 */
public class ServerGame extends Thread{
    Juego partida;
    final int port;
    final List<ClientThreadJuego> clients = new LinkedList<>();

    public ServerGame(int port) {
        this.port = port;
        this.partida = new Juego();
    }
    
    @Override
    public void run(){
        try(ServerSocket serverSocket = new ServerSocket(port); ){
            System.out.println("[+] Inicio servidor del juego en el puerto " + port);

            Socket clientSocket1 = serverSocket.accept();
            ClientThreadJuego clientThread1 = new ClientThreadJuego(clientSocket1,clients,this.partida); //Jugador 0:
            clientThread1.start();

            Socket clientSocket2 = serverSocket.accept();
            ClientThreadJuego clientThread2 = new ClientThreadJuego(clientSocket2,clients,this.partida); //Jugador 1:
            clientThread2.start();

        }catch(Exception ex){
        }
    }
    
    public class ClientThreadJuego extends Thread{
        final Socket socket;
        DataOutputStream out;
        Juego partida;
        final List<ClientThreadJuego> clients;
        
        //Variables para el fichero de puntuación
        File ficheroPuntuacion = new File("./puntuacion.txt");

        public ClientThreadJuego(Socket socket, List<ClientThreadJuego> clients, Juego partida) {
            this.socket = socket;
            this.partida = partida;
            this.clients = clients;
        }
        
        //Enviamos a todos el mensaje
        synchronized public void sendMsg(String msg){ 
            try {
                out.writeUTF(msg);
            } catch (IOException ex) {
                Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        @Override
        public void run() {
            try {
                System.out.println("[+] GAME: Conexión de " +socket.getInetAddress() + ":" + socket.getPort());
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                
                // Sincronizamos los clientes y añadimos a la lista
                synchronized (clients) { 
                    clients.add(this);
                }

                // Inicio de la ejecución
                for (String line; (line = in.readUTF()) != null;) { //PROTOCOLO:
                    if(line.equals("SALIR")){
                        clients.forEach(c -> c.sendMsg("SALIR"));//Informo a los hilos del cierre
                        break;
                    }else{
                        String[] parts = line.split(":");
                        String nombre = parts[0];
                        int fila = Integer.parseInt(parts[1]);
                        int col = Integer.parseInt(parts[2]);
                        char letra = parts[3].charAt(0);
                        String respuesta = partida.nuevoOSO(nombre,fila,col,letra);
                        String[] parts2 = respuesta.split("-");
                        synchronized (clients){ 
                            clients.forEach(c -> c.sendMsg(parts2[0]+'-'+parts2[1]+'-'+parts2[2]+'-'+parts2[3]+'-'+parts2[4]+'-'+parts2[5]+'-'+parts2[6]+'-'+parts2[7]));//Mando la salida entera de nuevoOSO
                        }
                        if("SI".equals(parts2[7])){
                            if (Integer.parseInt(parts[1]) > Integer.parseInt(parts[3])){
                                escribirPuntuaciones(parts2[0]);
                            }else if(Integer.parseInt(parts[1]) < Integer.parseInt(parts[3])){
                                escribirPuntuaciones(parts2[2]);
                            }
                        }
                    }
                }

            } catch (IOException ex) {
                System.exit(0);
            }
        }
        
        private void escribirPuntuaciones(String jugador) throws IOException {
            Map<String, Integer> MapaVictorias = new HashMap<>();
            
            if (ficheroPuntuacion.createNewFile()) { //Acabo de crear el fichero
                escribeMapa(MapaVictorias,jugador);
            } else {
                //Primeo leo el fichero por si algún jugador ya había ganado
                BufferedReader br = new BufferedReader(new FileReader(ficheroPuntuacion));
                for (String line; (line = br.readLine()) != null;){
                    String[] partes = line.split(":"); //Nombre:NumVictorias
                    MapaVictorias.put(partes[0],Integer.valueOf(partes[1]));
                }

                //Una vez leido, compruebo
                escribeMapa(MapaVictorias,jugador);
            }
        }
        
        private void escribeMapa(Map<String, Integer> MapaVictorias, String jugador) throws IOException{
            if(!MapaVictorias.containsKey(jugador)){ //Todavía no hemos jugado ni una vez
                MapaVictorias.put(jugador,0);
            }
            MapaVictorias.put(jugador, MapaVictorias.get(jugador)+1);
            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroPuntuacion));
            for (Map.Entry<String, Integer> entry : MapaVictorias.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue());
                bw.newLine();
            }
            bw.flush();
        }
    }
}
