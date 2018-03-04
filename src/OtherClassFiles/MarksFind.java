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


public class MarksFind {
    
    
    
    public static ResultSet FIND(int studentId,int term,int grade,int year) throws SQLException{
        ResultSet rs;
        Connection conn;
        PreparedStatement pst;
        conn = DbConnect.ConnectDb();
        int examid;
        //int classno = ClassIDFind.classad;
        
        String sql = "SELECT exam_id FROM exams WHERE exam_year='"+year+"' AND exam_term='"+term+"' AND exam_grade='"+grade+"'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            examid = rs.getInt("exam_id");
            String sql1 = "SELECT S.subject_id AS 'Subject ID',S.subject_name AS 'Subject Name', E.Marks AS 'Marks' \n"
                    + "FROM student_exam E , subjects S\n"
                    + "WHERE E.exam_id='" + examid + "' AND E.student_id='" + studentId + "' AnD E.subject_id=S.subject_id\n"
                    + "GROUP BY S.subject_id";
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            
            
        }
        return rs;
    }
    
    public static int examidpass(int term,int grade,int year) throws SQLException{
        ResultSet rs;
        Connection conn;
        PreparedStatement pst;
        conn = DbConnect.ConnectDb();
        int examid=0;
        
        String sql = "SELECT exam_id FROM exams WHERE exam_year='"+year+"' AND exam_term='"+term+"' AND exam_grade='"+grade+"'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs.next()){
            examid = rs.getInt("exam_id");
        }
        
        
        return examid;
    
    }
}
