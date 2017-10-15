
package LIBRERIA;

import Conexiones.LIBRERIADB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TBPEDIDO extends javax.swing.JFrame {
    LIBRERIADB op=new LIBRERIADB();
    Connection op1=op.dblibreria();
    PreparedStatement r1=null;
    ResultSet r2=null;
    
    public TBPEDIDO() {
        initComponents();
        cargatabla();
        cargarcombo();
        cargarcombo2();
    }

    public void cargatabla(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("ID ");
        table.addColumn("ID Cliente  ");
        table.addColumn("Fecha Pedido  ");
        table.addColumn("Valor Pedido ");
        jTable1.setModel (table);
        String datos []=new String [4];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbpedido");
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
            jComboBox2.setSelectedItem(jTable1.getValueAt(list, 1).toString());
            jTextFECHA.setText(jTable1.getValueAt(list, 2).toString());
            jTextVALOR.setText(jTable1.getValueAt(list, 3).toString());
            
        }
        
    }   
    
      
    
      public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO Tbpedido(Id_ped,id_cli_ped,fec_ped,val_ped)VALUES(?,?,?,?)");
            r1.setString(1,jTextPEDIDO.getText());
            r1.setString(3,jTextFECHA.getText());
            r1.setString(4,jTextVALOR.getText());
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Guardados");
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
       public void cargarcombo(){
        try {
            jComboBox1.removeAll();
            jComboBox1.addItem("Seleccione ID Pedido");
            r1=op1.prepareStatement("SELECT  id_ped from tbpedido");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("id_ped");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
       }
        
        public void cargarcombo2(){
        try {
            jComboBox2.removeAll();
            jComboBox2.addItem("Seleccione ID cliente");
            r1=op1.prepareStatement("SELECT  id_cli_ped from tbpedido");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("id_cli_ped");
                this.jComboBox2.addItem(aux);
          
            }
        } catch (Exception e) {
        }
             
      } 
     
       public void modificar(String fec,String val, String ped, String id){
        try {
            r1=op1.prepareStatement("UPDATE tbpedido set id_cli_ped='"+id+"', fec_ped='"+fec+"', val_ped='"+val+"'  where  id_ped= '"+ped+"' ");
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados ");
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
        
         public void eliminar(String cod){
        try {
         r1=op1.prepareStatement("DELETE from tbcliente WHERE Id_cli='"+cod+"'");
         r1.executeUpdate();
         JOptionPane.showMessageDialog(null,"Datos Eliminados ");
         
        } catch (Exception e) {
            System.out.print(e);
        }
        
      }
        
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabla = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButtonREGISTRAR = new javax.swing.JButton();
        jButtonELIMINA = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonLIMPIO = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextVALOR = new javax.swing.JTextField();
        jTextFECHA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextPEDIDO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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
        tabla.setViewportView(jTable1);

        getContentPane().add(tabla);
        tabla.setBounds(10, 10, 820, 150);

        jButton1.setText("REGRESAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(690, 310, 120, 23);

        jButtonREGISTRAR.setText("REGISTRAR");
        jButtonREGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonREGISTRARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonREGISTRAR);
        jButtonREGISTRAR.setBounds(690, 190, 120, 23);

        jButtonELIMINA.setText("ELIMINAR");
        jButtonELIMINA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonELIMINAActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonELIMINA);
        jButtonELIMINA.setBounds(690, 250, 120, 23);

        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(690, 220, 120, 23);

        jButtonLIMPIO.setText("LIMPIAR");
        jButtonLIMPIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLIMPIOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLIMPIO);
        jButtonLIMPIO.setBounds(690, 280, 120, 23);

        jLabel5.setText("FECHA");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 260, 60, 20);

        jTextVALOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextVALORKeyTyped(evt);
            }
        });
        getContentPane().add(jTextVALOR);
        jTextVALOR.setBounds(150, 290, 170, 30);

        jTextFECHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFECHAActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFECHA);
        jTextFECHA.setBounds(150, 250, 170, 30);

        jLabel2.setText("VALOR ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 300, 60, 20);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(20, 170, 300, 30);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(20, 210, 300, 30);

        jLabel1.setText("ID PEDIDO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 340, 80, 20);

        jTextPEDIDO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPEDIDOKeyTyped(evt);
            }
        });
        getContentPane().add(jTextPEDIDO);
        jTextPEDIDO.setBounds(150, 330, 170, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MENU op=new MENU();
         op.setVisible(true);
        dispose();
        op.setLocation(300,100);
        op.setSize(300, 350);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonREGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonREGISTRARActionPerformed
        registrar();
        cargatabla();
    }//GEN-LAST:event_jButtonREGISTRARActionPerformed

    private void jButtonELIMINAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonELIMINAActionPerformed
        String cod=jComboBox1.getSelectedItem().toString();
        String com=jComboBox2.getSelectedItem().toString();
        eliminar(cod);
        eliminar(com);
        cargatabla();
    }//GEN-LAST:event_jButtonELIMINAActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String fec, val, ped, dep, mes, id;

        ped=jComboBox1.getSelectedItem().toString();
        id=jComboBox2.getSelectedItem().toString();
        fec=jTextFECHA.getText();
        val=jTextVALOR.getText();
        modificar(fec, val, ped, id);
        cargatabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonLIMPIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLIMPIOActionPerformed
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        cargarcombo();
        cargarcombo2();
        jTextFECHA.setText(null);
        jTextVALOR.setText(null);
        jTextPEDIDO.setText(null);
        
    }//GEN-LAST:event_jButtonLIMPIOActionPerformed

    private void jTextFECHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFECHAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFECHAActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextVALORKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextVALORKeyTyped
                    char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextVALORKeyTyped

    private void jTextPEDIDOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPEDIDOKeyTyped
                    char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextPEDIDOKeyTyped

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
            java.util.logging.Logger.getLogger(TBPEDIDO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TBPEDIDO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TBPEDIDO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TBPEDIDO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBPEDIDO().setVisible(true);
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
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFECHA;
    private javax.swing.JTextField jTextPEDIDO;
    private javax.swing.JTextField jTextVALOR;
    private javax.swing.JScrollPane tabla;
    // End of variables declaration//GEN-END:variables
}
