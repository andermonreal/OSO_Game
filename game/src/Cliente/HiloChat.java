package Cliente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ander Monreal
 */
public class HiloChat extends Thread{
    Cliente cliente;

    public HiloChat(Cliente cliente) {
        this.cliente = cliente;
    }
   
    
    @Override
    public void run(){
        String recv;
        while(true){            
            try {
                recv = cliente.inChat.readUTF();
                recv = recv.toUpperCase();
                if (recv.equals("SALIR")) {
                    System.exit(0);
                    break;
                }
                cliente.tablero.getChat().append(recv);
            } catch (IOException ex) {
                Logger.getLogger(HiloChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
}
