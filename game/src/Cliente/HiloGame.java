package Cliente;

import java.io.IOException;

/**
 *
 * @author Ander Monreal
 */
public class HiloGame extends Thread{
    
    Cliente cliente;
    
    public HiloGame (Cliente cliente) {
        this.cliente = cliente;
    }    
    
    @Override
    public void run() {
        String recv;
        while (true) {
            try {
                recv = cliente.inJuego.readUTF();
                if (recv.equals("SALIR")) 
                    break;
                cliente.tablero.actualizaTablero(recv);
            } catch (IOException ex) {
                System.exit(0);
            }
        }
    }
}
