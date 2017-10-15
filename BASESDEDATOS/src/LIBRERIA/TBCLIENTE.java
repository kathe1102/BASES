
package LIBRERIA;

import Conexiones.LIBRERIADB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TBCLIENTE extends javax.swing.JFrame {
    LIBRERIADB op=new LIBRERIADB();
    Connection op1=op.dblibreria();
    PreparedStatement r1=null;
    ResultSet r2=null;
   
    public TBCLIENTE() {
        initComponents();
        cargatabla();
        cargarcombo();
    }
    
    public void cargatabla(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("ID ");
        table.addColumn("Nombre  ");
        table.addColumn("Apellido  ");
        table.addColumn("Direccion ");
        table.addColumn("Departamento ");
        table.addColumn("Mes  ");
        jTable1.setModel (table);
        String datos []=new String [6];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbcliente");
            r2=r1.executeQuery();
            while(r2.next()){
               datos[0]=r2.getString(1);
               datos[1]=r2.getString(2);
               datos[2]=r2.getString(3);
               datos[3]=r2.getString(4);
               datos[4]=r2.getString(5);
               datos[5]=r2.getString(6);
               table.addRow(datos);
            
            }
        } catch (Exception e) {
            System.out.print (e);
        }
        
    }
    
     public void filtro2(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("ID ");
        table.addColumn("Nombre  ");
        table.addColumn("Apellido  ");
        table.addColumn("Direccion ");
        table.addColumn("Departamento ");
        table.addColumn("Mes  ");
        jTable1.setModel (table);
        String datos []=new String [6];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbcliente where  id_cli like '%"+jComboBox1.getSelectedItem().toString()+"%'");
            r2=r1.executeQuery();
            while(r2.next()){
               datos[0]=r2.getString(1);
               datos[1]=r2.getString(2);
               datos[2]=r2.getString(3);
               datos[3]=r2.getString(4);
               datos[4]=r2.getString(5);
               datos[5]=r2.getString(6);
               table.addRow(datos);
            
            }
        } catch (Exception e) {
            System.out.print (e);
        }
        
    }
    
    
    public void filtro1(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("ID ");
        table.addColumn("Nombre  ");
        table.addColumn("Apellido  ");
        table.addColumn("Direccion ");
        table.addColumn("Departamento ");
        table.addColumn("Mes  ");
        jTable1.setModel (table);
        String datos []=new String [6];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbcliente where  id_cli like '%"+jTextBUSQUEDA.getText()+"%'  or Nom_cli like '%"+jTextBUSQUEDA.getText()+"%'  or Ape_cli like '%"+jTextBUSQUEDA.getText()+"%' or Dir_cli like '%"+jTextBUSQUEDA.getText()+"%'  or Dep_cli like '%"+jTextBUSQUEDA.getText()+"%'  or Mes_cum_cli like '%"+jTextBUSQUEDA.getText()+"%' ");
            r2=r1.executeQuery();
            while(r2.next()){
               datos[0]=r2.getString(1);
               datos[1]=r2.getString(2);
               datos[2]=r2.getString(3);
               datos[3]=r2.getString(4);
               datos[4]=r2.getString(5);
               datos[5]=r2.getString(6);
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
            jTextAPELLIDO.setText(jTable1.getValueAt(list, 2).toString());
            jTextDIRECCION.setText(jTable1.getValueAt(list, 3).toString());
            jTextDEPARTAMENTO.setText(jTable1.getValueAt(list, 4).toString());
            jTextMES.setText(jTable1.getValueAt(list, 5).toString());
        }
        
    }
      
     public void listardatos2(){
        int list1 =jComboBox1.getSelectedIndex();
        //if(list1>=0){
            //jComboBox1.setSelectedItem(jTable1.getValueAt(list1,0).toString());
            jTextNOMBRE.setText(jTable1.getValueAt(list1, 0).toString());
            jTextAPELLIDO.setText(jTable1.getValueAt(list1, 1).toString());
            jTextDIRECCION.setText(jTable1.getValueAt(list1, 2).toString());
            jTextDEPARTAMENTO.setText(jTable1.getValueAt(list1, 3).toString());
            jTextMES.setText(jTable1.getValueAt(list1, 4).toString());
        //}
        
    }
     
     
    
      public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO TbCliente(Id_cli,Nom_cli,Ape_cli,Dir_cli,Dep_cli,Mes_cum_cli)VALUES(?,?,?,?,?,?)");
            r1.setString(1,jTextID.getText());
            r1.setString(2,jTextNOMBRE.getText());
            r1.setString(3,jTextAPELLIDO.getText());
            r1.setString(4,jTextDIRECCION.getText());
            r1.setString(5,jTextDEPARTAMENTO.getText());
            r1.setString(6,jTextMES.getText());
                     
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Guardados");
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
       public void cargarcombo(){
        try {
            jComboBox1.removeAll();
            jComboBox1.addItem("Seleccione ID cliente");
            r1=op1.prepareStatement("SELECT  id_cli from tbcliente");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("id_cli");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
     
       public void modificar(String nom,String ape, String dir, String dep, String mes, String id){
        try {
            r1=op1.prepareStatement("UPDATE tbcliente set nom_cli='"+nom+"', ape_cli='"+ape+"', dir_cli='"+dir+"', dep_cli='"+dep+"', mes_cum_cli='"+mes+"' where  id_cli= '"+id+"' ");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextMES = new javax.swing.JTextField();
        jTextID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextDIRECCION = new javax.swing.JTextField();
        jTextDEPARTAMENTO = new javax.swing.JTextField();
        jTextAPELLIDO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextNOMBRE = new javax.swing.JTextField();
        jTextCHASI = new javax.swing.JTextField();
        jButtonREGISTRAR = new javax.swing.JButton();
        jButtonELIMINA = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonLIMPIO = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextBUSQUEDA = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jButton1.setText("REGRESAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextMES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMESActionPerformed(evt);
            }
        });
        jTextMES.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMESKeyTyped(evt);
            }
        });

        jTextID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIDActionPerformed(evt);
            }
        });
        jTextID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextIDKeyTyped(evt);
            }
        });

        jLabel7.setText("MES");

        jLabel4.setText("ID");

        jLabel1.setText("NOMBRE");

        jLabel5.setText("APELLIDO");

        jTextDEPARTAMENTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDEPARTAMENTOActionPerformed(evt);
            }
        });
        jTextDEPARTAMENTO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDEPARTAMENTOKeyTyped(evt);
            }
        });

        jTextAPELLIDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAPELLIDOActionPerformed(evt);
            }
        });
        jTextAPELLIDO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAPELLIDOKeyTyped(evt);
            }
        });

        jLabel6.setText("DEPARTAMENTO");

        jLabel2.setText("DIRECCION");

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

        jTextCHASI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCHASIActionPerformed(evt);
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

        jButton3.setText("BUSCAR");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jTextBUSQUEDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextBUSQUEDAKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jTextBUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(370, 370, 370)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextDIRECCION, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(370, 370, 370)
                .addComponent(jButtonREGISTRAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextDEPARTAMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMES, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(370, 370, 370)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonELIMINA, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLIMPIO, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCHASI, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextBUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextDIRECCION, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonREGISTRAR))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextDEPARTAMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextMES, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonELIMINA)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonLIMPIO)
                        .addGap(7, 7, 7)
                        .addComponent(jButton1)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCHASI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIDActionPerformed

    private void jTextDEPARTAMENTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDEPARTAMENTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDEPARTAMENTOActionPerformed

    private void jTextNOMBREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNOMBREActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNOMBREActionPerformed

    private void jTextCHASIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCHASIActionPerformed

    }//GEN-LAST:event_jTextCHASIActionPerformed

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
        String nom, ape, dir, dep, mes, id;

        id=jComboBox1.getSelectedItem().toString();
        nom=jTextNOMBRE.getText();
        ape=jTextAPELLIDO.getText();
        dir=jTextDIRECCION.getText();
        dep=jTextDEPARTAMENTO.getText();
        mes=jTextMES.getText();
        modificar(nom, ape, dir, dep, mes, id);
        cargatabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonLIMPIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLIMPIOActionPerformed
        jComboBox1.removeAllItems();
        cargarcombo();
        jTextAPELLIDO.setText(null);
        jTextDEPARTAMENTO.setText(null);
        jTextDIRECCION.setText(null);
        jTextID.setText(null);
        jTextMES.setText(null);
        jTextNOMBRE.setText(null);
    }//GEN-LAST:event_jButtonLIMPIOActionPerformed

    private void jTextMESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMESActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMESActionPerformed

    private void jTextAPELLIDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAPELLIDOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAPELLIDOActionPerformed

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

    private void jTextDEPARTAMENTOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDEPARTAMENTOKeyTyped
           String txt=jTextDEPARTAMENTO.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextDEPARTAMENTO.setText(txt);
        }
         char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
     }
    }//GEN-LAST:event_jTextDEPARTAMENTOKeyTyped

    private void jTextMESKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMESKeyTyped
           String txt=jTextMES.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextMES.setText(txt);
        }
         char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextMESKeyTyped

    private void jTextIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextIDKeyTyped
                   char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextIDKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        listardatos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        filtro2();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTextBUSQUEDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBUSQUEDAKeyReleased
        filtro1();
    }//GEN-LAST:event_jTextBUSQUEDAKeyReleased

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        listardatos2();
    }//GEN-LAST:event_jComboBox1MouseClicked

    
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
            java.util.logging.Logger.getLogger(TBCLIENTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TBCLIENTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TBCLIENTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TBCLIENTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBCLIENTE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonELIMINA;
    private javax.swing.JButton jButtonLIMPIO;
    private javax.swing.JButton jButtonREGISTRAR;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextAPELLIDO;
    private javax.swing.JTextField jTextBUSQUEDA;
    private javax.swing.JTextField jTextCHASI;
    private javax.swing.JTextField jTextDEPARTAMENTO;
    private javax.swing.JTextField jTextDIRECCION;
    private javax.swing.JTextField jTextID;
    private javax.swing.JTextField jTextMES;
    private javax.swing.JTextField jTextNOMBRE;
    // End of variables declaration//GEN-END:variables
}
