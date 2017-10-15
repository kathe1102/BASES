
package ASEGURADORA;

import Conexiones.ASEGURADORA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TBINCIDENTES extends javax.swing.JFrame {
    
    ASEGURADORA op=new ASEGURADORA();
    Connection op1=op.dbaseguradora();
    PreparedStatement r1=null;
    ResultSet r2=null;
    
    public TBINCIDENTES() {
        initComponents();
        cargatabla();
        cargarcombo();
        cargarcombo2();
    }
    
     public void cargatabla(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("Codigo");
        table.addColumn("Fehca ");
        table.addColumn("Placa ");
        table.addColumn("Lugar ");
        table.addColumn("Cantidad Heridos ");
        table.addColumn("Cantidad Fatalidades ");
        table.addColumn("Cantidad Autos Involucrados ");
        jTable1.setModel (table);
        String datos []=new String [7];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbincidentes");
            r2=r1.executeQuery();
            while(r2.next()){
               datos[0]=r2.getString(1);
               datos[1]=r2.getString(2);
               datos[2]=r2.getString(3);
               datos[3]=r2.getString(4);
               datos[4]=r2.getString(5);
               datos[5]=r2.getString(6);
               datos[6]=r2.getString(7);
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
            jTextFECHA.setText(jTable1.getValueAt(list, 1).toString());
             jComboBox2.setSelectedItem(jTable1.getValueAt(list, 2).toString());
            jTextLUGAR.setText(jTable1.getValueAt(list, 3).toString());
            jTextHERIDOS.setText(jTable1.getValueAt(list, 4).toString());
            jTextFATALIDADES.setText(jTable1.getValueAt(list, 5).toString());
            jTextINVOLUCRADOS.setText(jTable1.getValueAt(list, 6).toString());
        }
        
    }
     
     
  
      public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO tbincidentes (incicodigo,incifecha,inciplaca,incilugar,incicantheridos,incicanfatalidades,incicanautosinvolucrados) VALUES(?,?,?,?,?,?,?)");
            r1.setString(1,jTextCODIGO.getText());
            r1.setString(2,jTextFECHA.getText());
            r1.setString(3,jComboBox2.getSelectedItem().toString());
            r1.setString(4,jTextLUGAR.getText());
            r1.setString(5,jTextHERIDOS.getText());
            r1.setString(6,jTextFATALIDADES.getText());
            r1.setString(7,jTextINVOLUCRADOS.getText());
            
                
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Guardados");
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
       public void cargarcombo(){
        try {
            jComboBox1.removeAll();
            jComboBox1.addItem("Seleccione Codigo");
            r1=op1.prepareStatement("SELECT incicodigo from tbincidentes");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("incicodigo");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
       
       public void cargarcombo2(){
        try {
            jComboBox2.removeAll();
            jComboBox2.addItem("Seleccione placa");
            r1=op1.prepareStatement("SELECT Inciplaca from tbincidentes");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("Inciplaca");
                this.jComboBox2.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
     
       public void modificar(String fec,String pla, String lug, String her, String fat, String inv, String cod){
        try {
            r1=op1.prepareStatement("UPDATE tbincidentes set incifecha= '"+fec+"' ,inciplaca= '"+pla+"' , incilugar='"+lug+"', incicantheridos='"+her+"',incicanfatalidades='"+fat+"',incicanautosinvolucrados='"+inv+"'  where  incicodigo='"+cod+"'");
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados ");
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
        
         public void eliminar(String cod){
        try {
         r1=op1.prepareStatement("DELETE from tbincidentes WHERE incicodigo='"+cod+"'");
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
        jTextCODIGO = new javax.swing.JTextField();
        jTextFECHA = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextINVOLUCRADOS = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextLUGAR = new javax.swing.JTextField();
        jTextHERIDOS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextCHASI = new javax.swing.JTextField();
        jTextFATALIDADES = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("REGRESAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(650, 330, 120, 23);

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
        jScrollPane1.setBounds(10, 10, 795, 130);

        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(650, 210, 120, 23);

        jButtonLIMPIO.setText("LIMPIAR");
        jButtonLIMPIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLIMPIOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLIMPIO);
        jButtonLIMPIO.setBounds(650, 300, 120, 23);

        jButtonREGISTRAR.setText("REGISTRAR");
        jButtonREGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonREGISTRARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonREGISTRAR);
        jButtonREGISTRAR.setBounds(650, 240, 120, 23);

        jButtonELIMINA.setText("ELIMINAR");
        jButtonELIMINA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonELIMINAActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonELIMINA);
        jButtonELIMINA.setBounds(650, 270, 120, 23);

        jTextCODIGO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCODIGOKeyTyped(evt);
            }
        });
        getContentPane().add(jTextCODIGO);
        jTextCODIGO.setBounds(170, 430, 170, 30);

        jTextFECHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFECHAActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFECHA);
        jTextFECHA.setBounds(170, 230, 170, 30);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(40, 150, 300, 30);

        jTextINVOLUCRADOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextINVOLUCRADOSActionPerformed(evt);
            }
        });
        jTextINVOLUCRADOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextINVOLUCRADOSKeyTyped(evt);
            }
        });
        getContentPane().add(jTextINVOLUCRADOS);
        jTextINVOLUCRADOS.setBounds(170, 390, 170, 30);

        jLabel4.setText("FECHA");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 240, 50, 20);

        jLabel5.setText("LUGAR");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 280, 50, 20);

        jTextLUGAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextLUGARKeyTyped(evt);
            }
        });
        getContentPane().add(jTextLUGAR);
        jTextLUGAR.setBounds(170, 270, 170, 30);

        jTextHERIDOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextHERIDOSActionPerformed(evt);
            }
        });
        jTextHERIDOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextHERIDOSKeyTyped(evt);
            }
        });
        getContentPane().add(jTextHERIDOS);
        jTextHERIDOS.setBounds(170, 310, 170, 30);

        jLabel6.setText("FATALIDADES");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 360, 80, 20);

        jLabel2.setText("HERIDOS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 320, 60, 20);

        jTextCHASI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCHASIActionPerformed(evt);
            }
        });
        getContentPane().add(jTextCHASI);
        jTextCHASI.setBounds(170, 390, 170, 30);

        jTextFATALIDADES.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFATALIDADESKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFATALIDADES);
        jTextFATALIDADES.setBounds(170, 350, 170, 30);

        jLabel7.setText("AUTOS INVOLUCRADOS");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 400, 170, 20);

        jLabel3.setText("CODIGO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 440, 60, 20);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(40, 190, 300, 30);

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
        String fec, pla, lug, her, fat, inv, cod;

        cod=jComboBox1.getSelectedItem().toString();
        fec=jTextFECHA.getText();
        pla=jComboBox2.getSelectedItem().toString();
        lug=jTextLUGAR.getText();
        her=jTextHERIDOS.getText();
        fat=jTextFATALIDADES.getText();
        inv=jTextINVOLUCRADOS.getText();
        modificar(fec, pla, lug, her, fat, inv, cod);
        cargatabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonLIMPIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLIMPIOActionPerformed
        jComboBox1.removeAllItems();
        cargarcombo();
        jComboBox2.removeAllItems();
        cargarcombo2();
        jTextFECHA.setText(null);
        jTextFATALIDADES.setText(null);
        jTextFATALIDADES.setText(null);
        jTextLUGAR.setText(null);
        jTextHERIDOS.setText(null);
        jTextCODIGO.setText(null);
        jTextINVOLUCRADOS.setText(null);
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

    private void jTextINVOLUCRADOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextINVOLUCRADOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextINVOLUCRADOSActionPerformed

    private void jTextHERIDOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextHERIDOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextHERIDOSActionPerformed

    private void jTextCHASIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCHASIActionPerformed

    }//GEN-LAST:event_jTextCHASIActionPerformed

    private void jTextFECHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFECHAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFECHAActionPerformed

    private void jTextLUGARKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextLUGARKeyTyped
        String txt=jTextLUGAR.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextLUGAR.setText(txt);
        }
         char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextLUGARKeyTyped

    private void jTextHERIDOSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextHERIDOSKeyTyped
                   char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
        
    }//GEN-LAST:event_jTextHERIDOSKeyTyped

    private void jTextFATALIDADESKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFATALIDADESKeyTyped
                   char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
    }//GEN-LAST:event_jTextFATALIDADESKeyTyped

    private void jTextINVOLUCRADOSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextINVOLUCRADOSKeyTyped
                   char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextINVOLUCRADOSKeyTyped

    private void jTextCODIGOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCODIGOKeyTyped
                   char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextCODIGOKeyTyped

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
            java.util.logging.Logger.getLogger(TBINCIDENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TBINCIDENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TBINCIDENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TBINCIDENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBINCIDENTES().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCHASI;
    private javax.swing.JTextField jTextCODIGO;
    private javax.swing.JTextField jTextFATALIDADES;
    private javax.swing.JTextField jTextFECHA;
    private javax.swing.JTextField jTextHERIDOS;
    private javax.swing.JTextField jTextINVOLUCRADOS;
    private javax.swing.JTextField jTextLUGAR;
    // End of variables declaration//GEN-END:variables
}
