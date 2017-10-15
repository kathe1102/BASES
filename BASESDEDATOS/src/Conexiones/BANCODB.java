
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class BANCODB {
   Connection opc=null;
    public Connection dbbanco(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            opc=DriverManager.getConnection("jdbc:mysql://localhost/db_banco","root","1234");
            JOptionPane.showMessageDialog(null,"Conexion exitosa");
            
        } catch (Exception e) {
            System.out.print ("e");
            
        }
        return opc;   
    }
    
}
