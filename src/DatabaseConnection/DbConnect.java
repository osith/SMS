/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author MalindaRaneshDeshapr
 */
public class DbConnect {
  public static Connection ConnectDb(){
        Connection con=null;
        try{
           
          Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
           if(con!=null){
               //System.out.println("Connected");
           }
           return con;
        }    
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Check your internet Connecntion");
            return null;
        }
    
    }  
}
