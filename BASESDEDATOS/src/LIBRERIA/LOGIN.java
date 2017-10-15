
package LIBRERIA;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class LOGIN extends javax.swing.JFrame {
     Conexiones.LIBRERIADB op=new Conexiones.LIBRERIADB ();
     Connection cnn=op.dblibreria();
    
    public LOGIN() {
        initComponents();
    }

    public void validarusuario(String us, String Cla){
       PreparedStatement po=null;
       ResultSet re=null; 
       try{
         po=cnn.prepareStatement("SELECT * FROM tblogin WHERE usuario = '"+us+"' AND clave = '"+Cla+"' ");  
         re=po.executeQuery();  
         if(re.next()){
             MENU op=new MENU();
             op.setVisible(true);
             dispose();
             op.setLocation(300,100);
             op.setSize(300, 350);
         }
         else{
             JOptionPane.showMessageDialog(null,"Datos no validos");
             

       }
       }  
         catch (Exception e){
           System.out.print ("Error" + e);
       }
        
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("USUARIO ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 80, 30);

        jLabel2.setText("CONTRASEÑA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 80, 90, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(130, 30, 110, 30);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(130, 80, 110, 30);

        jButton1.setText("INGRESAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 140, 130, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/login3.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-10, -10, 310, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String u,c;
        u=jTextField1.getText();
        c=jPasswordField1.getText();
        validarusuario(u, c);
    }//GEN-LAST:event_jButton1ActionPerformed

  
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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
