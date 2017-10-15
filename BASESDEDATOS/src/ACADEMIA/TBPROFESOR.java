
package ACADEMIA;

import Conexiones.ACADEMIADB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TBPROFESOR extends javax.swing.JFrame {
    ACADEMIADB op=new ACADEMIADB();
    Connection op1=op.dbacademia();
    PreparedStatement r1=null;
    ResultSet r2=null;
    
   
    public TBPROFESOR() {
        initComponents();
        cargatabla();
        cargarcombo();
    }
    
    public void cargatabla(){
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("Documento  ");
        table.addColumn("Nombre  ");
        table.addColumn("Apellido  ");
        table.addColumn("Categoria ");
        table.addColumn("Salario ");
        jTable1.setModel(table);
        String datos[]=new String[6];
        
        try {
         r1=op1.prepareStatement("SELECT * FROM tbprofesor");
         r2=r1.executeQuery();
         while (r2.next()){
             datos[0]=r2.getString(1);
             datos[1]=r2.getString(2);
             datos[2]=r2.getString(3);
             datos[3]=r2.getString(4);
             datos[4]=r2.getString(5);
             table.addRow(datos);
         }
            
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
    
     public void listardatos(){
        int list=jTable1.getSelectedRow();
        if(list>=0){
            jComboBox1.setSelectedItem(jTable1.getValueAt(list,0).toString());
            jTextNOMBRE.setText(jTable1.getValueAt(list, 1).toString());
            jTextAPELLIDO.setText(jTable1.getValueAt(list, 2).toString());
            jTextCATEGORIA.setText(jTable1.getValueAt(list, 3).toString());
            jTextSALARIO.setText(jTable1.getValueAt(list, 4).toString());
           }
        
    }
    
    
    
     public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO Tbprofesor (docprof,pronomprot,proapeprof,procateprof,prosalprof) VALUES(?,?,?,?,?)");
            r1.setString(1,jTextDOCUMENTO.getText());
            r1.setString(2,jTextNOMBRE.getText());
            r1.setString(3,jTextAPELLIDO.getText());
            r1.setString(4,jTextCATEGORIA.getText());
            r1.setString(5,jTextSALARIO.getText());
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
            r1=op1.prepareStatement("SELECT docprof from tbprofesor");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("docprof");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
     
       public void modificar(String doc,String nom, String ape, String cat, String sal){
        try {
            r1=op1.prepareStatement("UPDATE tbprofesor set pronomprot ='"+nom+"',proapeprof='"+ape+"',procateprof='"+cat+"',prosalprof='"+sal+"' where  docprof='"+doc+"'");
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados ");
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
        
         public void eliminar(String doc){
        try {
         r1=op1.prepareStatement("DELETE from Tbprofesor WHERE docprof='"+doc+"'");
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
        jButtonGUARDAR = new javax.swing.JButton();
        jButtonELIMINAR = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextAPELLIDO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextDOCUMENTO = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextNOMBRE = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextCATEGORIA = new javax.swing.JTextField();
        jTextSALARIO = new javax.swing.JTextField();

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
        jScrollPane1.setBounds(10, 11, 790, 160);

        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(660, 340, 120, 23);

        jButtonGUARDAR.setText("GUARDAR");
        jButtonGUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGUARDARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGUARDAR);
        jButtonGUARDAR.setBounds(660, 250, 120, 23);

        jButtonELIMINAR.setText("ELIMINAR ");
        jButtonELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonELIMINARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonELIMINAR);
        jButtonELIMINAR.setBounds(660, 280, 120, 20);

        jButton2.setText("MODIFICAR ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(660, 220, 120, 23);

        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(660, 310, 120, 20);

        jTextAPELLIDO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAPELLIDOKeyTyped(evt);
            }
        });
        getContentPane().add(jTextAPELLIDO);
        jTextAPELLIDO.setBounds(170, 270, 170, 30);

        jLabel2.setText("DOCUMENTO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 400, 120, 20);

        jTextDOCUMENTO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDOCUMENTOKeyTyped(evt);
            }
        });
        getContentPane().add(jTextDOCUMENTO);
        jTextDOCUMENTO.setBounds(170, 390, 170, 30);

        jLabel3.setText("NOMBRE");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 240, 80, 20);

        jTextNOMBRE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNOMBREKeyTyped(evt);
            }
        });
        getContentPane().add(jTextNOMBRE);
        jTextNOMBRE.setBounds(170, 230, 170, 30);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(40, 190, 300, 30);

        jLabel4.setText("APELLIDO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 280, 80, 20);

        jLabel1.setText("CATEGORIA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 320, 80, 20);

        jLabel5.setText("SALARIO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 360, 80, 20);

        jTextCATEGORIA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCATEGORIAKeyTyped(evt);
            }
        });
        getContentPane().add(jTextCATEGORIA);
        jTextCATEGORIA.setBounds(170, 310, 170, 30);

        jTextSALARIO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextSALARIOKeyTyped(evt);
            }
        });
        getContentPane().add(jTextSALARIO);
        jTextSALARIO.setBounds(170, 350, 170, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MENU op=new MENU();
        op.setVisible(true);
        dispose();
        op.setLocation(300,100);
        op.setSize(300, 350);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGUARDARActionPerformed
        registrar();
        cargatabla();
    }//GEN-LAST:event_jButtonGUARDARActionPerformed

    private void jButtonELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonELIMINARActionPerformed
        String cod=jComboBox1.getSelectedItem().toString();
        eliminar(cod);
        cargatabla();
    }//GEN-LAST:event_jButtonELIMINARActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String d,n,a,c,s;

        d=jComboBox1.getSelectedItem().toString();
        n=jTextNOMBRE.getText();
        a=jTextAPELLIDO.getText();
        c=jTextCATEGORIA.getText();
        s=jTextSALARIO.getText();
        modificar(d, n, a, c, s);
        cargatabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        jComboBox1.removeAllItems();
        cargarcombo();
        jTextNOMBRE.setText(null);
        jTextDOCUMENTO.setText(null);
        jTextAPELLIDO.setText(null);
        jTextDOCUMENTO.setText(null);
        jTextCATEGORIA.setText(null);
        jTextSALARIO.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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

    private void jTextAPELLIDOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAPELLIDOKeyTyped
       String txt=jTextAPELLIDO.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextAPELLIDO.setText(txt);
        }
         char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextAPELLIDOKeyTyped

    private void jTextCATEGORIAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCATEGORIAKeyTyped
            char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
    }//GEN-LAST:event_jTextCATEGORIAKeyTyped

    private void jTextSALARIOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSALARIOKeyTyped
            char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
    }//GEN-LAST:event_jTextSALARIOKeyTyped

    private void jTextDOCUMENTOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDOCUMENTOKeyTyped
            char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
    }//GEN-LAST:event_jTextDOCUMENTOKeyTyped

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
            java.util.logging.Logger.getLogger(TBPROFESOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TBPROFESOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TBPROFESOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TBPROFESOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBPROFESOR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonELIMINAR;
    private javax.swing.JButton jButtonGUARDAR;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextAPELLIDO;
    private javax.swing.JTextField jTextCATEGORIA;
    private javax.swing.JTextField jTextDOCUMENTO;
    private javax.swing.JTextField jTextNOMBRE;
    private javax.swing.JTextField jTextSALARIO;
    // End of variables declaration//GEN-END:variables
}
