
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ACADEMIADB {
    Connection opc=null;
     public Connection dbacademia(){
         try {
             Class.forName("com.mysql.jdbc.Driver");
             opc=DriverManager.getConnection("jdbc:mysql://localhost/dbacademia","root","1234");
             JOptionPane.showMessageDialog(null,"Conexion exitosa");
             
         } catch (Exception e) {
             System.out.print("e");
         }
         return opc;
     }
    public static void main (String[]args){
        
    }

    public PreparedStatement prepareStatement(String select__from_tbcursos_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
