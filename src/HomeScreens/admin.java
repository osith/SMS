/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeScreens;

import Login.Login;
import admin.AdminStudentDetails;
import admin.adminattendance;
import java.awt.Color;
import javax.swing.JPanel;
import admin.*;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author S.D. Sugathapala
 */
public class admin extends javax.swing.JFrame {

    String user;

    /**
     * Creates new form admin
     */
    public admin(String techerid) {
        this.setAlwaysOnTop(true);
        setExtendedState(MAXIMIZED_BOTH);
        //this.setLocationByPlatform(rootPaneCheckingEnabled);
        //this.setUndecorated(true);
        initComponents();
        
        this.user = techerid;
        Toolkit tk = Toolkit.getDefaultToolkit();
        
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);

        if (!user.equals("admin")) {
            pnl_userAccounts.hide();
        }
    }

    private admin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        pnl_studentDetails = new javax.swing.JPanel();
        btn_StudentDetails = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnl_attendance = new javax.swing.JPanel();
        btn_attendance = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnl_performace = new javax.swing.JPanel();
        btn_performace = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnl_leadership1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pnl_classDetails = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pnl_userAccounts = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_profilePic = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        deskpanal = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbl_minimized = new javax.swing.JLabel();
        lbl_exit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1, 2147483647));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        bg.setBackground(new java.awt.Color(255, 255, 255));

        sidepane.setBackground(new java.awt.Color(0, 204, 153));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_studentDetails.setBackground(new java.awt.Color(0, 220, 153));
        pnl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_studentDetailsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_studentDetailsMousePressed(evt);
            }
        });

        btn_StudentDetails.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_StudentDetails.setForeground(new java.awt.Color(255, 255, 255));
        btn_StudentDetails.setText("Student Details");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student-with-graduation-cap (2).png"))); // NOI18N

        javax.swing.GroupLayout pnl_studentDetailsLayout = new javax.swing.GroupLayout(pnl_studentDetails);
        pnl_studentDetails.setLayout(pnl_studentDetailsLayout);
        pnl_studentDetailsLayout.setHorizontalGroup(
            pnl_studentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_studentDetailsLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_StudentDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnl_studentDetailsLayout.setVerticalGroup(
            pnl_studentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_studentDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_studentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_StudentDetails)
                    .addComponent(jLabel3))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        sidepane.add(pnl_studentDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 40));

        pnl_attendance.setBackground(new java.awt.Color(0, 204, 153));
        pnl_attendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_attendanceMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_attendanceMousePressed(evt);
            }
        });

        btn_attendance.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_attendance.setForeground(new java.awt.Color(255, 255, 255));
        btn_attendance.setText("Attendance");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/attendance.png"))); // NOI18N

        javax.swing.GroupLayout pnl_attendanceLayout = new javax.swing.GroupLayout(pnl_attendance);
        pnl_attendance.setLayout(pnl_attendanceLayout);
        pnl_attendanceLayout.setHorizontalGroup(
            pnl_attendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_attendanceLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_attendance)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        pnl_attendanceLayout.setVerticalGroup(
            pnl_attendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_attendanceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_attendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_attendance)
                    .addComponent(jLabel5))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        sidepane.add(pnl_attendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 230, -1));

        pnl_performace.setBackground(new java.awt.Color(0, 204, 153));
        pnl_performace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_performaceMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_performaceMousePressed(evt);
            }
        });

        btn_performace.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_performace.setForeground(new java.awt.Color(255, 255, 255));
        btn_performace.setText("Exam Performance");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exam.png"))); // NOI18N

        javax.swing.GroupLayout pnl_performaceLayout = new javax.swing.GroupLayout(pnl_performace);
        pnl_performace.setLayout(pnl_performaceLayout);
        pnl_performaceLayout.setHorizontalGroup(
            pnl_performaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_performaceLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_performace)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnl_performaceLayout.setVerticalGroup(
            pnl_performaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_performaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_performaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_performace)
                    .addComponent(jLabel13))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        sidepane.add(pnl_performace, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("School Management System");
        sidepane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 190, 30));
        sidepane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 210, 20));

        pnl_leadership1.setBackground(new java.awt.Color(0, 204, 153));
        pnl_leadership1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_leadership1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_leadership1MousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Teacher Details");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leadership.png"))); // NOI18N

        javax.swing.GroupLayout pnl_leadership1Layout = new javax.swing.GroupLayout(pnl_leadership1);
        pnl_leadership1.setLayout(pnl_leadership1Layout);
        pnl_leadership1Layout.setHorizontalGroup(
            pnl_leadership1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_leadership1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        pnl_leadership1Layout.setVerticalGroup(
            pnl_leadership1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_leadership1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_leadership1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        sidepane.add(pnl_leadership1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, -1));

        pnl_classDetails.setBackground(new java.awt.Color(0, 204, 153));
        pnl_classDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_classDetailsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_classDetailsMousePressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Class Details");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leadership.png"))); // NOI18N

        javax.swing.GroupLayout pnl_classDetailsLayout = new javax.swing.GroupLayout(pnl_classDetails);
        pnl_classDetails.setLayout(pnl_classDetailsLayout);
        pnl_classDetailsLayout.setHorizontalGroup(
            pnl_classDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_classDetailsLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        pnl_classDetailsLayout.setVerticalGroup(
            pnl_classDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_classDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_classDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        sidepane.add(pnl_classDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

        pnl_userAccounts.setBackground(new java.awt.Color(0, 204, 153));
        pnl_userAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_userAccountsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_userAccountsMousePressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("User Accounts");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leadership.png"))); // NOI18N

        javax.swing.GroupLayout pnl_userAccountsLayout = new javax.swing.GroupLayout(pnl_userAccounts);
        pnl_userAccounts.setLayout(pnl_userAccountsLayout);
        pnl_userAccountsLayout.setHorizontalGroup(
            pnl_userAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_userAccountsLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        pnl_userAccountsLayout.setVerticalGroup(
            pnl_userAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_userAccountsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_userAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        sidepane.add(pnl_userAccounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 230, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_profilePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user (3).png"))); // NOI18N
        jPanel1.add(lbl_profilePic, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 60, 60));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("WELCOME");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("USER");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1016, 41, -1, -1));

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        deskpanal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout deskpanalLayout = new javax.swing.GroupLayout(deskpanal);
        deskpanal.setLayout(deskpanalLayout);
        deskpanalLayout.setHorizontalGroup(
            deskpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1137, Short.MAX_VALUE)
        );
        deskpanalLayout.setVerticalGroup(
            deskpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(deskpanal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(deskpanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(deskpanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_minimized.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimise-button.png"))); // NOI18N
        lbl_minimized.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_minimizedMouseClicked(evt);
            }
        });
        jPanel5.add(lbl_minimized, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 20, 30));

        lbl_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        lbl_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_exitMouseClicked(evt);
            }
        });
        jPanel5.add(lbl_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 20, 30));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sidepane, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 32000, Short.MAX_VALUE))
            .addComponent(sidepane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1377, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    /**
     * lbl_exit chick event
     * @param evt mouse click event
     */
    private void lbl_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseClicked
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_exitMouseClicked

    /**
     * lbl_minimized click event
     * @param evt mouse click event
     */
    private void lbl_minimizedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizedMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_lbl_minimizedMouseClicked

    /**
     * pnl_studentDetails pressed event
     * @param evt mouse press event
     */
    private void pnl_studentDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_studentDetailsMousePressed
        setColour(pnl_studentDetails);
        resetColour(pnl_attendance);
        resetColour(pnl_performace);
        resetColour(pnl_userAccounts);
        resetColour(pnl_leadership1);
        resetColour(pnl_classDetails);
    }//GEN-LAST:event_pnl_studentDetailsMousePressed

    /**
     * pnl_attendance click event
     * @param evt mouse click event
     */
    private void pnl_attendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_attendanceMouseClicked
        adminattendance n1;
        try {
            n1 = new adminattendance(user);
            deskpanal.removeAll();
            deskpanal.updateUI();
            deskpanal.add(n1).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pnl_attendanceMouseClicked

    /**
     * pnl_attendance press event
     * @param evt mouse press event
     */
    private void pnl_attendanceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_attendanceMousePressed
        setColour(pnl_attendance);
        resetColour(pnl_studentDetails);
        resetColour(pnl_performace);
        resetColour(pnl_userAccounts);
        resetColour(pnl_leadership1);
        resetColour(pnl_classDetails);
    }//GEN-LAST:event_pnl_attendanceMousePressed

    private void pnl_performaceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_performaceMousePressed

    }//GEN-LAST:event_pnl_performaceMousePressed

    private void pnl_leadership1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_leadership1MousePressed

    }//GEN-LAST:event_pnl_leadership1MousePressed

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed

    }//GEN-LAST:event_jLabel12MousePressed

    /**
     * pnl_studentDetails click event
     * @param evt mouse click event
     */
    private void pnl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_studentDetailsMouseClicked
        AdminStudentDetails n1 = new AdminStudentDetails(user);
        deskpanal.removeAll();
        deskpanal.updateUI();
        deskpanal.add(n1).setVisible(true);

        n1.setFrameIcon(null);
    }//GEN-LAST:event_pnl_studentDetailsMouseClicked

    private void pnl_performaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_performaceMouseClicked

    }//GEN-LAST:event_pnl_performaceMouseClicked

    private void pnl_leadership1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_leadership1MouseClicked

    }//GEN-LAST:event_pnl_leadership1MouseClicked

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MousePressed

    /**
     * pnl_classDetails click event
     * @param evt mouse click event
     */
    private void pnl_classDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_classDetailsMouseClicked

        adminclassdetails n1;
        try {
            n1 = new adminclassdetails();
            deskpanal.removeAll();
            deskpanal.updateUI();
            deskpanal.add(n1).setVisible(true);
        } catch (SQLException ex) {
            System.out.println("Malinda");
            //1Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pnl_classDetailsMouseClicked

    /**
     * pnl_classDetails press event
     * @param evt mouse press event
     */
    private void pnl_classDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_classDetailsMousePressed
        setColour(pnl_classDetails);
        resetColour(pnl_attendance);
        resetColour(pnl_studentDetails);
        resetColour(pnl_performace);
        resetColour(pnl_userAccounts);
        resetColour(pnl_leadership1);
    }//GEN-LAST:event_pnl_classDetailsMousePressed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MousePressed

    /**
     * pnl_userAccount click event
     * @param evt mouse click event
     */
    private void pnl_userAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_userAccountsMouseClicked

        adminUserAccounts usera;
        try {
            usera = new adminUserAccounts();
            deskpanal.removeAll();
            deskpanal.updateUI();
            deskpanal.add(usera).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pnl_userAccountsMouseClicked

    /**
     * pnl_userAccount press event
     * @param evt mouse press event
     */
    private void pnl_userAccountsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_userAccountsMousePressed
        resetColour(pnl_attendance);
        resetColour(pnl_studentDetails);
        resetColour(pnl_performace);
        setColour(pnl_userAccounts);
        resetColour(pnl_leadership1);
        resetColour(pnl_classDetails);
    }//GEN-LAST:event_pnl_userAccountsMousePressed

    /**
     * setColor method
     * @param pane1 pass the panel
     */
    void setColour(JPanel pane1) {
        pane1.setBackground(new Color(0, 220, 153));
    }

    /**
     * resetColor method
     * @param pane1 pass the panel
     */
    void resetColour(JPanel pane1) {
        pane1.setBackground(new Color(0, 204, 153));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel btn_StudentDetails;
    private javax.swing.JLabel btn_attendance;
    private javax.swing.JLabel btn_performace;
    private javax.swing.JPanel deskpanal;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_minimized;
    private javax.swing.JLabel lbl_profilePic;
    private javax.swing.JPanel pnl_attendance;
    private javax.swing.JPanel pnl_classDetails;
    private javax.swing.JPanel pnl_leadership1;
    private javax.swing.JPanel pnl_performace;
    private javax.swing.JPanel pnl_studentDetails;
    private javax.swing.JPanel pnl_userAccounts;
    private javax.swing.JPanel sidepane;
    // End of variables declaration//GEN-END:variables
}
