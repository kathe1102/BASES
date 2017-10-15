
package LIBRERIA;

import Conexiones.LIBRERIADB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TBARTICULOXPEDIDO extends javax.swing.JFrame {
    LIBRERIADB op=new LIBRERIADB();
    Connection op1=op.dblibreria();
    PreparedStatement r1=null;
    ResultSet r2=null;
    
  
    public TBARTICULOXPEDIDO() {
        initComponents();
        cargatabla();
        cargarcombo();
        cargarcombo2();
    }
    public void cargatabla(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("ID Pedido ArtPed");
        table.addColumn("ID Articulo ArtPed  ");
        table.addColumn("Cantidad Articulo ArtPed  ");
        table.addColumn("Valor Ven Art ArtPed ");
        jTable1.setModel (table);
        String datos []=new String [4];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbarticuloxpedido");
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
            jTextCANTIDAD.setText(jTable1.getValueAt(list, 2).toString());
            jTextVALORVENT.setText(jTable1.getValueAt(list, 3).toString());
            
        }
        
    }
     
    
      public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO tbarticuloxpedido (Id_ped_artped,Id_art_artped,Can_art_artped, Val_ven_art_artped) VALUES(?,?,?,?)");
            r1.setString(1,jTextPEDIDO.getText());
            r1.setString(2,jComboBox2.getSelectedItem().toString());
            r1.setString(3,jTextCANTIDAD.getText());
            r1.setString(4,jTextVALORVENT.getText());
                     
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
            r1=op1.prepareStatement("SELECT  Id_ped_artped from tbarticuloxpedido");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString(" Id_ped_artped");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
       
         public void cargarcombo2(){
        try {
            jComboBox2.removeAll();
            jComboBox2.addItem("Seleccione ID Articulo");
            r1=op1.prepareStatement("SELECT  Id_art_artped from tbarticuloxpedido");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString(" Id_art_artped");
                this.jComboBox2.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
     
       public void modificar(String art,String can, String ven, String ped){
        try {
            r1=op1.prepareStatement("UPDATE tbarticuloxpedido set Id_art_artped= '"+art+"' ,  Can_art_artped='"+can+"', Val_ven_art_artped='"+ven+"' where  Id_ped_artped= '"+ped+"' ");
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados ");
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
        
         public void eliminar(String cod){
        try {
         r1=op1.prepareStatement("DELETE from tbarticuloxpedido WHERE Id_ped_artped='"+cod+"'");
         r1.executeUpdate();
         JOptionPane.showMessageDialog(null,"Datos Eliminados ");
         
        } catch (Exception e) {
            System.out.print(e);
        }
        
      }
        
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButtonREGISTRAR = new javax.swing.JButton();
        jButtonELIMINA = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonLIMPIO = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextCANTIDAD = new javax.swing.JTextField();
        jTextVALORVENT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextPEDIDO = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();

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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 11, 811, 135);

        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(680, 300, 120, 23);

        jButtonREGISTRAR.setText("REGISTRAR");
        jButtonREGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonREGISTRARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonREGISTRAR);
        jButtonREGISTRAR.setBounds(680, 210, 120, 23);

        jButtonELIMINA.setText("ELIMINAR");
        jButtonELIMINA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonELIMINAActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonELIMINA);
        jButtonELIMINA.setBounds(680, 240, 120, 23);

        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(680, 180, 120, 23);

        jButtonLIMPIO.setText("LIMPIAR");
        jButtonLIMPIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLIMPIOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLIMPIO);
        jButtonLIMPIO.setBounds(680, 270, 120, 23);

        jLabel5.setText("CAN ART ARTPED");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 250, 120, 20);

        jTextCANTIDAD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCANTIDADKeyTyped(evt);
            }
        });
        getContentPane().add(jTextCANTIDAD);
        jTextCANTIDAD.setBounds(160, 240, 170, 30);

        jTextVALORVENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextVALORVENTActionPerformed(evt);
            }
        });
        jTextVALORVENT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextVALORVENTKeyTyped(evt);
            }
        });
        getContentPane().add(jTextVALORVENT);
        jTextVALORVENT.setBounds(160, 280, 170, 30);

        jLabel6.setText("ID PED ARTPED");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 330, 120, 20);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(30, 160, 300, 30);

        jLabel2.setText("VAL VEN ART ARTPED");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 290, 140, 20);

        jTextPEDIDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPEDIDOActionPerformed(evt);
            }
        });
        jTextPEDIDO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPEDIDOKeyTyped(evt);
            }
        });
        getContentPane().add(jTextPEDIDO);
        jTextPEDIDO.setBounds(160, 320, 170, 30);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(30, 200, 300, 30);

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
        eliminar(cod);
        cargatabla();
    }//GEN-LAST:event_jButtonELIMINAActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String art, can, ven, ped;

        ped=jComboBox1.getSelectedItem().toString();
        art=jComboBox2.getSelectedItem().toString();
        can=jTextCANTIDAD.getText();
        ven=jTextVALORVENT.getText();
        modificar(art, can, ven, ped);
        cargatabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonLIMPIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLIMPIOActionPerformed
        jComboBox1.removeAllItems();
        cargarcombo();
        jComboBox2.removeAllItems();
        cargarcombo2();
        jTextCANTIDAD.setText(null);
        
        jTextVALORVENT.setText(null);
        jTextPEDIDO.setText(null);
    }//GEN-LAST:event_jButtonLIMPIOActionPerformed

    private void jTextVALORVENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextVALORVENTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextVALORVENTActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextPEDIDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPEDIDOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPEDIDOActionPerformed

    private void jTextCANTIDADKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCANTIDADKeyTyped
                    char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
    }//GEN-LAST:event_jTextCANTIDADKeyTyped

    private void jTextVALORVENTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextVALORVENTKeyTyped
                    char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
    }//GEN-LAST:event_jTextVALORVENTKeyTyped

    private void jTextPEDIDOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPEDIDOKeyTyped
                    char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextPEDIDOKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        listardatos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    
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
            java.util.logging.Logger.getLogger(TBARTICULOXPEDIDO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TBARTICULOXPEDIDO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TBARTICULOXPEDIDO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TBARTICULOXPEDIDO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBARTICULOXPEDIDO().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCANTIDAD;
    private javax.swing.JTextField jTextPEDIDO;
    private javax.swing.JTextField jTextVALORVENT;
    // End of variables declaration//GEN-END:variables
}
