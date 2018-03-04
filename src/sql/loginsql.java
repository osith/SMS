/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import DatabaseConnection.DbConnect;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author MalindaRaneshDeshapr
 */
public class loginsql {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public boolean teacherlogin(String user, String password) {
        boolean isTrue = false;
        conn = DbConnect.ConnectDb();
        String sql = "SELECT teacher_id FROM teacher_personal_details WHERE teacher_id=? AND teacher_password=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, password);

            rs = pst.executeQuery();
            
            if (rs.next()) {
                isTrue = true;
            }      
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return isTrue;
    }
    
    public boolean adminlogin(String user, String pasword){
        System.out.println("this");
        boolean isTrue = false;
        conn = DbConnect.ConnectDb();
        String sql ="SELECT username FROM user WHERE username=? AND password=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pasword);
            
            rs = pst.executeQuery();
            if(rs.next()){
                isTrue = true;
            }    
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Please contact the system admin");
        }   
        return isTrue;
    }
    
    public void user_log(String user,String role) throws UnknownHostException, SQLException{
        String usr = user;
        String rol = role;
        InetAddress ip = InetAddress.getLocalHost();
        
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDaye = format.format(date);
        
        SimpleDateFormat formattime = new SimpleDateFormat("hh:mm:ss");
        String strTime = formattime.format(date);
        
        
        String sql = "INSERT INTO user_log(user_id,role,logged_device,date,time) VALUES('"+usr+"','"+rol+"','"+ip+"','"+strDaye+"','"+strTime+"')";
        pst = conn.prepareStatement(sql);
        pst.execute();

    }
    
}
