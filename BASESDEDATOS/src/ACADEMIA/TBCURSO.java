package ACADEMIA;


import Conexiones.ACADEMIADB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class TBCURSO extends javax.swing.JFrame {
        ACADEMIADB op=new ACADEMIADB();
        Connection op1=op.dbacademia();
        PreparedStatement r1=null;
        ResultSet r2=null;
                
    public TBCURSO() {
        initComponents();
            cargatabla();
            cargarcombo();
         }

    public void cargatabla () {
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("Codigo del Curso");
        table.addColumn("Nombre del Curso");
        table.addColumn("Horas del Curso");
        table.addColumn("Valor del Curso");
        jTableTABLA.setModel(table);
        String datos [] =new String[5];
        
        try {
          r1=op1.prepareStatement("SELECT * FROM tbcursos ");  
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
        int list=jTableTABLA.getSelectedRow();
        if(list>=0){
            jComboBox1.setSelectedItem(jTableTABLA.getValueAt(list,0).toString());
            jTextNOMBRECURSO.setText(jTableTABLA.getValueAt(list, 1).toString());
            jTextHORASCURSO.setText(jTableTABLA.getValueAt(list, 2).toString());
            jTextVALORCURSO.setText(jTableTABLA.getValueAt(list, 3).toString());
        }
        
    }
    
    
       public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO Tbcursos (curCodCurs,CurNOmCurs,CurHorasCur,CurValorCur) VALUES(?,?,?,?)");
            r1.setString(1,jTextCODIGO.getText());
            r1.setString(2,jTextNOMBRECURSO.getText());
            r1.setString(3,jTextHORASCURSO.getText());
            r1.setString(4,jTextVALORCURSO.getText());
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Guardados");
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
       public void cargarcombo(){
        try {
            jComboBox1.removeAll();
            jComboBox1.addItem("Seleccionar Codigo");
            r1=op1.prepareStatement("SELECT curcodcurs from tbcursos");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("curCodCurs");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    }
       
       
           public void modificar(String cod, String cur, String hor, String val){
        try {
            r1=op1.prepareStatement("UPDATE tbcursos set curnomcurs ='"+cur+"',curhorascur='"+hor+"', curvalorcur='"+val+"' where  curCodcurs='"+cod+"'");
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados ");
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
           
       public void eliminar(String cod){
        try {
         r1=op1.prepareStatement("DELETE from Tbcursos WHERE CurCodCurs='"+cod+"'");
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
        jTableTABLA = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButtonGUARDAR = new javax.swing.JButton();
        jButtonELIMINAR = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextNOMBRECURSO = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextHORASCURSO = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextVALORCURSO = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextCODIGO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableTABLA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableTABLA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTABLAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTABLA);

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

        jLabel2.setText("NOMBRE CURSO ");

        jTextNOMBRECURSO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNOMBRECURSOKeyTyped(evt);
            }
        });

        jLabel3.setText("HORAS DEL CURSO ");

        jTextHORASCURSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextHORASCURSOActionPerformed(evt);
            }
        });
        jTextHORASCURSO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextHORASCURSOKeyTyped(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("VALOR DEL CURSO ");

        jTextVALORCURSO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextVALORCURSOKeyTyped(evt);
            }
        });

        jLabel5.setText("CREAR CODIGO CURSO");

        jTextCODIGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCODIGOActionPerformed(evt);
            }
        });
        jTextCODIGO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCODIGOKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jTextNOMBRECURSO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(jButtonGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTextHORASCURSO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTextVALORCURSO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jTextCODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextNOMBRECURSO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGUARDAR))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextHORASCURSO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextVALORCURSO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        String c,n,h,v;

        c=jComboBox1.getSelectedItem().toString();
        n=jTextNOMBRECURSO.getText();
        h=jTextHORASCURSO.getText();
        v=jTextVALORCURSO.getText();
        modificar(c, n, h,v);
        cargatabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        jComboBox1.removeAllItems();
        cargarcombo();
        jTextHORASCURSO.setText(null);
        jTextNOMBRECURSO.setText(null);
        jTextVALORCURSO.setText(null);
        jTextCODIGO.setText(null);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextCODIGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCODIGOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCODIGOActionPerformed

    private void jTextNOMBRECURSOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNOMBRECURSOKeyTyped
        String txt=jTextNOMBRECURSO.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextNOMBRECURSO.setText(txt);
        }
         char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextNOMBRECURSOKeyTyped

    private void jTextHORASCURSOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextHORASCURSOKeyTyped
     char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
    }//GEN-LAST:event_jTextHORASCURSOKeyTyped

    private void jTextHORASCURSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextHORASCURSOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextHORASCURSOActionPerformed

    private void jTextVALORCURSOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextVALORCURSOKeyTyped
       char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
    }//GEN-LAST:event_jTextVALORCURSOKeyTyped

    private void jTextCODIGOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCODIGOKeyTyped
       char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextCODIGOKeyTyped

    private void jTableTABLAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTABLAMouseClicked
       listardatos();
    }//GEN-LAST:event_jTableTABLAMouseClicked

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBCURSO().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTABLA;
    private javax.swing.JTextField jTextCODIGO;
    private javax.swing.JTextField jTextHORASCURSO;
    private javax.swing.JTextField jTextNOMBRECURSO;
    private javax.swing.JTextField jTextVALORCURSO;
    // End of variables declaration//GEN-END:variables

    private Connection dbacademia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private PreparedStatement prepareStatement(String select__from_TbUsuario_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
