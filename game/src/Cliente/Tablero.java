package Cliente;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

/**
 *
 * @author Ander Monreal
 */


public class Tablero extends javax.swing.JFrame {

    private final Cliente cliente;
    public String userName, rivalName;
    public int userPuntuation, rivalPuntuation, columnas;
    ArrayList<JButton> botones = new ArrayList<>();

    
    public Tablero(javax.swing.JFrame ventanaInicio, Cliente cliente) {
        initComponents();
        this.setBounds(650, 300, 950, 610);
        this.cliente = cliente;
        this.tuNombre.setText(cliente.name); // Variable jLabel
        this.nombreRival.setText(" "); // Variable jLabel
        this.miPunt.setText(Integer.toString(0)); // Variable jLabel
        this.rivalPunt.setText(Integer.toString(0)); // Variable jLabel
        
        this.crear_tablero();
        this.setVisible(true);
    }
    
    private void crear_tablero() {
        this.columnas = 10;
        for (int x = 0; x<10; x++){
            for (int y = 0; y<10; y++) {
                final int x1=x, y1=y;
                final Tablero aux = this;
                JButton boton = new JButton("");
                boton.setBounds((y*44), (x*44), 44, 44);
                boton.addActionListener (new ActionListener() {
                    @Override
                    public void actionPerformed (ActionEvent ae) {
                        setVisible(false);
                        EleccionLetra eleccionLetra = new EleccionLetra(aux, x1, y1, cliente);
                        
                        // Ajuste: Cambiar la visibilidad del JDialog al final
                        eleccionLetra.setModal(true);
                        eleccionLetra.setVisible(true);

                        // Ajuste: Mostrar el JDialog de manera modal y bloquear hasta que se cierre
                        eleccionLetra.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        eleccionLetra.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        
                        boton.setText(eleccionLetra.getLetra());
                        boton.setEnabled(false);
                        setVisible(true); // Restaurar la visibilidad del Tablero después de cerrar el JDialog
                    }
                });
                botones.add(boton); // Agrega el botón a la lista
                panelJuego.add(boton);
            }
        }
    }
    
    public JTextArea getChat() {
        return chat;
    }
    
    public int getUserPuntuation(){
        return userPuntuation;
    }
    
    public void escribir(String s){
        this.chat.append(s + "\n");
    }
    
    void actualizaTablero(String recv) {
        
        int fila, col, puntuacion1, puntuacion2;
        String nombre1, nombre2, letra, respuesta;
        String[] movimiento; 
        
/*      jugada[0] = Nombre jugador 1
        jugada[1] = Puntuación jugador 1
        jugada[2] = Nombre jugador 2
        jugada[3] = Puntuación jugador 2
        jugada[3] = Letra del movimiento
        jugada[4] = Fila del movimiento
        jugada[5] = Columna del movimiento
        jugada[6] = Letra del movimiento
        jugada[7] = Respuesta del movimiento
        */
        movimiento = recv.split("-");
        nombre1 = movimiento[0];
        puntuacion1 = Integer.parseInt(movimiento[1]);
        nombre2 = movimiento[2];
        puntuacion2 = Integer.parseInt(movimiento[3]);
        fila = Integer.parseInt(movimiento[4]);
        col = Integer.parseInt(movimiento[5]);
        letra = movimiento[6];
        respuesta = movimiento[7];
        
        // Modifico el boton que lo tengo guardado en la lista
        botones.get(fila*columnas + col).setText(letra);
        botones.get(fila*columnas + col).setEnabled(false);
        
        
        if (nombre1.equals(cliente.name)){
            if(" ".equals(this.nombreRival.getText())){
                this.nombreRival.setText(nombre2);
            }
            this.miPunt.setText(Integer.toString(puntuacion1));
            this.rivalPunt.setText(Integer.toString(puntuacion2));
            ocultar_tablero(); // Para que cuando no sea su turno no pueda pulsar ningun boton
        }
        
        else if(!nombre1.equals(cliente.name)){
            if(" ".equals(this.nombreRival.getText())){
                this.nombreRival.setText(nombre1);
            }
            this.miPunt.setText(Integer.toString(puntuacion2));
            this.rivalPunt.setText(Integer.toString(puntuacion1));
            desocultar_tablero();
        }
        if("SI".equals(respuesta)){
            ocultar_tablero();
        }
    }
    
    private void ocultar_tablero() {
        
        for (JButton boton : botones) {
            boton.setEnabled(false);
        }
    }
    
    private void desocultar_tablero(){
        for (JButton boton : botones) {
            if (boton.getText().isEmpty()) 
                boton.setEnabled(true);
        }
    }  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chat = new javax.swing.JTextArea();
        barraDelChat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        panelJuego = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tuNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        miPunt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rivalPunt = new javax.swing.JLabel();
        nombreRival = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Uni Sans", 0, 24)); // NOI18N
        jLabel5.setText("-------------- Juego del OSO --------------");

        chat.setColumns(20);
        chat.setRows(5);
        jScrollPane1.setViewportView(chat);

        barraDelChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                barraDelChatKeyPressed(evt);
            }
        });

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panelJuego.setPreferredSize(new java.awt.Dimension(420, 420));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Tu nombre:");

        tuNombre.setText(".");

        jLabel2.setText("Nombre del rival:");

        jLabel3.setText("Punt:");

        miPunt.setText(".");

        jLabel4.setText("Punt:");

        rivalPunt.setText(".");

        nombreRival.setText(".");

        jLabel6.setFont(new java.awt.Font("Uni Sans", 0, 24)); // NOI18N
        jLabel6.setText("-------------------------------------------- Juego del OSO -------------------------------------------");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tuNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(miPunt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nombreRival, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rivalPunt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(barraDelChat, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tuNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(miPunt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombreRival)
                            .addComponent(jLabel4)
                            .addComponent(rivalPunt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
                    .addComponent(panelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barraDelChat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void barraDelChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barraDelChatKeyPressed
    
    }//GEN-LAST:event_barraDelChatKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            cliente.enviaMensajeAlChat(barraDelChat.getText() + "\n");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        barraDelChat.setText("");//limpia lo que esté en la barra.
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barraDelChat;
    private javax.swing.JTextArea chat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel miPunt;
    private javax.swing.JLabel nombreRival;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JLabel rivalPunt;
    private javax.swing.JLabel tuNombre;
    // End of variables declaration//GEN-END:variables
}
