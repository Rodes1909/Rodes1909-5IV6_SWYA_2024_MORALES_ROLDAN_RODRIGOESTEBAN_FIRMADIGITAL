package gui;

import javax.swing.JOptionPane;
import logica.Cifrado;
import logica.EditTxt;
import logica.Keys;

public class Cifrador extends javax.swing.JFrame {
    public Cifrador() {
        try{
            Keys.generateKeys();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cifrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        result = new javax.swing.JTextPane();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cifrar.setBackground(new java.awt.Color(0, 255, 255));
        cifrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cifrar.setText("Cifrar");
        cifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cifrarActionPerformed(evt);
            }
        });

        result.setEditable(false);
        result.setBackground(new java.awt.Color(153, 255, 255));
        jScrollPane1.setViewportView(result);

        cancelar.setBackground(new java.awt.Color(0, 255, 255));
        cancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelar.setText("Regresar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Escribe algo:");

        texto.setBackground(new java.awt.Color(153, 255, 255));
        jScrollPane2.setViewportView(texto);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mensaje Cifrado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(428, 428, 428)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelar))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(120, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(cifrar)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(159, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cifrarActionPerformed
        if(!texto.getText().trim().isEmpty() && texto.getText().trim().length() <= 94){
            cifrar();
        }
        else{
            JOptionPane.showMessageDialog(null, "Llena el TextArea y pon hasta 90 caracteres");
            texto.setText("");
        }
    }//GEN-LAST:event_cifrarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        new MyMain().setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cifrador().setVisible(true);
            }
        });
    }
    
    public void cifrar(){
        try{
            String myCipher = Cifrado.myCipher(texto.getText().trim());
            String myFile = "Texto: "+texto.getText().trim()+"\nFirma: "+myCipher;
            EditTxt.generarArchivo(myFile);
            result.setText(myFile);
            
            JOptionPane.showMessageDialog(null, "Mensaje guardado, revisa el archivo y modificalo (si quieres :P)");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            texto.setText("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton cifrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane result;
    private javax.swing.JTextPane texto;
    // End of variables declaration//GEN-END:variables
}
