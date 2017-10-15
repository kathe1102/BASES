
package basesdedatos;

import basesdedatos.MunuDB;
import javax.swing.JOptionPane;


public class Menuprincipal extends javax.swing.JFrame {

    
    public Menuprincipal() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUSER = new javax.swing.JTextField();
        jPasswordFieldCONTRA = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 140, 100, 30);

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel4.setText("Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 200, 130, 30);

        jTextFieldUSER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUSERActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUSER);
        jTextFieldUSER.setBounds(220, 130, 170, 40);
        getContentPane().add(jPasswordFieldCONTRA);
        jPasswordFieldCONTRA.setBounds(220, 190, 170, 40);

        jButton1.setText("ENTRAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 250, 110, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/login4.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-70, -10, 770, 200);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/login4.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-70, 190, 770, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUSERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUSERActionPerformed
           
        
    }//GEN-LAST:event_jTextFieldUSERActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String user;
        int contraseña;
        user=String.valueOf(jTextFieldUSER.getText());
        contraseña=Integer.parseInt(jPasswordFieldCONTRA.getText());
        if(user.equalsIgnoreCase("js.galindo")){
            if(contraseña== 1073247312 ){
                JOptionPane.showMessageDialog(null,"Correcto");
                MunuDB op=new MunuDB();
                op.setVisible(true);
                dispose();
                op.setLocation(300,100);
                op.setSize(330, 270);
            }
         else{
         JOptionPane.showMessageDialog(null,"Incorrecto");
         dispose(); 
        }
        }
        else{
         JOptionPane.showMessageDialog(null,"Incorrecto");
         dispose(); 
        }
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menuprincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordFieldCONTRA;
    private javax.swing.JTextField jTextFieldUSER;
    // End of variables declaration//GEN-END:variables
}
