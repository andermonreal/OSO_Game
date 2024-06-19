package Cliente;

/**
 *
 * @author Ander Monreal
 */
import java.io.IOException;
import javax.swing.*;

public class EleccionLetra extends JDialog {
    
    private char eleccion;
    private final Tablero tablero;
    private final int fila, col;
    private final Cliente jugador;
    
    public EleccionLetra(Tablero tablero, int fila, int col, Cliente jugador) {
        this.setModalityType(ModalityType.APPLICATION_MODAL); // Establece el tipo de modalidad del JDialog
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        initComponents();
        
        this.setBounds(650, 300, 200, 200);
        this.eleccion = ' ';
        this.tablero = tablero;
        this.fila = fila;
        this.col = col;
        this.jugador = jugador;
    }
    
    public String getLetra() {
        return String.valueOf(eleccion);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        botonS = new javax.swing.JButton();
        botonO = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Uni Sans", 0, 24)); // NOI18N
        jLabel6.setText("--------------------------------------- Juego del OSO ---------------------------------------");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonS.setText("S");
        botonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSActionPerformed(evt);
            }
        });

        botonO.setText("O");
        botonO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Uni Sans", 0, 24)); // NOI18N
        jLabel7.setText("Elige una letra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(botonS, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonO, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonO, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(botonS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonGuardar)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>                        

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (eleccion == ' ') {
            System.out.println("No se puede salir a menos que se elija una letra");
        } else {
            this.setVisible(false);
            tablero.setVisible(true);
            try {
                jugador.enviaMensajeAlJuego(fila + ":" + col + ":" + eleccion);
                System.out.println("Envio el siguiente mensaje al servidor: "+fila + ":" + col + ":" + eleccion);
            } catch (IOException ex) {
                System.out.println("[!] ERROR a al hora de elegir la letra, en el boton de guardar");
            }
        }
    }                                            

    private void botonOActionPerformed(java.awt.event.ActionEvent evt) {                                       
        botonO.setEnabled(false);
        botonS.setEnabled(true);
        eleccion = 'O';
    }                                      

    private void botonSActionPerformed(java.awt.event.ActionEvent evt) {                                       
        botonO.setEnabled(true);
        botonS.setEnabled(false);
        eleccion = 'S';
    }                                      
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonO;
    private javax.swing.JButton botonS;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration                   
}