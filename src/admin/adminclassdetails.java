/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import DatabaseConnection.DbConnect;
import OtherClassFiles.ClassIDFind;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author MalindaRaneshDeshapr
 */
public class adminclassdetails extends javax.swing.JInternalFrame {

    ResultSet rs;
    Connection conn;
    PreparedStatement pst;
    
    DefaultTableModel modelStudentList = new DefaultTableModel();
    
    DefaultTableModel modelClassList = new DefaultTableModel(new String[]{"Class ID", "Teacher Name", "Class Grade","Subclass","Capacity"}, 0);
    DefaultTableModel model;
     
    String classID;
    int capacity;
    public adminclassdetails() throws SQLException {
        conn = DbConnect.ConnectDb();
        initComponents();
        teacherload();
        //studentListLoad();
        ClassList();
        modelStudentList.addColumn("Student ID");
        modelStudentList.addColumn("Student Name");
   
    }
    
    public void teacherload() throws SQLException{
        
        table_teachers.removeAll();
        int year = Year.now().getValue();
        
        String sqlnew ="SELECT T.*\n" +
                            "FROM teacher_personal_details T\n" +
                                "WHERE T.teacher_id NOT IN (SELECT teach_id FROM classes WHERE class_year = '"+year+"' )";
        
        pst = conn.prepareStatement(sqlnew);
        rs = pst.executeQuery();
        table_teachers.setModel(DbUtils.resultSetToTableModel(rs));
        
        
    }
    
    
    public void studentListLoad(int grade) throws SQLException{
        model = new DefaultTableModel(new String[]{"Student No", "Student Name"}, 0); 
        tbl_all_students.removeAll(); 
        int year = Year.now().getValue();
        
        int grd = grade-1;
        int yearr = year-1;
         
         /*String sql= "SELECT S.AdNo , S.NameWithInitial\n" +
                        "FROM student_personal_details S\n" +
                            "WHERE S.AdNo NOT IN (SELECT C.std_adno FROM student_class C , classes D WHERE C.class_id = D.class_id AND D.class_year='"+year+"' AND D.class_grade='"+grd+"')";*/
         String sql = "SELECT P.NameWithInitial, P.AdNo FROM classes C, student_class S, student_personal_details P WHERE C.class_id = S.class_id AND S.std_adno = P.AdNo AND C.class_year='"+yearr+"' AND C.class_grade='"+grd+"' AND P.AdNo NOT IN (SELECT S.std_adno FROM classes C, student_class S WHERE C.class_id = S.class_id AND C.class_year='"+year+"')";
         pst = conn.prepareStatement(sql);
         rs = pst.executeQuery();
         //tbl_all_students.setModel(DbUtils.resultSetToTableModel(rs));
         while(rs.next()){
             String id = rs.getString("P.AdNo");
             String name = rs.getString("P.NameWithInitial");
             model.addRow(new Object[]{id, name});
         }
        
         tbl_all_students.setModel(model);
    }
    
    public void ClassList() throws SQLException{
        int year = Year.now().getValue();
        String sql = "SELECT C.class_id, T.teacher_nwi,C.class_grade,C.class_subclass,C.std_capacity \n" +
                        "FROM classes C, teacher_personal_details T \n" +
                            "WHERE C.teach_id = T.teacher_id AND C.class_year = '"+year+"'";
         pst = conn.prepareStatement(sql);
         rs = pst.executeQuery();
         
         while(rs.next()){
             String classid = rs.getString("C.class_id");
             String teacher = rs.getString("T.teacher_nwi");
             String grade = rs.getString("C.class_grade");
             String subclass = rs.getString("C.class_subclass");
             String capacity = rs.getString("std_capacity");
             
             modelClassList.addRow(new Object[]{classid,teacher,grade,subclass,capacity});
             tbl_class_list.setModel(modelClassList);
         }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tablepanal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_submit = new javax.swing.JButton();
        radioteacherid = new javax.swing.JRadioButton();
        txt_teacherid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_classyear = new com.toedter.calendar.JYearChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combograde = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        radioclass = new javax.swing.JRadioButton();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_noofstudents = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        birthdays = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        btn_print_student_list = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        combo_grade = new javax.swing.JComboBox<>();
        txt_capacity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_teachers = new javax.swing.JTable();
        btn_submit1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_subclass = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_currentclasses = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_selected_students = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_all_students = new javax.swing.JTable();
        btn_insert = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_class_list = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        btn_submitClass = new javax.swing.JButton();

        setBackground(new java.awt.Color(206, 255, 179));
        setBorder(null);
        setForeground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(1141, 670));

        jPanel1.setBackground(new java.awt.Color(206, 255, 179));

        tablepanal.setBackground(new java.awt.Color(51, 255, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Admision No", "Name With Initials", "Birthday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(153, 255, 153));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout tablepanalLayout = new javax.swing.GroupLayout(tablepanal);
        tablepanal.setLayout(tablepanalLayout);
        tablepanalLayout.setHorizontalGroup(
            tablepanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
        tablepanalLayout.setVerticalGroup(
            tablepanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablepanalLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioteacherid);
        radioteacherid.setText("Teacher ID");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Search By :");

        jLabel3.setText("Class :");

        jLabel2.setText("Grade :");

        combograde.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" }));
        combograde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combogradeActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioclass);
        radioclass.setText("Class");
        radioclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioclassActionPerformed(evt);
            }
        });

        jYearChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jYearChooser1MouseClicked(evt);
            }
        });

        jLabel4.setText("Year :");

        jLabel5.setText("Year :");

        jLabel6.setText("Teacher ID :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_classyear, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_teacherid, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(combograde, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 6, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_submit)
                                        .addContainerGap())))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(radioteacherid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioclass)
                                .addGap(102, 102, 102))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioteacherid)
                    .addComponent(jLabel1)
                    .addComponent(radioclass))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(combograde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_teacherid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6))
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_classyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_submit)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        jLabel7.setText("No of Students :");

        txt_noofstudents.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_noofstudents, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_noofstudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(206, 255, 179));

        birthdays.setColumns(20);
        birthdays.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        birthdays.setLineWrap(true);
        birthdays.setRows(5);
        jScrollPane2.setViewportView(birthdays);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Birthdays");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(135, 135, 135))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btn_print_student_list.setText("Print Student List");
        btn_print_student_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print_student_listActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tablepanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(btn_print_student_list, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablepanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btn_print_student_list, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Search Classs Details", jPanel1);

        jPanel5.setBackground(new java.awt.Color(206, 255, 179));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Grade :");

        jLabel10.setText("Capacity :");

        combo_grade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", " " }));
        combo_grade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_gradeActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Step 1 : Select Grade and subclass");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Step 2  : Enter Class Capacity");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Step 3  : Select available teacher for the class");

        table_teachers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Teacher ID", "Full Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_teachers.setGridColor(new java.awt.Color(0, 153, 0));
        jScrollPane3.setViewportView(table_teachers);

        btn_submit1.setText("Submit");
        btn_submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submit1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Subclass :");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Add New Class");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(combo_grade, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_subclass, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(btn_submit1))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txt_capacity, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(28, 28, 28)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(combo_grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_subclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_capacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_submit1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Excisting Classes for Selected Grade");

        table_currentclasses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Class ID", "Subclass", "Teacher Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_currentclasses.setGridColor(new java.awt.Color(0, 204, 51));
        jScrollPane4.setViewportView(table_currentclasses);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel16)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(179, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("New Class", jPanel5);

        tbl_selected_students.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Student No", "Student Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbl_selected_students);

        tbl_all_students.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Student No", "Student Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tbl_all_students);

        btn_insert.setText("Insert");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Available Students");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Selected Students");

        tbl_class_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Class ID", "Teacher Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_class_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_class_listMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_class_list);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Available Classes");

        btn_submitClass.setText("Submit");
        btn_submitClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitClassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane7)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(btn_submitClass, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(502, 502, 502)
                        .addComponent(jLabel18)
                        .addGap(283, 283, 283))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(516, 516, 516))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(btn_submitClass)
                                .addGap(217, 217, 217))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(444, 444, 444))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(btn_insert)
                                .addGap(38, 38, 38)
                                .addComponent(jButton2))))))
        );

        jTabbedPane1.addTab("Enrol students for classes", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        if(radioteacherid.isSelected()){
            String teacher = txt_teacherid.getText();
            
            if(teacher.equals("")){
                JOptionPane.showMessageDialog(rootPane, "Please enter teacher id ");
            }
            else{
            int teacherid = Integer.parseInt(txt_teacherid.getText());
            int year = txt_classyear.getYear();    
            try {
                String sqlclassid = "SELECT class_id FROM classes WHERE teach_id='"+teacherid+"' AND class_year='"+year+"'";
                pst = conn.prepareStatement(sqlclassid);
                rs = pst.executeQuery();
                if(rs.next()){
                int classid = rs.getInt("class_id");
                
                String sqlstudents = "SELECT S.AdNo As 'Admision No', S.NameWithInitial AS 'Name with Initial', S.Birthday FROM student_personal_details S, student_class C WHERE class_id='"+classid+"' AND S.AdNo=C.std_adno";
                pst = conn.prepareStatement(sqlstudents);
                rs = pst.executeQuery();
                
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                 int count = jTable1.getRowCount();
                 txt_noofstudents.setText(String.valueOf(count));
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(adminclassdetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        
        else if (radioclass.isSelected()) {
            int year = txt_classyear.getYear();
            String grade = (String) combograde.getSelectedItem();
            String subclass = (String) jComboBox2.getSelectedItem();
            int gradee = Integer.parseInt(grade);
            if (grade.equals("") || subclass.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please select a class ");
            } else {

                try {
                    rs = ClassIDFind.FIND(gradee, subclass, year);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Please check your Internet Connection ");
                }

                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                int count = jTable1.getRowCount();
                txt_noofstudents.setText(String.valueOf(count));

            }
        }
        else{
             JOptionPane.showMessageDialog(rootPane, "Please select an option ");
        }
        
        //birthday highligh
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        int rowcount = jTable1.getRowCount();
        for (int a = 0; a < rowcount; a++) {
            String birthday = (String) jTable1.getValueAt(a, 2);
            String birthdate = birthday.substring(0, 2);
            String birthmonth = birthday.substring(3, 5);

            Date today = new Date();
            System.out.println(today);
            String formatdate = sdf.format(today);
            String todaydate = formatdate.substring(0, 2);
            String todaymonth = formatdate.substring(3, 5);

            if (birthdate.equals(todaydate) && birthmonth.equals(todaymonth)) {
                String name = (String) jTable1.getValueAt(a, 1);
                birthdays.append(name + "\n");

            }

        }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void radioclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioclassActionPerformed
        
    }//GEN-LAST:event_radioclassActionPerformed

    private void jYearChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jYearChooser1MouseClicked
        int year = jYearChooser1.getYear();
        String sql1 = "SELECT  class_grade,class_subclass,class_year FROM classes WHERE class_year=? GROUP BY class_grade ";
       
        try {
            pst = conn.prepareStatement(sql1);
            pst.setInt(1, year);
        rs = pst.executeQuery();
        
        while(rs.next()){
            combograde.addItem(rs.getString("class_grade"));
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(AdminStudentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jYearChooser1MouseClicked

    private void combogradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combogradeActionPerformed
        jComboBox2.removeAllItems();
        int year = jYearChooser1.getYear(); 
        String grade = (String) combograde.getSelectedItem();
       
        String sql1 = "SELECT class_grade,class_subclass,class_year FROM classes WHERE class_year=? AND class_grade=?";
        try {
            pst = conn.prepareStatement(sql1);
            pst.setInt(1, year);
            pst.setString(2, grade);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboBox2.addItem(rs.getString("class_subclass"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminStudentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_combogradeActionPerformed

    private void btn_submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submit1ActionPerformed
        
        int grade1 = Integer.parseInt(combo_grade.getSelectedItem().toString());
        String subclass = txt_subclass.getText();
        int capacity = Integer.parseInt(txt_capacity.getText());

        int selec = table_teachers.getSelectedRow();
        //String teacherid = (String) table_teachers.getValueAt(selec, 0);
        int teacher = Integer.parseInt(table_teachers.getValueAt(selec, 0).toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date today = new Date();

        String formatdate = sdf.format(today);
        int year = Integer.parseInt(formatdate);

        String sql = "INSERT INTO classes (teach_id,class_year,class_grade,class_subclass,std_capacity) VALUES('" + teacher + "','" + year + "','" + grade1 + "','" + subclass + "','" + capacity + "')";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Process Success !");
            teacherload();

            String sql1 = "SELECT C.class_id AS 'Class ID', C.class_subclass AS 'Subclass',T.teacher_fullname AS 'Teacher Name'\n"
                    + "FROM teacher_personal_details T,classes C\n"
                    + "WHERE C.class_grade = '" + grade1 + "' AND C.class_year = '" + year + "' AND C.teach_id = T.teacher_id ";

            try {
                pst = conn.prepareStatement(sql1);
                rs = pst.executeQuery();
                table_currentclasses.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                Logger.getLogger(adminclassdetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            txt_subclass.setText("");
            txt_capacity.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(adminclassdetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_submit1ActionPerformed

    private void combo_gradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_gradeActionPerformed
        String grade = (String) combo_grade.getSelectedItem();
        int grade1 = Integer.parseInt(grade);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date today = new Date();
       
        String formatdate = sdf.format(today);
        int year = Integer.parseInt(formatdate);
        
        String sql = "SELECT C.class_id AS 'Class ID', C.class_subclass AS 'Subclass',T.teacher_fullname AS 'Teacher Name'\n" +
                        "FROM teacher_personal_details T,classes C\n" +
                        "WHERE C.class_grade = '"+grade1+"' AND C.class_year = '"+year+"' AND C.teach_id = T.teacher_id ";
        
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_currentclasses.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(adminclassdetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_combo_gradeActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        int index=0;
        int selectedRow=0;
        int[] rows = tbl_all_students.getSelectedRows();
        
        for(int i = 0; i<rows.length;i++){
            selectedRow = rows[i];
            String name = tbl_all_students.getValueAt(selectedRow, 1).toString().trim();
            String id = tbl_all_students.getValueAt(selectedRow, 0).toString().trim();
            
            if(modelStudentList.getRowCount()>capacity-1){
                JOptionPane.showMessageDialog(rootPane, "Class Full");
                        
            }
            else{
                modelStudentList.addRow(new Object[]{id,name});
                tbl_selected_students.setModel(modelStudentList);
                model.removeRow(selectedRow);
                tbl_all_students.setModel(model);
            }
            
            
            
        }
    }//GEN-LAST:event_btn_insertActionPerformed

    private void tbl_class_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_class_listMouseClicked
        int rowSelected = tbl_class_list.getSelectedRow();
        
        int grade = Integer.parseInt(tbl_class_list.getValueAt(rowSelected, 2).toString().trim());
        classID = tbl_class_list.getValueAt(rowSelected, 0).toString().trim();
        capacity = Integer.parseInt(tbl_class_list.getValueAt(rowSelected, 4).toString().trim());
        try {
            studentListLoad(grade);
        } catch (SQLException ex) {
            Logger.getLogger(adminclassdetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_class_listMouseClicked

    private void btn_submitClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitClassActionPerformed
        int rowCount = tbl_selected_students.getRowCount();
        for(int i = 0;i<rowCount;i++){
            String studentNo = tbl_selected_students.getValueAt(i, 0).toString().trim();
            String classID = this.classID;
            
            String sql = "INSERT INTO student_class (std_adno,class_id) VALUES ('"+studentNo+"','"+this.classID+"')";
            try {
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Process Success !");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(adminclassdetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        DefaultTableModel clear = new DefaultTableModel();
        
        tbl_all_students.setModel(clear);
        tbl_selected_students.setModel(clear);
    }//GEN-LAST:event_btn_submitClassActionPerformed

    private void btn_print_student_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print_student_listActionPerformed
        
        String path;
        JFileChooser savefile = new JFileChooser();
        int result = savefile.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
             Path pathh = savefile.getSelectedFile().toPath();
             path = pathh.toString().trim();
             
             String filename = path;
             PDDocument doc = new PDDocument();
             PDPage page = new PDPage();
             doc.addPage(page);
             
             PDPageContentStream content;
            try {
                content = new PDPageContentStream(doc, page);
                //Document Image
                PDImageXObject pdImage = PDImageXObject.createFromFile("src\\admin\\logo.png", doc);
                content.drawImage(pdImage, 230, 620);
                
                String grade = combograde.getSelectedItem().toString().trim();
                String subclass = jComboBox2.getSelectedItem().toString().trim();
                String year = Integer.toString(jYearChooser1.getYear());
                
                content.beginText();
                content.setFont(PDType1Font.HELVETICA_BOLD, 12);
                content.moveTextPositionByAmount(230, 520);
                content.drawString("Student List");
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.HELVETICA_BOLD, 12);
                content.moveTextPositionByAmount(230, 500);
                content.drawString("Grade : "+grade+"  Class : "+subclass+" Year : "+year);
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.HELVETICA_BOLD, 12);
                content.moveTextPositionByAmount(80, 480);
                content.drawString("Student No");
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.HELVETICA_BOLD, 12);
                content.moveTextPositionByAmount(180, 480);
                content.drawString("Student Name");
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.HELVETICA_BOLD, 12);
                content.moveTextPositionByAmount(350, 480);
                content.drawString("Student Birthday");
                content.endText();
                
                int y = 460;
                int rowCount = jTable1.getRowCount();
               
                for(int i = 0; i<rowCount;i++){
                    String studentNo = jTable1.getValueAt(i, 0).toString().trim();
                    String studentName = jTable1.getValueAt(i, 1).toString().trim();
                    String birthday = jTable1.getValueAt(i, 2).toString().trim();
                    
                    content.beginText();
                    content.setFont(PDType1Font.HELVETICA, 12);
                    content.moveTextPositionByAmount(80, y);
                    content.drawString(studentNo);
                    content.endText();
                    
                    content.beginText();
                    content.setFont(PDType1Font.HELVETICA, 12);
                    content.moveTextPositionByAmount(180, y);
                    content.drawString(studentName);
                    content.endText();
                    
                    content.beginText();
                    content.setFont(PDType1Font.HELVETICA, 12);
                    content.moveTextPositionByAmount(350, y);
                    content.drawString(birthday);
                    content.endText();
                    
                    
                     y = y-20;
            
                }
                content.close();
               doc.save(filename);
               doc.close();
                
                
            } catch (IOException ex) {
                Logger.getLogger(adminclassdetails.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             
             
             
             
             
             
             
        }
        
        
    }//GEN-LAST:event_btn_print_student_listActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea birthdays;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_print_student_list;
    private javax.swing.JButton btn_submit;
    private javax.swing.JButton btn_submit1;
    private javax.swing.JButton btn_submitClass;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combo_grade;
    private javax.swing.JComboBox<String> combograde;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JRadioButton radioclass;
    private javax.swing.JRadioButton radioteacherid;
    private javax.swing.JTable table_currentclasses;
    private javax.swing.JTable table_teachers;
    private javax.swing.JPanel tablepanal;
    private javax.swing.JTable tbl_all_students;
    private javax.swing.JTable tbl_class_list;
    private javax.swing.JTable tbl_selected_students;
    private javax.swing.JTextField txt_capacity;
    private com.toedter.calendar.JYearChooser txt_classyear;
    private javax.swing.JTextField txt_noofstudents;
    private javax.swing.JTextField txt_subclass;
    private javax.swing.JTextField txt_teacherid;
    // End of variables declaration//GEN-END:variables
}
