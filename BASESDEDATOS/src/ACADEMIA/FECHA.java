/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACADEMIA;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;


public class FECHA {
    
    
    SimpleDateFormat fec=new SimpleDateFormat("yyyy-MM-dd");
    
    public String cap(JDateChooser cap){
        return fec.format(cap.getDate());
    }
}
