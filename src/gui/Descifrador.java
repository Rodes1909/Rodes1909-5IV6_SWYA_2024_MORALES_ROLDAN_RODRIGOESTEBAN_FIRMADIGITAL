package gui;

import javax.swing.JOptionPane;
import logica.Descifrado;
import logica.EditTxt;
import logica.Keys;

public class Descifrador extends javax.swing.JFrame {
    public Descifrador() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descifrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextPane();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 0));

        descifrar.setBackground(new java.awt.Color(153, 255, 255));
        descifrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        descifrar.setText("Descifrar");
        descifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descifrarActionPerformed(evt);
            }
        });

        texto.setEditable(false);
        texto.setBackground(new java.awt.Color(153, 255, 255));
        jScrollPane1.setViewportView(texto);

        cancelar.setBackground(new java.awt.Color(153, 255, 255));
        cancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Decifrar Mensaje:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descifrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(descifrar)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descifrarActionPerformed
        descifrar();
    }//GEN-LAST:event_descifrarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        new MyMain().setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Descifrador().setVisible(true);
            }
        });
    }
    
    public void descifrar(){
        String cipher = EditTxt.readFile();
        
        String[] content = cipher.split("\n");
        
        String digital = "", mensaje = "";
        
        for(String s : content){
            if(s.indexOf("Firma: ") != -1){
                digital = s.trim().replace("Firma: ", "");
            }            
            if(s.indexOf("Texto: ") != -1){
                mensaje = s.trim().replace("Texto: ", "");
            }
        }
        
        try{
            String dencript = Descifrado.myDecript(digital);            
            if(dencript.equals(mensaje)){                
                texto.setText("Mensaje Descifrado: "+dencript);
            }
            else{                
                texto.setText("Texto Nuevo: "+mensaje+"\nTexto Original: "+dencript);
                JOptionPane.showMessageDialog(null, "Cambiaste el documento :I, aqui están tus dos mensajes: ");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton descifrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane texto;
    // End of variables declaration//GEN-END:variables
}
