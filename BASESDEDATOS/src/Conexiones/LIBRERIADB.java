
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class LIBRERIADB {
    Connection opc=null;
    public Connection dblibreria(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            opc=DriverManager.getConnection("jdbc:mysql://localhost/db_Libreria","root","1234");
            JOptionPane.showMessageDialog(null,"Conexion exitosa");
            
        } catch (Exception e) {
            System.out.print ("e");
            
        }
        return opc;   
    }
     public static void main (String[]args){
        
    }

   
}
