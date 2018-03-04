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
public class AvFind {
    public static double find(int classid,int subjectid,int examid) throws SQLException{
        ResultSet rs;
        Connection conn;
        PreparedStatement pst;
        conn = DbConnect.ConnectDb();
        double avg=5;
        
        String sql = "SELECT AVG(Marks) AS 'Average'\n"
                + "FROM student_exam E,student_class C\n"
                + "WHERE E.subject_id='"+subjectid+"' and exam_id='"+examid+"' and C.class_id='"+classid+"'";
        
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        if(rs.next()){
            avg = rs.getDouble(1);
           
        }
        
        return avg;
    }
}
