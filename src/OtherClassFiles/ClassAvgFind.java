/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherClassFiles;

import DatabaseConnection.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MalindaRaneshDeshapr
 */
public class ClassAvgFind {
    
    public static double FindClassAvg(int examid, int classid) throws SQLException{
        
        ResultSet rs;
        Connection conn;
        PreparedStatement pst;
        conn = DbConnect.ConnectDb();
        double totalavg=0;
        double avg;
        String sql = "SELECT AVG(E.Marks)\n"
                + "FROM student_exam E, student_class C\n"
                + "WHERE E.exam_id='"+examid+"' AND C.class_id='"+classid+"' AND C.std_adno = E.student_id\n"
                + "GROUP BY E.student_id";
        
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        int i=0;
        while(rs.next()){
            i++;
            totalavg=totalavg+rs.getDouble(1);
        }
        
        avg = totalavg/i;
        
        return avg;
    
    }
    
    public static int noofstudent(int classid) throws SQLException{
        ResultSet rs;
        Connection conn;
        PreparedStatement pst;
        conn = DbConnect.ConnectDb();
        
        int student=0;
        
        String sql = "SELECT COUNT(std_adno)\n"
                + "FROM student_class\n"
                + "WHERE class_id='"+classid+"'";
        
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs.next()){
            student = rs.getInt(1);
        }
        
        
        
        return student;
    
    }
    
}
