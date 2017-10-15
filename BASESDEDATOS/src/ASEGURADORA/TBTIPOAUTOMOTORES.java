
package ASEGURADORA;

import Conexiones.ASEGURADORA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TBTIPOAUTOMOTORES extends javax.swing.JFrame {
    ASEGURADORA op=new ASEGURADORA();
    Connection op1=op.dbaseguradora();
    PreparedStatement r1=null;
    ResultSet r2=null;
    
    public TBTIPOAUTOMOTORES() {
        initComponents();
        cargatabla();
        cargarcombo();
    }
    
    public void cargatabla(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("Tipo");
        table.addColumn("Nombre");
        jTable1.setModel (table);
        String datos []=new String [2];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbtipoautomotores");
            r2=r1.executeQuery();
            while(r2.next()){
               datos[0]=r2.getString(1);
               datos[1]=r2.getString(2);
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
            
        }
        
    }
   
      public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO tbtipoautomotores (auttipo,aut_nombre) VALUES(?,?)");
            r1.setString(1,jTextTIPO.getText());
            r1.setString(2,jTextNOMBRE.getText());
            
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Guardados");
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
       public void cargarcombo(){
        try {
            jComboBox1.removeAll();
            jComboBox1.addItem("Seleccione Tipo");
            r1=op1.prepareStatement("SELECT auttipo from tbtipoautomotores");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("auttipo");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
     
       public void modificar(String nom,String tip){
        try {
            r1=op1.prepareStatement("UPDATE tbtipoautomotores set aut_nombre='"+nom+"'   where  auttipo='"+tip+"'");
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados ");
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
        
         public void eliminar(String cod){
        try {
         r1=op1.prepareStatement("DELETE from tbtipoautomotores WHERE auttipo='"+cod+"'");
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextTIPO = new javax.swing.JTextField();
        jTextNOMBRE = new javax.swing.JTextField();

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

        jLabel4.setText("NOMBRE");

        jLabel1.setText("TIPO");

        jTextTIPO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTIPOKeyTyped(evt);
            }
        });

        jTextNOMBRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNOMBREActionPerformed(evt);
            }
        });
        jTextNOMBRE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNOMBREKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(390, 390, 390)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jTextNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(390, 390, 390)
                .addComponent(jButtonREGISTRAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextTIPO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(390, 390, 390)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonELIMINA, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLIMPIO, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(740, 740, 740)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton2)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonREGISTRAR))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextTIPO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonELIMINA)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonLIMPIO)))
                .addGap(7, 7, 7)
                .addComponent(jButton1)
                .addContainerGap(21, Short.MAX_VALUE))
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
        String nom, tip;

        tip=jComboBox1.getSelectedItem().toString();
        nom=jTextNOMBRE.getText();
        modificar(nom, tip);
        cargatabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonLIMPIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLIMPIOActionPerformed
        jComboBox1.removeAllItems();
        cargarcombo();
        jTextNOMBRE.setText(null);
        jTextTIPO.setText(null);
        
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

    private void jTextNOMBREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNOMBREActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNOMBREActionPerformed

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

    private void jTextTIPOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTIPOKeyTyped
                char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextTIPOKeyTyped

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
            java.util.logging.Logger.getLogger(TBTIPOAUTOMOTORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TBTIPOAUTOMOTORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TBTIPOAUTOMOTORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TBTIPOAUTOMOTORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBTIPOAUTOMOTORES().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextNOMBRE;
    private javax.swing.JTextField jTextTIPO;
    // End of variables declaration//GEN-END:variables
}
