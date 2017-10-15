
package BANCO;

import Conexiones.BANCODB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TBUSUARIO extends javax.swing.JFrame {
    BANCODB op=new BANCODB();
    Connection op1=op.dbbanco();
    PreparedStatement r1=null;
    ResultSet r2=null;
   
    public TBUSUARIO() {
        initComponents();
         cargatabla();
         cargarcombo();
    }
    
    public void cargatabla(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("Documento Cliente ");
        table.addColumn("Usuario ");
        table.addColumn("Clave ");
        jTable1.setModel (table);
        String datos []=new String [4];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbusuario");
            r2=r1.executeQuery();
            while(r2.next()){
               datos[0]=r2.getString(1);
               datos[1]=r2.getString(2);
               datos[2]=r2.getString(3);
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
            jTextUSUARIO.setText(jTable1.getValueAt(list, 1).toString());
            jTextCLAVE.setText(jTable1.getValueAt(list, 2).toString());
            
        }
        
    }
      
     public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO tbusuario (doccli,usuario,clave) VALUES(?,?,?)");
            r1.setString(1,jComboBox1.getSelectedItem().toString());
            r1.setString(2,jTextUSUARIO.getText());
            r1.setString(3,jTextCLAVE.getText());
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Guardados");
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
       public void cargarcombo(){
        try {
            jComboBox1.removeAll();
            jComboBox1.addItem("Seleccione Documento");
            r1=op1.prepareStatement("SELECT doccli from tbusuario");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("doccli");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
     
       public void modificar(String usu,String cla, String doc){
        try {
            r1=op1.prepareStatement("UPDATE tbusuario set usuario= '"+usu+"' ,clave= '"+cla+"' where  doccli='"+doc+"'");
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados ");
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
        
         public void eliminar(String cod){
        try {
         r1=op1.prepareStatement("DELETE from tbusuario WHERE doccli='"+cod+"'");
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
        jButtonELIMINAR = new javax.swing.JButton();
        jButtonMODIFICAR = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonGUARDAR = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextUSUARIO = new javax.swing.JTextField();
        jTextCLAVE = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextDOCUMENTO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("REGRESAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(730, 260, 100, 23);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 11, 827, 111);

        jButtonELIMINAR.setText("ELIMINAR ");
        jButtonELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonELIMINARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonELIMINAR);
        jButtonELIMINAR.setBounds(730, 200, 100, 20);

        jButtonMODIFICAR.setText("MODIFICAR ");
        jButtonMODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMODIFICARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMODIFICAR);
        jButtonMODIFICAR.setBounds(730, 170, 100, 23);

        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(730, 230, 100, 23);

        jButtonGUARDAR.setText("REGISTRAR");
        jButtonGUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGUARDARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGUARDAR);
        jButtonGUARDAR.setBounds(730, 140, 100, 23);

        jLabel3.setText("USUARIO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 190, 90, 20);

        jTextUSUARIO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextUSUARIOKeyTyped(evt);
            }
        });
        getContentPane().add(jTextUSUARIO);
        jTextUSUARIO.setBounds(140, 180, 150, 30);

        jTextCLAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCLAVEActionPerformed(evt);
            }
        });
        jTextCLAVE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCLAVEKeyTyped(evt);
            }
        });
        getContentPane().add(jTextCLAVE);
        jTextCLAVE.setBounds(140, 220, 150, 30);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(60, 140, 230, 30);

        jLabel4.setText("CLAVE ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 230, 90, 20);

        jLabel1.setText("DOCUMENTO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 260, 90, 20);
        getContentPane().add(jTextDOCUMENTO);
        jTextDOCUMENTO.setBounds(140, 260, 150, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MENU op=new MENU();
         op.setVisible(true);
        dispose();
        op.setLocation(300,100);
        op.setSize(300, 350);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonELIMINARActionPerformed
        String cod=jComboBox1.getSelectedItem().toString();
        eliminar(cod);
        cargatabla();
    }//GEN-LAST:event_jButtonELIMINARActionPerformed

    private void jButtonMODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMODIFICARActionPerformed
        String usu, cla, doc;

        doc=jComboBox1.getSelectedItem().toString();
        usu=jTextUSUARIO.getText();
        cla=jTextCLAVE.getText();
        modificar(usu, cla, doc);
        cargatabla();
    }//GEN-LAST:event_jButtonMODIFICARActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        jComboBox1.removeAllItems();
        cargarcombo();
        jTextCLAVE.setText(null);
        jTextUSUARIO.setText(null);
        jTextDOCUMENTO.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGUARDARActionPerformed
        registrar();
        cargatabla();
    }//GEN-LAST:event_jButtonGUARDARActionPerformed

    private void jTextUSUARIOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextUSUARIOKeyTyped
        String txt=jTextUSUARIO.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextUSUARIO.setText(txt);
        }
        char c=evt.getKeyChar();
        if (Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextUSUARIOKeyTyped

    private void jTextCLAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCLAVEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCLAVEActionPerformed

    private void jTextCLAVEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCLAVEKeyTyped
        char c=evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextCLAVEKeyTyped

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        listardatos();
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TBUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TBUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TBUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TBUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBUSUARIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonELIMINAR;
    private javax.swing.JButton jButtonGUARDAR;
    private javax.swing.JButton jButtonMODIFICAR;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCLAVE;
    private javax.swing.JTextField jTextDOCUMENTO;
    private javax.swing.JTextField jTextUSUARIO;
    // End of variables declaration//GEN-END:variables
}
