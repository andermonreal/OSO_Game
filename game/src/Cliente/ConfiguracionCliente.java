package Cliente;

import javax.swing.JOptionPane;

/**
 *
 * @author Ander Monreal
 */
public class ConfiguracionCliente extends javax.swing.JFrame {

    private final Menu menuPadre;
    public String name, host;
    public int  portChat, portGame;
    
    
    public ConfiguracionCliente(Menu menu) {
        initComponents();
        this.setBounds(800, 400, 300, 300);
        this.hostScan.setText("localhost");
        this.portChatScan.setText("12000");
        this.portGameScan.setText("12001");
        menuPadre = menu;
    }
    
    public void setHost (String hostD) {
        this.host = hostD;
    }
    public void setPortChat (int puerto_chat){
        System.out.println("Asignamos puerto del chat: "+ puerto_chat);
        this.portChat = puerto_chat;
    }
    public void setPortGame (int puerto_game) {
        System.out.println("Asignamos puerto del juego: "+ puerto_game);
        this.portGame = puerto_game;
    }
    public void setUserName (String name) {
        this.name = name;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guardarConfiguracion = new javax.swing.JButton();
        informativo = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        tuIP = new javax.swing.JLabel();
        puerto = new javax.swing.JLabel();
        userNameScan = new javax.swing.JTextField();
        hostScan = new javax.swing.JTextField();
        portGameScan = new javax.swing.JTextField();
        salir = new javax.swing.JButton();
        puertoDelChat = new javax.swing.JLabel();
        portChatScan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        guardarConfiguracion.setText("Guardar configuracion");
        guardarConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarConfiguracionActionPerformed(evt);
            }
        });

        informativo.setText("Introduce los siguientes datos:");

        nombre.setText("Nombre:");

        tuIP.setText("Tu IP:");

        puerto.setText("Puerto del juego:");

        userNameScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameScanActionPerformed(evt);
            }
        });

        hostScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostScanActionPerformed(evt);
            }
        });

        portGameScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portGameScanActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        puertoDelChat.setText("Puerto del chat:");

        portChatScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portChatScanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Uni Sans", 0, 24)); // NOI18N
        jLabel1.setText("Configuración necesaria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informativo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(guardarConfiguracion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salir))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tuIP)
                                .addComponent(puerto))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(userNameScan))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(puertoDelChat)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(portChatScan))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 37, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(hostScan, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(portGameScan, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(informativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(userNameScan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tuIP)
                    .addComponent(hostScan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puerto)
                    .addComponent(portGameScan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puertoDelChat)
                    .addComponent(portChatScan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarConfiguracion)
                    .addComponent(salir))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private boolean comprobarCamposRellenos(){
        return !(hostScan.getText().isEmpty() || portGameScan.getText().isEmpty() || portChatScan.getText().isEmpty() || userNameScan.getText().isEmpty());
    }
            
    private void guardarConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarConfiguracionActionPerformed

        if (this.comprobarCamposRellenos()) {
            this.setHost (hostScan.getText());
            this.setPortChat(Integer.parseInt(portChatScan.getText()));
            this.setPortGame(Integer.parseInt(portGameScan.getText()));
            this.setUserName(userNameScan.getText());
            System.out.println("Nombre de usuario: " + userNameScan.getText());
            menuPadre.getBotonNuevaPartida().setEnabled(true);
            menuPadre.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"Debes introducir todos los campos");
        }
    }//GEN-LAST:event_guardarConfiguracionActionPerformed

    
    private void portGameScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portGameScanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portGameScanActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.setVisible(false);
        menuPadre.setVisible(true);
    }//GEN-LAST:event_salirActionPerformed

    private void portChatScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portChatScanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portChatScanActionPerformed

    private void hostScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostScanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hostScanActionPerformed

    private void userNameScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameScanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameScanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarConfiguracion;
    private javax.swing.JTextField hostScan;
    private javax.swing.JLabel informativo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField portChatScan;
    private javax.swing.JTextField portGameScan;
    private javax.swing.JLabel puerto;
    private javax.swing.JLabel puertoDelChat;
    private javax.swing.JButton salir;
    private javax.swing.JLabel tuIP;
    private javax.swing.JTextField userNameScan;
    // End of variables declaration//GEN-END:variables
}
