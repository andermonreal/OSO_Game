package Cliente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Ander Monreal
 */
public class Menu extends javax.swing.JFrame {

    private Cliente jugador;
    private Tablero tablero;
    private ConfiguracionCliente configuracion;
    //private final Puntuacion puntuacion;

    public Menu() throws IOException {
        initComponents(); 
        this.setBounds(800, 400, 450, 230);
        this.botonNuevaPartida.setEnabled(false); //lo hacemos para que si o si entre primero a configuración
        //this.puntuacion = new Puntuacion(this);
        //this.puntuacion.setVisible(false);
    }
    
    public JButton getBotonNuevaPartida() {
        return botonNuevaPartida;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonNuevaPartida = new javax.swing.JButton();
        botonConfiguracion = new javax.swing.JButton();
        botonPuntuacion = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonNuevaPartida.setText("Nueva Partida");
        botonNuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaPartidaActionPerformed(evt);
            }
        });

        botonConfiguracion.setText("Configuración");
        botonConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfiguracionActionPerformed(evt);
            }
        });

        botonPuntuacion.setText("Puntuación");
        botonPuntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPuntuacionActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Uni Sans", 0, 24)); // NOI18N
        jLabel1.setText("-------------- Juego del OSO --------------");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonNuevaPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonPuntuacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonNuevaPartida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonConfiguracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonPuntuacion)
                .addGap(18, 18, 18)
                .addComponent(botonSalir)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaPartidaActionPerformed
        this.setVisible(false);
        try {
            this.jugador = new Cliente(this.configuracion);
        } catch (IOException ex) {
            System.out.println("Salta excepcion en el boton de nueva partida");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        tablero = new Tablero(this,jugador);
        this.jugador.setTablero(tablero);
    }//GEN-LAST:event_botonNuevaPartidaActionPerformed

    private void botonConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfiguracionActionPerformed
        configuracion = new ConfiguracionCliente(this);
        configuracion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonConfiguracionActionPerformed

    private void botonPuntuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPuntuacionActionPerformed

    }//GEN-LAST:event_botonPuntuacionActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConfiguracion;
    private javax.swing.JButton botonNuevaPartida;
    private javax.swing.JButton botonPuntuacion;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
