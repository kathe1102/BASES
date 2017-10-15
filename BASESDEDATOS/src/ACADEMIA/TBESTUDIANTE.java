
package ACADEMIA;

import Conexiones.ACADEMIADB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TBESTUDIANTE extends javax.swing.JFrame {
        ACADEMIADB op=new ACADEMIADB();
        Connection op1=op.dbacademia();
        PreparedStatement r1=null;
        ResultSet r2=null;
    
    public TBESTUDIANTE() {
        initComponents();
        cargatabla();
        cargarcombo();
    }
    
    public void  cargatabla(){
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("Documento Estudiante");
        table.addColumn("Nombre Estudiante");
        table.addColumn("Apellido Estudiante");
        table.addColumn("Edad Estudiante");
        jTableTABLE.setModel(table);
        String datos []=new String [5];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbestudiante ");
            r2=r1.executeQuery();
            while (r2.next()){
                datos[0]=r2.getString(1);
                datos[1]=r2.getString(2);
                datos[2]=r2.getString(3);
                datos[3]=r2.getString(4);
                table.addRow(datos);
            }
            
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
    
     public void  filtro1(){
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("Documento Estudiante");
        table.addColumn("Nombre Estudiante");
        table.addColumn("Apellido Estudiante");
        table.addColumn("Edad Estudiante");
        jTableTABLE.setModel(table);
        String datos []=new String [5];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbestudiante  where docest like '%"+jTextFILTRO.getText()+"%' or estnomest like '%"+jTextFILTRO.getText()+"%' or estapeest like '%"+jTextFILTRO.getText()+"%' or estedadest like '%"+jTextFILTRO.getText()+"%'   ");
            r2=r1.executeQuery();
            while (r2.next()){
                datos[0]=r2.getString(1);
                datos[1]=r2.getString(2);
                datos[2]=r2.getString(3);
                datos[3]=r2.getString(4);
                table.addRow(datos);
            }
            
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
   
     public void  filtro2(){
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("Documento Estudiante");
        table.addColumn("Nombre Estudiante");
        table.addColumn("Apellido Estudiante");
        table.addColumn("Edad Estudiante");
        jTableTABLE.setModel(table);
        String datos []=new String [5];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbestudiante  where docest like '%"+jComboBox1.getSelectedItem().toString()+"%'     ");
            r2=r1.executeQuery();
            while (r2.next()){
                datos[0]=r2.getString(1);
                datos[1]=r2.getString(2);
                datos[2]=r2.getString(3);
                datos[3]=r2.getString(4);
                table.addRow(datos);
            }
            
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
    
    
    
     public void listardatos(){
        int list=jTableTABLE.getSelectedRow();
        if(list>=0){
            jComboBox1.setSelectedItem(jTableTABLE.getValueAt(list,0).toString());
            jTextNOMBREESTUDIANTE.setText(jTableTABLE.getValueAt(list, 1).toString());
            jTextAPELLIDO.setText(jTableTABLE.getValueAt(list, 2).toString());
            jTextEDAD.setText(jTableTABLE.getValueAt(list, 3).toString());
        }
        
    }
    
    
     public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO Tbestudiante (docest,estnomest,estapeest,estedadest) VALUES(?,?,?,?)");
            r1.setString(1,jTextDOCUMENTO.getText());
            r1.setString(2,jTextNOMBREESTUDIANTE.getText());
            r1.setString(3,jTextAPELLIDO.getText());
            r1.setString(4,jTextEDAD.getText());
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Guardados");
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
     
         public void cargarcombo(){
        try {
            jComboBox1.removeAll();
            jComboBox1.addItem("Seleccionar Documento");
            r1=op1.prepareStatement("SELECT docest from tbestudiante");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("docest");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    }
        public void modificar(String doc, String nom, String ape, String edad){
        try {
            r1=op1.prepareStatement("UPDATE tbestudiante set estnomest ='"+nom+"',estapeest='"+ape+"', estedadest='"+edad+"' where  docest='"+doc+"'");
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados ");
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
            
     
          public void eliminar(String cod){
        try {
         r1=op1.prepareStatement("DELETE from Tbestudiante WHERE docest='"+cod+"'");
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
        jTableTABLE = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButtonGUARDAR = new javax.swing.JButton();
        jButtonELIMINAR = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextNOMBREESTUDIANTE = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextAPELLIDO = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextEDAD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextDOCUMENTO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextFILTRO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableTABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTABLEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTABLE);

        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonGUARDAR.setText("GUARDAR");
        jButtonGUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGUARDARActionPerformed(evt);
            }
        });

        jButtonELIMINAR.setText("ELIMINAR ");
        jButtonELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonELIMINARActionPerformed(evt);
            }
        });

        jButton2.setText("MODIFICAR ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextNOMBREESTUDIANTE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNOMBREESTUDIANTEKeyTyped(evt);
            }
        });

        jLabel3.setText("APELLIDO");

        jTextAPELLIDO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAPELLIDOKeyTyped(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("EDAD ");

        jTextEDAD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextEDADKeyTyped(evt);
            }
        });

        jLabel5.setText("DOCUMENTO ESTUDIANTE");

        jTextDOCUMENTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDOCUMENTOActionPerformed(evt);
            }
        });
        jTextDOCUMENTO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDOCUMENTOKeyTyped(evt);
            }
        });

        jLabel2.setText("NOMBRE ");

        jButton4.setText("BUSCAR");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jTextFILTRO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFILTROKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jTextNOMBREESTUDIANTE, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFILTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jTextEDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jTextDOCUMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextNOMBREESTUDIANTE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFILTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonGUARDAR)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextEDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextDOCUMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        String d,n,a,e;

        d=jComboBox1.getSelectedItem().toString();
        n=jTextNOMBREESTUDIANTE.getText();
        a=jTextAPELLIDO.getText();
        e=jTextEDAD.getText();
        modificar(d, n, a,e);
        cargatabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        jComboBox1.removeAllItems();
        cargarcombo();
        jTextAPELLIDO.setText(null);
        jTextNOMBREESTUDIANTE.setText(null);
        jTextEDAD.setText(null);
        jTextDOCUMENTO.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextDOCUMENTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDOCUMENTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDOCUMENTOActionPerformed

    private void jTextNOMBREESTUDIANTEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNOMBREESTUDIANTEKeyTyped
        String txt=jTextNOMBREESTUDIANTE.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextNOMBREESTUDIANTE.setText(txt);
        }
         char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
     }
    }//GEN-LAST:event_jTextNOMBREESTUDIANTEKeyTyped

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

    private void jTextEDADKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextEDADKeyTyped
        char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextEDADKeyTyped

    private void jTextDOCUMENTOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDOCUMENTOKeyTyped
        char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
    }//GEN-LAST:event_jTextDOCUMENTOKeyTyped

    private void jTableTABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTABLEMouseClicked
        listardatos();
    }//GEN-LAST:event_jTableTABLEMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        filtro2();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jTextFILTROKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFILTROKeyReleased
        filtro1();
    }//GEN-LAST:event_jTextFILTROKeyReleased

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBESTUDIANTE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonELIMINAR;
    private javax.swing.JButton jButtonGUARDAR;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTABLE;
    private javax.swing.JTextField jTextAPELLIDO;
    private javax.swing.JTextField jTextDOCUMENTO;
    private javax.swing.JTextField jTextEDAD;
    private javax.swing.JTextField jTextFILTRO;
    private javax.swing.JTextField jTextNOMBREESTUDIANTE;
    // End of variables declaration//GEN-END:variables
}
