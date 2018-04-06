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
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * This is loginsql class
 * @author S.D. Sugathapala
 */
public class loginsql {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    /**
     * teacherLogin method
     * @param user pass the userName
     * @param password pass the password
     * @return validity
     */
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
    
    /**
     * adminLogin method
     * @param user pass the userName
     * @param pasword pass the password
     * @return validity
     */
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
    
    /**
     * user_log method
     * @param user pass the userName
     * @param role pass the userRole
     * @throws UnknownHostException unknown host
     * @throws SQLException  SQL error
     */
    public void user_log(String user,String role) throws UnknownHostException, SQLException{
        String strUser = user;
        String strRole = role;
        InetAddress ip = InetAddress.getLocalHost();
        
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDaye = format.format(date);
        
        SimpleDateFormat formattime = new SimpleDateFormat("hh:mm:ss");
        String strTime = formattime.format(date);
        
        String sql = "INSERT INTO user_log(user_id,role,logged_device,date,time) VALUES('"+strUser+"','"+strRole+"','"+ip+"','"+strDaye+"','"+strTime+"')";
        
        pst = conn.prepareStatement(sql);
        pst.execute();
    }
}
