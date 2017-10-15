
package ASEGURADORA;

import Conexiones.ASEGURADORA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TBCOMPAÑIA extends javax.swing.JFrame {
    ASEGURADORA op=new ASEGURADORA();
    Connection op1=op.dbaseguradora();
    PreparedStatement r1=null;
    ResultSet r2=null;
   
    public TBCOMPAÑIA() {
        initComponents();
        cargatabla();
        cargarcombo();
    }
    
    public void cargatabla(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("NIT ");
        table.addColumn("Nombre  ");
        table.addColumn("Año de Fun  ");
        table.addColumn("Representante Legal  ");
        jTable1.setModel (table);
        String datos []=new String [4];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbcompañia");
            r2=r1.executeQuery();
            while(r2.next()){
               datos[0]=r2.getString(1);
               datos[1]=r2.getString(2);
               datos[2]=r2.getString(3);
               datos[3]=r2.getString(4);
               table.addRow(datos);
            
            }
             } catch (Exception e) {
            System.out.print (e);
        }
    }
    
     public void listardatos(){
        int list=jTable1.getSelectedRow();
        if(list>=0){
            jComboBox1.setSelectedItem(jTable1.getValueAt(list,0).toString());
            jTextNOMBRE.setText(jTable1.getValueAt(list, 1).toString());
            jTextFUNDADO.setText(jTable1.getValueAt(list, 2).toString());
            jTextLEGAL.setText(jTable1.getValueAt(list, 3).toString());
            
        }
        
    }
    
      public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO tbcompañia (comnit,comnombre,comañofun,comreplegal) VALUES(?,?,?,?)");
            r1.setString(1,jTextNIT.getText());
            r1.setString(2,jTextNOMBRE.getText());
            r1.setString(3,jTextFUNDADO.getText());
            r1.setString(4,jTextLEGAL.getText());
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Guardados");
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
       public void cargarcombo(){
        try {
            jComboBox1.removeAll();
            jComboBox1.addItem("Nit de la empresa");
            r1=op1.prepareStatement("SELECT comnit from tbcompañia");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("comnit");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
     
       public void modificar(String nom,String fun, String rep, String nit){
        try {
            r1=op1.prepareStatement("UPDATE tbcompañia set comnombre= '"+nom+"' ,comañofun= '"+fun+"' , comreplegal='"+rep+"' where  comnit='"+nit+"'");
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados ");
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
        
         public void eliminar(String cod){
        try {
         r1=op1.prepareStatement("DELETE from tbcompañia WHERE comnit='"+cod+"'");
         r1.executeUpdate();
         JOptionPane.showMessageDialog(null,"Datos Eliminados ");
         
        } catch (Exception e) {
            System.out.print(e);
        }
        
      }
        
    
    
    
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButtonLIMPIO = new javax.swing.JButton();
        jButtonREGISTRAR = new javax.swing.JButton();
        jButtonELIMINA = new javax.swing.JButton();
        jTextNIT = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextFUNDADO = new javax.swing.JTextField();
        jTextLEGAL = new javax.swing.JTextField();
        jTextNOMBRE = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("REGRESAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonLIMPIO.setText("LIMPIAR");
        jButtonLIMPIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLIMPIOActionPerformed(evt);
            }
        });

        jButtonREGISTRAR.setText("REGISTRAR");
        jButtonREGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonREGISTRARActionPerformed(evt);
            }
        });

        jButtonELIMINA.setText("ELIMINAR");
        jButtonELIMINA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonELIMINAActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setText("AÑO FUNDADO");

        jTextFUNDADO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFUNDADOKeyTyped(evt);
            }
        });

        jTextLEGAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLEGALActionPerformed(evt);
            }
        });
        jTextLEGAL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextLEGALKeyTyped(evt);
            }
        });

        jTextNOMBRE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNOMBREKeyTyped(evt);
            }
        });

        jLabel2.setText("REPRESENTANTE LEGAL");

        jLabel1.setText("NIT");

        jLabel3.setText("NOMBRE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(330, 330, 330)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFUNDADO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(330, 330, 330)
                        .addComponent(jButtonREGISTRAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextLEGAL, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(330, 330, 330)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonELIMINA, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLIMPIO, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFUNDADO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonREGISTRAR))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextLEGAL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonELIMINA)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonLIMPIO)
                        .addGap(7, 7, 7)
                        .addComponent(jButton1)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MENU op=new MENU();
         op.setVisible(true);
        dispose();
        op.setLocation(300,100);
        op.setSize(300, 350);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nom, fun, rep, nit;

        nit=jComboBox1.getSelectedItem().toString();
        nom=jTextNOMBRE.getText();
        fun=jTextFUNDADO.getText();
        rep=jTextLEGAL.getText();
        
        modificar(nom, fun, rep, nit);
        cargatabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonLIMPIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLIMPIOActionPerformed
        jComboBox1.removeAllItems();
        cargarcombo();
        jTextNIT.setText(null);
        
        jTextNOMBRE.setText(null);
        
        jTextFUNDADO.setText(null);
        jTextLEGAL.setText(null);
        
    }//GEN-LAST:event_jButtonLIMPIOActionPerformed

    private void jButtonREGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonREGISTRARActionPerformed
        registrar();
        cargatabla();

    }//GEN-LAST:event_jButtonREGISTRARActionPerformed

    private void jButtonELIMINAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonELIMINAActionPerformed
        String cod=jComboBox1.getSelectedItem().toString();
        eliminar(cod);
        cargatabla();
    }//GEN-LAST:event_jButtonELIMINAActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextLEGALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLEGALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLEGALActionPerformed

    private void jTextNOMBREKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNOMBREKeyTyped
         String txt=jTextNOMBRE.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextNOMBRE.setText(txt);
        }
         char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextNOMBREKeyTyped

    private void jTextFUNDADOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFUNDADOKeyTyped
                char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
        
    }//GEN-LAST:event_jTextFUNDADOKeyTyped

    private void jTextLEGALKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextLEGALKeyTyped
          String txt=jTextLEGAL.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextLEGAL.setText(txt);
        }
         char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextLEGALKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        listardatos();
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TBCOMPAÑIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TBCOMPAÑIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TBCOMPAÑIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TBCOMPAÑIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBCOMPAÑIA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonELIMINA;
    private javax.swing.JButton jButtonLIMPIO;
    private javax.swing.JButton jButtonREGISTRAR;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFUNDADO;
    private javax.swing.JTextField jTextLEGAL;
    private javax.swing.JTextField jTextNIT;
    private javax.swing.JTextField jTextNOMBRE;
    // End of variables declaration//GEN-END:variables
}
