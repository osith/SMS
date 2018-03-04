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
public class ClassIDFind {
    static int classid;
    public static int classad;
    public static ResultSet FIND(int grade, String classs, int year) throws SQLException {
        ResultSet rs;
        Connection conn;
        PreparedStatement pst;
        conn = DbConnect.ConnectDb();

        String sqlclassid = "SELECT class_id FROM classes WHERE class_year='" + year + "' AND class_grade='" + grade + "' AND class_subclass='" + classs + "'";
        pst = conn.prepareStatement(sqlclassid);
        rs = pst.executeQuery();
        if (rs.next()) {
           classid = rs.getInt("class_id");

            String sqlstudents = "SELECT S.AdNo As 'Admision No', S.NameWithInitial AS 'Name with Initial', S.Birthday FROM student_personal_details S, student_class C WHERE class_id='" + classid + "' AND S.AdNo=C.std_adno";
            pst = conn.prepareStatement(sqlstudents);
            rs = pst.executeQuery();

        }
        return rs;
    }
    
    public static int  FINDClass(int grade, String classs, int year) throws SQLException{
        ResultSet rs;
        Connection conn;
        PreparedStatement pst;
        conn = DbConnect.ConnectDb();
        
        
        String sqlclassid = "SELECT class_id FROM classes WHERE class_year='" + year + "' AND class_grade='" + grade + "' AND class_subclass='" + classs + "'";
        pst = conn.prepareStatement(sqlclassid);
        rs = pst.executeQuery();
        if (rs.next()) {
           classad = rs.getInt("class_id");
        }
        
        return classad;
    }
    


}
