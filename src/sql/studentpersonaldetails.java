/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import DatabaseConnection.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author MalindaRaneshDeshapr
 */
public class studentpersonaldetails {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    //student details view method
    public ResultSet detailsviewmethod(String userinput){
        int useri = Integer.parseInt(userinput);
        conn = DbConnect.ConnectDb();
        String sql1 = "SELECT * FROM student_personal_details WHERE AdNo=?";
        try{
            pst = conn.prepareStatement(sql1);
            pst.setInt(1, useri);
            rs = pst.executeQuery();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return rs;
    }
    
}
