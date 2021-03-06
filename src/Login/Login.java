/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import DatabaseConnection.DbConnect;
import java.sql.Connection;
import javax.swing.JOptionPane;
import sql.loginsql;
import HomeScreens.*;
import java.awt.FlowLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
/**
 * This is Login class
 * @author S.D. Sugathapala
 */
public final class Login extends javax.swing.JFrame {
    Connection conn;
    loginsql loginSQL = new loginsql();
    
    public Login() {
        conn = DbConnect.ConnectDb();
        if (conn == null) {
            /**
             * dialogBox is an object from DialogBox class
             */
            DialogBox dialogBox = new DialogBox();
            dialogBox.setVisible(true);
        } else {
            initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        lbltitle1 = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnSubmit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radioAdmin = new javax.swing.JRadioButton();
        radioTeacher = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(614, 315));
        setMinimumSize(new java.awt.Dimension(614, 315));
        setPreferredSize(new java.awt.Dimension(713, 361));
        setResizable(false);
        setSize(new java.awt.Dimension(720, 361));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltitle1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbltitle1.setForeground(new java.awt.Color(0, 102, 102));
        lbltitle1.setText("VEEDIYA BANDARA MAHA VIDYALAYA");
        jPanel2.add(lbltitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 360, 31));

        lbltitle.setBackground(new java.awt.Color(0, 102, 51));
        lbltitle.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbltitle.setForeground(new java.awt.Color(0, 102, 102));
        lbltitle.setText("SCHOOL MANAGEMENT SYSTEM");
        jPanel2.add(lbltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 230, 31));

        txtUserName.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(0, 102, 102));
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 220, 30));

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 210, 220, 30));

        btnSubmit.setBackground(new java.awt.Color(0, 153, 51));
        btnSubmit.setForeground(new java.awt.Color(0, 153, 102));
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/login.png"))); // NOI18N
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel2.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 110, 40));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, 30));
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, 30));

        radioAdmin.setBackground(new java.awt.Color(0, 204, 153));
        buttonGroup1.add(radioAdmin);
        radioAdmin.setForeground(new java.awt.Color(255, 255, 255));
        radioAdmin.setText("Admin");
        jPanel2.add(radioAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        radioTeacher.setBackground(new java.awt.Color(0, 204, 153));
        buttonGroup1.add(radioTeacher);
        radioTeacher.setForeground(new java.awt.Color(255, 255, 255));
        radioTeacher.setText("Teacher");
        jPanel2.add(radioTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 500, 360));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/125px-Isipathana_College2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 360));

        setSize(new java.awt.Dimension(725, 398));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        
    }//GEN-LAST:event_txtUserNameActionPerformed

    /**
     * btnSubmit click event
     * @param evt mouse click event
     */
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        
        if (txtUserName.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please enter the Username.");
        } else if (txtPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please enter the Password");
        } else {
            String user = txtUserName.getText();
            String password =txtPassword.getText();
            
            if(radioTeacher.isSelected()){
                if (loginSQL.teacherlogin(user, password)) {
                    try {                        
                        loginSQL.user_log(user, "teacher");                       
                        admin t1 = new admin(user);
                        t1.setVisible(true);
                        this.setVisible(false);
                    } catch (Exception ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Invalid login details..!!!");
                }
            } else if(radioAdmin.isSelected()) {
                if (loginSQL.adminlogin(user, password)) {    
                    try {
                        loginSQL.user_log(user, "admin");
                        admin ad = new admin(user);
                        ad.setVisible(true);
                        this.setVisible(false);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                } else {
                    JOptionPane.showMessageDialog(rootPane, "INvalid login details..!!!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please select the role");
            }  
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lbltitle1;
    private javax.swing.JRadioButton radioAdmin;
    private javax.swing.JRadioButton radioTeacher;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
