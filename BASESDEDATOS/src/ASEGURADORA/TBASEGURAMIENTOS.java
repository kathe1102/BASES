
package ASEGURADORA;

import Conexiones.ASEGURADORA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TBASEGURAMIENTOS extends javax.swing.JFrame {
    ASEGURADORA op=new ASEGURADORA();
    Connection op1=op.dbaseguradora();
    PreparedStatement r1=null;
    ResultSet r2=null;
   
    public TBASEGURAMIENTOS() {
        initComponents();
        cargatabla();
        cargarcombo();
        cargarcombo2();
    }
    public void cargatabla(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("Codigo ");
        table.addColumn("Fecha Inicio  ");
        table.addColumn("Fecha Expiracion  ");
        table.addColumn("Valor Asegurado ");
        table.addColumn("Estado  ");
        table.addColumn("Costo  ");
        table.addColumn("Placa ");
        jTable1.setModel (table);
        String datos []=new String [7];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbaseguramientos");
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
    
     public void filtro1(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("Codigo ");
        table.addColumn("Fecha Inicio  ");
        table.addColumn("Fecha Expiracion  ");
        table.addColumn("Valor Asegurado ");
        table.addColumn("Estado  ");
        table.addColumn("Costo  ");
        table.addColumn("Placa ");
        jTable1.setModel (table);
        String datos []=new String [7];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbaseguramientos where  asecodigo like '%"+jTextBUSQUEDAD.getText()+"%'  or asefechainicio like '%"+jTextBUSQUEDAD.getText()+"%'  or asefechaexpiracion  like '%"+jTextBUSQUEDAD.getText()+"%' or  asevalorasegurado like '%"+jTextBUSQUEDAD.getText()+"%' or aseestado like '%"+jTextBUSQUEDAD.getText()+"%'  or asecosto like '%"+jTextBUSQUEDAD.getText()+"%'  or aseplaca like '%"+jTextBUSQUEDAD.getText()+"%'  ");
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
    
    
    public void filtro2(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("Codigo ");
        table.addColumn("Fecha Inicio  ");
        table.addColumn("Fecha Expiracion  ");
        table.addColumn("Valor Asegurado ");
        table.addColumn("Estado  ");
        table.addColumn("Costo  ");
        table.addColumn("Placa ");
        jTable1.setModel (table);
        String datos []=new String [7];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbaseguramientos  where  asecodigo like '%"+jComboBox1.getSelectedItem().toString()+"%' ");
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
            jTextFECHAINICIO.setText(jTable1.getValueAt(list, 1).toString());
            jTextFECHAEXPIRACION.setText(jTable1.getValueAt(list, 2).toString());
            jTextVALORASEGURA.setText(jTable1.getValueAt(list, 3).toString());
            jTextESTADO.setText(jTable1.getValueAt(list, 4).toString());
            jTextCOSTO.setText(jTable1.getValueAt(list, 5).toString());
            jComboBox2.setSelectedItem(jTable1.getValueAt(list, 6).toString());
        }
        
    }
    
      public void listardatos2(){
        int list=jComboBox1.getSelectedIndex();
        if(list>=0){
            //jComboBox1.setSelectedItem(jTable1.getValueAt(list,0).toString());
            jTextFECHAINICIO.setText(jTable1.getValueAt(list, 1).toString());
            jTextFECHAEXPIRACION.setText(jTable1.getValueAt(list, 2).toString());
            jTextVALORASEGURA.setText(jTable1.getValueAt(list, 3).toString());
            jTextESTADO.setText(jTable1.getValueAt(list, 4).toString());
            jTextCOSTO.setText(jTable1.getValueAt(list, 5).toString());
            jComboBox2.setSelectedItem(jTable1.getValueAt(list, 6).toString());
        }
        
    }
    
    
    
    
     public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO tbaseguramientos (asecodigo,asefechainicio,asefechaexpiracion,asevalorasegurado,aseestado,asecosto,aseplaca) VALUES(?,?,?,?,?,?,?)");
            r1.setString(1,jTextCODIGO.getText());
            r1.setString(2,jTextFECHAINICIO.getText());
            r1.setString(3,jTextFECHAEXPIRACION.getText());
            r1.setString(4,jTextVALORASEGURA.getText());
            r1.setString(5,jTextESTADO.getText());
            r1.setString(6,jTextCOSTO.getText());
            r1.setString(7,jComboBox2.getSelectedItem().toString());
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
            r1=op1.prepareStatement("SELECT asecodigo from tbaseguramientos");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("asecodigo");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
     
       
       public void cargarcombo2(){
        try {
            jComboBox2.removeAll();
            jComboBox2.addItem("Seleccione placa");
            r1=op1.prepareStatement("SELECT aseplaca from tbaseguramientos");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("aseplaca");
                this.jComboBox2.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
       
       public void modificar(String ini,String xp, String val, String est, String os, String pla, String cod){
        try {
            r1=op1.prepareStatement("UPDATE TbAseguramientos set Asefechainicio= '"+ini+"' ,Asefechaexpiracion= '"+xp+"' , Asevalorasegurado='"+val+"', Aseestado='"+est+"', Asecosto='"+os+"', Aseplaca='"+pla+"' where  Asecodigo='"+cod+"'");
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados ");
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
        
         public void eliminar(String cod){
        try {
         r1=op1.prepareStatement("DELETE from tbaseguramientos WHERE asecodigo='"+cod+"'");
         r1.executeUpdate();
         JOptionPane.showMessageDialog(null,"Datos Eliminados ");
         
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonGUARDAR = new javax.swing.JButton();
        jButtonELIMINAR = new javax.swing.JButton();
        jButtonMODIFICAR = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextFECHAEXPIRACION = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextCOSTO = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFECHAINICIO = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextVALORASEGURA = new javax.swing.JTextField();
        jTextESTADO = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextCODIGO = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextBUSQUEDAD = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

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

        jButtonGUARDAR.setText("REGISTRAR");
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

        jButtonMODIFICAR.setText("MODIFICAR ");
        jButtonMODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMODIFICARActionPerformed(evt);
            }
        });

        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("COSTO");

        jTextCOSTO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCOSTOKeyTyped(evt);
            }
        });

        jLabel3.setText("FECHA INICIO ");

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox1MouseReleased(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox1KeyReleased(evt);
            }
        });

        jLabel4.setText("FECHA EXPIRACION");

        jLabel1.setText("VALOR ASEGURADO ");

        jLabel5.setText("ESTADO");

        jTextVALORASEGURA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextVALORASEGURAKeyTyped(evt);
            }
        });

        jTextESTADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextESTADOActionPerformed(evt);
            }
        });
        jTextESTADO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextESTADOKeyTyped(evt);
            }
        });

        jLabel7.setText("CODIGO");

        jTextCODIGO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCODIGOKeyTyped(evt);
            }
        });

        jButton2.setText("BUSCAR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextBUSQUEDAD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextBUSQUEDADKeyReleased(evt);
            }
        });

        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox2MouseReleased(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jTextBUSQUEDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jButtonMODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jTextFECHAINICIO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextFECHAEXPIRACION, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextVALORASEGURA, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jTextESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jTextCOSTO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextCODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextBUSQUEDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButtonMODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFECHAINICIO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGUARDAR)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFECHAEXPIRACION, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextVALORASEGURA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextCOSTO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButtonMODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMODIFICARActionPerformed
        String ini,xp,val,est,os,pla,cod;

        cod=jComboBox1.getSelectedItem().toString();
        ini=jTextFECHAINICIO.getText();
        xp=jTextFECHAEXPIRACION.getText();
        val=jTextVALORASEGURA.getText();
        est=jTextESTADO.getText();
        os=jTextCOSTO.getText();
        pla=jComboBox2.getSelectedItem().toString();
        modificar(ini, xp, val, est, os, pla, cod);
        cargatabla();
    }//GEN-LAST:event_jButtonMODIFICARActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        jComboBox1.removeAllItems();
        cargarcombo();
        jComboBox2.removeAllItems();
        cargarcombo2();
        jTextFECHAINICIO.setText(null);
        jTextCOSTO.setText(null);
        jTextFECHAEXPIRACION.setText(null);
        jTextCOSTO.setText(null);
        jTextVALORASEGURA.setText(null);
        jTextESTADO.setText(null);
        jTextCODIGO.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextESTADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextESTADOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextESTADOActionPerformed

    private void jTextVALORASEGURAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextVALORASEGURAKeyTyped
           char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextVALORASEGURAKeyTyped

    private void jTextESTADOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextESTADOKeyTyped
         String txt=jTextESTADO.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextESTADO.setText(txt);
        }
         char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextESTADOKeyTyped

    private void jTextCOSTOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCOSTOKeyTyped
             char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextCOSTOKeyTyped

    private void jTextCODIGOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCODIGOKeyTyped
             char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
     }
        
    }//GEN-LAST:event_jTextCODIGOKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       listardatos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        //filtro2();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextBUSQUEDADKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBUSQUEDADKeyReleased
     
    }//GEN-LAST:event_jTextBUSQUEDADKeyReleased

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        //listardatos2();
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
      //  listardatos2();
    }//GEN-LAST:event_jComboBox1MouseEntered

    private void jComboBox1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseExited
       // listardatos2();
    }//GEN-LAST:event_jComboBox1MouseExited

    private void jComboBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MousePressed
        //listardatos2();
    }//GEN-LAST:event_jComboBox1MousePressed

    private void jComboBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseReleased
       //listardatos2();
    }//GEN-LAST:event_jComboBox1MouseReleased

    private void jComboBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyReleased
        listardatos2();
    }//GEN-LAST:event_jComboBox1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        filtro1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MouseEntered

    private void jComboBox2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MouseExited

    private void jComboBox2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MousePressed

    private void jComboBox2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MouseReleased

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2KeyReleased

    
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
            java.util.logging.Logger.getLogger(TBASEGURAMIENTOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TBASEGURAMIENTOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TBASEGURAMIENTOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TBASEGURAMIENTOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBASEGURAMIENTOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonELIMINAR;
    private javax.swing.JButton jButtonGUARDAR;
    private javax.swing.JButton jButtonMODIFICAR;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextBUSQUEDAD;
    private javax.swing.JTextField jTextCODIGO;
    private javax.swing.JTextField jTextCOSTO;
    private javax.swing.JTextField jTextESTADO;
    private javax.swing.JTextField jTextFECHAEXPIRACION;
    private javax.swing.JTextField jTextFECHAINICIO;
    private javax.swing.JTextField jTextVALORASEGURA;
    // End of variables declaration//GEN-END:variables
}
