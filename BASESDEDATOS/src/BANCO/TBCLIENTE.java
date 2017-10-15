
package BANCO;

import Conexiones.BANCODB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TBCLIENTE extends javax.swing.JFrame {
    BANCODB op=new BANCODB();
    Connection op1=op.dbbanco();
    PreparedStatement r1=null;
    ResultSet r2=null;
   
    public TBCLIENTE() {
        initComponents();
        cargatabla();
        cargarcombo();
    }
    
    public void cargatabla(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("Tipo documento ");
        table.addColumn("Documento ");
        table.addColumn("Nombre   ");
        table.addColumn("Apellido  ");
        table.addColumn("Direccion  ");
        table.addColumn("Telfono  ");
        table.addColumn("Usuario ");
        table.addColumn("Fecha Nac ");
        jTable1.setModel (table);
        String datos []=new String [8];
        
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
               datos[6]=r2.getString(7);
               datos[7]=r2.getString(8);
               table.addRow(datos);
            
            }
             } catch (Exception e) {
            System.out.print (e);
        }
    }
    
    public void filtro1(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("Tipo documento ");
        table.addColumn("Documento ");
        table.addColumn("Nombre   ");
        table.addColumn("Apellido  ");
        table.addColumn("Direccion  ");
        table.addColumn("Telfono  ");
        table.addColumn("Usuario ");
        table.addColumn("Fecha Nac ");
        jTable1.setModel (table);
        String datos []=new String [8];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbcliente  where  Doccli like '%"+jTextBUSQUEDA.getText()+"%' or tipodocumen like '%"+jTextBUSQUEDA.getText()+"%' or nombrecli like '%"+jTextBUSQUEDA.getText()+"%' or  apecli  like '%"+jTextBUSQUEDA.getText()+"%'  or dircli like '%"+jTextBUSQUEDA.getText()+"%'  or  telcli like '%"+jTextBUSQUEDA.getText()+"%' or usuario like '%"+jTextBUSQUEDA.getText()+"%' or fecnac like '%"+jTextBUSQUEDA.getText()+"%'   ");
            r2=r1.executeQuery();
            while(r2.next()){
               datos[0]=r2.getString(1);
               datos[1]=r2.getString(2);
               datos[2]=r2.getString(3);
               datos[3]=r2.getString(4);
               datos[4]=r2.getString(5);
               datos[5]=r2.getString(6);
               datos[6]=r2.getString(7);
               datos[7]=r2.getString(8);
               table.addRow(datos);
            
            }
             } catch (Exception e) {
            System.out.print (e);
        }
    }
    
    
     public void filtro2(){
        DefaultTableModel table=new  DefaultTableModel();
        table.addColumn("Tipo documento ");
        table.addColumn("Documento ");
        table.addColumn("Nombre   ");
        table.addColumn("Apellido  ");
        table.addColumn("Direccion  ");
        table.addColumn("Telfono  ");
        table.addColumn("Usuario ");
        table.addColumn("Fecha Nac ");
        jTable1.setModel (table);
        String datos []=new String [8];
        
        try {
            r1=op1.prepareStatement("SELECT * FROM tbcliente where  Doccli like '%"+jComboBox1.getSelectedItem().toString()+"%' ");
            r2=r1.executeQuery();
            while(r2.next()){
               datos[0]=r2.getString(1);
               datos[1]=r2.getString(2);
               datos[2]=r2.getString(3);
               datos[3]=r2.getString(4);
               datos[4]=r2.getString(5);
               datos[5]=r2.getString(6);
               datos[6]=r2.getString(7);
               datos[7]=r2.getString(8);
               table.addRow(datos);
            
            }
             } catch (Exception e) {
            System.out.print (e);
        }
    }
    
    
    
public void listardatos(){
        int list=jTable1.getSelectedRow();
        if(list>=0){
            
            jTextTIPODOCUME.setText(jTable1.getValueAt(list, 0).toString());
            jComboBox1.setSelectedItem(jTable1.getValueAt(list,1).toString());
            jTextNOMBRE.setText(jTable1.getValueAt(list, 2).toString());
            jTextAPELLIDO.setText(jTable1.getValueAt(list, 3).toString());
            jTextDIRECCION.setText(jTable1.getValueAt(list, 4).toString());
            jTextTELEFONO.setText(jTable1.getValueAt(list, 5).toString());
            jTextUSUARIO.setText(jTable1.getValueAt(list, 6).toString());
            jTextFEHCANACION.setText(jTable1.getValueAt(list, 7).toString());
        }
        
    }
    
     public void registrar (){
        
        try {
            r1=op1.prepareStatement("INSERT INTO tbcliente (tipodocumen,doccli,nombrecli,apecli,dircli,telcli,usuario,fecnac) VALUES(?,?,?,?,?,?,?,?)");
            r1.setString(1,jTextTIPODOCUME.getText());
            r1.setString(2,jTextDOCUMENTO.getText());
            r1.setString(3,jTextNOMBRE.getText());
            r1.setString(4,jTextAPELLIDO.getText());
            r1.setString(5,jTextDIRECCION.getText());
            r1.setString(6,jTextTELEFONO.getText());
            r1.setString(7,jTextUSUARIO.getText());
            r1.setString(8,jTextFEHCANACION.getText());
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
            r1=op1.prepareStatement("SELECT doccli from tbcliente");
            r2=r1.executeQuery();
            while(r2.next()){
                String aux=r2.getString("doccli");
                this.jComboBox1.addItem(aux);
          
            }
        } catch (Exception e) {
        }
        
    } 
     
       public void modificar(String tid,String nom, String ape, String dir, String tel, String usu, String fec, String doc){
        try {
            r1=op1.prepareStatement("UPDATE Tbcliente set tipodocumen= '"+tid+"' ,nombrecli= '"+nom+"' , apecli='"+ape+"', Dircli='"+dir+"', telcli='"+tel+"', usuario='"+usu+"', fecnac='"+fec+"' where  doccli='"+doc+"'");
            r1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados ");
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
        
         public void eliminar(String cod){
        try {
         r1=op1.prepareStatement("DELETE from tbcliente WHERE doccli='"+cod+"'");
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
        jButtonMODIFICAR = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextTIPODOCUME = new javax.swing.JTextField();
        jTextNOMBRE = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextAPELLIDO = new javax.swing.JTextField();
        jTextDIRECCION = new javax.swing.JTextField();
        jTextTELEFONO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextUSUARIO = new javax.swing.JTextField();
        jTextFEHCANACION = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextDOCUMENTO = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("REGRESAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jLabel7.setText("DIRECCION");

        jLabel3.setText("TIPO DOCUMENTO");

        jTextTIPODOCUME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTIPODOCUMEKeyTyped(evt);
            }
        });

        jTextNOMBRE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNOMBREKeyTyped(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("NOMBRE ");

        jLabel1.setText("APELLIDO");

        jLabel5.setText("TELEFONO");

        jTextAPELLIDO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAPELLIDOKeyTyped(evt);
            }
        });

        jTextDIRECCION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDIRECCIONActionPerformed(evt);
            }
        });
        jTextDIRECCION.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDIRECCIONKeyTyped(evt);
            }
        });

        jTextTELEFONO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTELEFONOKeyTyped(evt);
            }
        });

        jLabel6.setText("USUARIO");

        jLabel2.setText("FECHA NACIMIENTO");

        jTextUSUARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUSUARIOActionPerformed(evt);
            }
        });
        jTextUSUARIO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextUSUARIOKeyTyped(evt);
            }
        });

        jTextFEHCANACION.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFEHCANACIONKeyTyped(evt);
            }
        });

        jLabel8.setText("DOCUMENTO");

        jTextDOCUMENTO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDOCUMENTOKeyTyped(evt);
            }
        });

        jButton2.setText("BUSCAR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jTextBUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(jButtonGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextTIPODOCUME, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(90, 90, 90)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonMODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jTextAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(350, 350, 350)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jTextDIRECCION, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(350, 350, 350)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jTextTELEFONO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jTextUSUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jTextFEHCANACION, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jTextDOCUMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextBUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGUARDAR))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonMODIFICAR)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextTIPODOCUME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton2))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDIRECCION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTELEFONO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextUSUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFEHCANACION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextDOCUMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        String tid, nom, ape, dir, tel, usu, fec, doc;

        doc=jComboBox1.getSelectedItem().toString();
        nom=jTextNOMBRE.getText();
        tel=jTextTELEFONO.getText();
        ape=jTextAPELLIDO.getText();
        dir=jTextDIRECCION.getText();
        fec=jTextFEHCANACION.getText();
        usu=jTextUSUARIO.getText();
        tid=jTextTIPODOCUME.getText();
        
        modificar(tid, nom, ape, dir, tel, usu, fec, doc);
        cargatabla();
    }//GEN-LAST:event_jButtonMODIFICARActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        jComboBox1.removeAllItems();
        cargarcombo();
        jTextNOMBRE.setText(null);
        jTextFEHCANACION.setText(null);
        jTextTELEFONO.setText(null);
        jTextFEHCANACION.setText(null);
        jTextAPELLIDO.setText(null);
        jTextDIRECCION.setText(null);
        jTextUSUARIO.setText(null);
        jTextTIPODOCUME.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextTIPODOCUMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTIPODOCUMEKeyTyped
      String txt=jTextTIPODOCUME.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextTIPODOCUME.setText(txt);
        }
        char c=evt.getKeyChar();
        if (Character.isDigit(c)){
            evt.consume();
        }

    }//GEN-LAST:event_jTextTIPODOCUMEKeyTyped

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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

    private void jTextDIRECCIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDIRECCIONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDIRECCIONActionPerformed

    private void jTextDIRECCIONKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDIRECCIONKeyTyped
        String txt=jTextDIRECCION.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextDIRECCION.setText(txt);
        }
        char c=evt.getKeyChar();
        if (Character.isDigit(c)){
            evt.consume();
        }

    }//GEN-LAST:event_jTextDIRECCIONKeyTyped

    private void jTextUSUARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUSUARIOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextUSUARIOActionPerformed

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

    private void jTextFEHCANACIONKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFEHCANACIONKeyTyped
    

    }//GEN-LAST:event_jTextFEHCANACIONKeyTyped

    private void jTextDOCUMENTOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDOCUMENTOKeyTyped
        char c=evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextDOCUMENTOKeyTyped

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

    private void jTextTELEFONOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTELEFONOKeyTyped
        char c=evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
        }       
    }//GEN-LAST:event_jTextTELEFONOKeyTyped

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       listardatos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
       filtro2();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextBUSQUEDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBUSQUEDAKeyReleased
        filtro1();
    }//GEN-LAST:event_jTextBUSQUEDAKeyReleased

   
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
    private javax.swing.JButton jButtonELIMINAR;
    private javax.swing.JButton jButtonGUARDAR;
    private javax.swing.JButton jButtonMODIFICAR;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextAPELLIDO;
    private javax.swing.JTextField jTextBUSQUEDA;
    private javax.swing.JTextField jTextDIRECCION;
    private javax.swing.JTextField jTextDOCUMENTO;
    private javax.swing.JTextField jTextFEHCANACION;
    private javax.swing.JTextField jTextNOMBRE;
    private javax.swing.JTextField jTextTELEFONO;
    private javax.swing.JTextField jTextTIPODOCUME;
    private javax.swing.JTextField jTextUSUARIO;
    // End of variables declaration//GEN-END:variables
}
