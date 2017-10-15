
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ASEGURADORA {
Connection opc=null;
    public Connection dbaseguradora(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            opc=DriverManager.getConnection("jdbc:mysql://localhost/dbaseguradora","root","1234");
            JOptionPane.showMessageDialog(null,"Conexion exitosa");
            
        } catch (Exception e) {
            System.out.print ("e");
            
        }
        return opc;   
    }
    
}
