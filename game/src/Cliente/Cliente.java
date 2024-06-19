package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Ander Monreal
 */
public class Cliente {
    
    public String name;
    public Tablero tablero;
    public ConfiguracionCliente configuracion;
    final Socket socketChat, socketJuego;
    final DataInputStream inChat,inJuego;
    final DataOutputStream outChat,outJuego;
    
    public Cliente (ConfiguracionCliente configuracion) throws IOException{
        this.name = configuracion.name; // Recojo el nombre de la configuracion
        
        socketChat = new Socket(configuracion.host,configuracion.portChat);
        inChat = new DataInputStream(socketChat.getInputStream()); //obtenemos salida del socket del chat
        outChat = new DataOutputStream(socketChat.getOutputStream()); //obtenemos entrada del socket del chat
        
        socketJuego = new Socket(configuracion.host,configuracion.portGame);
        inJuego = new DataInputStream(socketJuego.getInputStream());
        outJuego = new DataOutputStream(socketJuego.getOutputStream());
        
        // Creo los hilos y les hago que empiece a funcionar
        HiloChat hiloChat = new HiloChat(this);
        HiloGame hiloGame = new HiloGame(this);
        hiloChat.start();
        hiloGame.start();
    }
    
    public void setConfiguracion (ConfiguracionCliente configuracion) {
        this.configuracion = configuracion;
    }
    
    public void setTablero (Tablero tablero) {
        this.tablero = tablero;
    }
    
    public void enviaMensajeAlJuego(String msg) throws IOException{      
        outJuego.writeUTF(this.name+":"+msg);//primer msg (nombre,fila,col,letra) 
        outJuego.flush();
    }
    
    //Funcion que usamos en tablero pero +la usa el jugador para enviar mens al chat.
    public void enviaMensajeAlChat(String msg) throws IOException{      
        outChat.writeUTF(this.name+": "+msg); 
        outChat.flush();
    }
    
    public static void main(String[] args) throws IOException {
        
        // Abrimos el menu, se tendra que meter una configuracion, a la hora de pulsar nueva partida se creara el tablero y el objeto cliente
        Menu menu = new Menu();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                menu.setVisible(true);
            }
        });
    }
} 