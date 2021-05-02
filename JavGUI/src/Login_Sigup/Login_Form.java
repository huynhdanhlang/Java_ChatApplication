/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login_Sigup;
import Server_GUI.ServerGUI;
import Client_GUI.ClientGUI;
import Server_GUI.Server;
import com.mysql.cj.jdbc.result.ResultSetInternalMethods;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class Login_Form extends javax.swing.JFrame {

    /**
     * Creates new form MyForm
     */
    public Login_Form() {
        initComponents();
        
        //Center form
        this.setLocationRelativeTo(null);
        
        //Create a border yellow color
        //Border jpanel_title_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
        //set border yellow to Jpanel_title
        //Jpanel_title.setBorder(jpanel_title_border);
        
        //set border label_minimize and label_close
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_minimize.setBorder(label_border);
        jLabel_close.setBorder(label_border);
        
        //Create border for JTextField and JpasswordFeild
        Border user_pass_border = BorderFactory.createMatteBorder(1, 5, 1, 1, new Color(137, 197, 101));
        jTextField_username.setBorder(user_pass_border);
        jPasswordField_password.setBorder(user_pass_border);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_signup = new javax.swing.JLabel();
        jLabel_close = new javax.swing.JLabel();
        jLabel_minimize = new javax.swing.JLabel();
        Jpanel_title = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton_Login = new javax.swing.JButton();
        jPasswordField_password = new javax.swing.JPasswordField();
        jTextField_username = new javax.swing.JTextField();
        jLabel_username = new javax.swing.JLabel();
        jLabel_password = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(122, 54, 143));

        jPanel2.add(new JLabel(new ImageIcon("/images/vutru.jpg")));
        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setLayout(null);

        jLabel_signup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_signup.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_signup.setText(">>Đăng ký tài khoản<<");
        jLabel_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_signupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_signupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_signupMouseExited(evt);
            }
        });
        jPanel3.add(jLabel_signup);
        jLabel_signup.setBounds(110, 280, 160, 20);

        jLabel_close.setFont(new java.awt.Font("UTM American Sans", 0, 18)); // NOI18N
        jLabel_close.setText(" X");
        jLabel_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseExited(evt);
            }
        });
        jPanel3.add(jLabel_close);
        jLabel_close.setBounds(346, 10, 24, 21);

        jLabel_minimize.setFont(new java.awt.Font("UTM American Sans", 0, 24)); // NOI18N
        jLabel_minimize.setText(" -");
        jLabel_minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseExited(evt);
            }
        });
        jPanel3.add(jLabel_minimize);
        jLabel_minimize.setBounds(316, 10, 24, 21);

        Jpanel_title.setBackground(new java.awt.Color(122, 54, 143));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("LOGIN");

        javax.swing.GroupLayout Jpanel_titleLayout = new javax.swing.GroupLayout(Jpanel_title);
        Jpanel_title.setLayout(Jpanel_titleLayout);
        Jpanel_titleLayout.setHorizontalGroup(
            Jpanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpanel_titleLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        Jpanel_titleLayout.setVerticalGroup(
            Jpanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel_titleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(Jpanel_title);
        Jpanel_title.setBounds(126, 0, 0, 0);

        jButton_Login.setBackground(new java.awt.Color(51, 102, 255));
        jButton_Login.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_Login.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Login.setText("Đăng nhập");
        jButton_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_LoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_LoginMouseExited(evt);
            }
        });
        jButton_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LoginActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_Login);
        jButton_Login.setBounds(130, 220, 120, 27);

        jPasswordField_password.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPasswordField_password.setForeground(new java.awt.Color(167, 171, 176));
        jPasswordField_password.setText("password");
        jPasswordField_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField_passwordFocusLost(evt);
            }
        });
        jPanel3.add(jPasswordField_password);
        jPasswordField_password.setBounds(90, 140, 230, 30);

        jTextField_username.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_username.setForeground(new java.awt.Color(167, 171, 176));
        jTextField_username.setText("username");
        jTextField_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_usernameFocusLost(evt);
            }
        });
        jPanel3.add(jTextField_username);
        jTextField_username.setBounds(90, 90, 230, 30);

        jLabel_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/account.png"))); // NOI18N
        jPanel3.add(jLabel_username);
        jLabel_username.setBounds(40, 80, 40, 40);

        jLabel_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password.png"))); // NOI18N
        jPanel3.add(jLabel_password);
        jLabel_password.setBounds(40, 130, 40, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loginBackground.jpg"))); // NOI18N
        jPanel3.add(jLabel2);
        jLabel2.setBounds(0, 0, 380, 312);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseExited
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_close.setBorder(label_border);
        jLabel_close.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_closeMouseExited

    private void jLabel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseEntered
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_close.setBorder(label_border);
        jLabel_close.setForeground(Color.white);
    }//GEN-LAST:event_jLabel_closeMouseEntered

    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseClicked
        //Close app
        System.exit(0);
    }//GEN-LAST:event_jLabel_closeMouseClicked

    private void jLabel_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseExited
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_minimize.setBorder(label_border);
        jLabel_minimize.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_minimizeMouseExited

    private void jLabel_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseEntered
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_minimize.setBorder(label_border);
        jLabel_minimize.setForeground(Color.white);
    }//GEN-LAST:event_jLabel_minimizeMouseEntered

    private void jLabel_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseClicked
        //Minimize app
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimizeMouseClicked

    private void jButton_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LoginActionPerformed
        PreparedStatement st ;
        ResultSetInternalMethods rs ;
        //get username and password
        String username = jTextField_username.getText();
        String password = String.valueOf(jPasswordField_password.getPassword());

        String query = "SELECT * FROM `user` WHERE `username` = ? AND `password` = ?";

        try {
            st = MySQL_connect.getConnection().prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            System.out.println(st);
            rs =  (ResultSetInternalMethods) st.executeQuery();

            if(rs.next()){
                //show new Form
                Menu_Form menu =new Menu_Form();
                ServerGUI server = new ServerGUI();
                ClientGUI client = new ClientGUI();
                menu.setVisible(true);
                server.setVisible(true);
                client.setVisible(true);
                menu.pack();
                server.pack();
                client.pack();
                menu.setLocationRelativeTo(null);
                server.setLocationRelativeTo(null);
                client.setLocationRelativeTo(null);
                this.dispose();
            }
            else{
                //Error
                JOptionPane.showMessageDialog(null, "Invalid Username / Password ", "Login Error", 2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_LoginActionPerformed

    private void jButton_LoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LoginMouseExited
        jButton_Login.setBackground(new Color(51,102,255));
    }//GEN-LAST:event_jButton_LoginMouseExited

    private void jButton_LoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LoginMouseEntered
        jButton_Login.setBackground(new Color(46, 130, 233));
    }//GEN-LAST:event_jButton_LoginMouseEntered

    private void jPasswordField_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField_passwordFocusLost
        String pass = String.valueOf(jPasswordField_password.getPassword());
        if(pass.trim().toLowerCase().equals("password") || pass.trim().equals(""))
        {
            jPasswordField_password.setText("password");
            jPasswordField_password.setForeground(new Color(167,171,176));
        }
        // remove border jlabel icon
        jLabel_password.setBorder(null);
    }//GEN-LAST:event_jPasswordField_passwordFocusLost

    private void jPasswordField_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField_passwordFocusGained
        //get text PasswordFeild
        String pass = String.valueOf(jPasswordField_password.getPassword());
        if(pass.trim().toLowerCase().equals("password")){
            jPasswordField_password.setText("");
            jPasswordField_password.setForeground(Color.black);
        }
        //set border to label icon
        //Create a border yellow color
        Border jpanel_title_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow);
        //set border black to Jpanel_title
        jLabel_password.setBorder(jpanel_title_border);
    }//GEN-LAST:event_jPasswordField_passwordFocusGained

    private void jTextField_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_usernameFocusLost
        if(jTextField_username.getText().trim().toLowerCase().equals("username") || jTextField_username.getText().trim().equals(""))
        {
            jTextField_username.setText("username");
            jTextField_username.setForeground(new Color(167,171,176));
        }
        // remove border jlabel icon
        jLabel_username.setBorder(null);
    }//GEN-LAST:event_jTextField_usernameFocusLost

    private void jTextField_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_usernameFocusGained
        //clear TextFeild
        if(jTextField_username.getText().trim().toLowerCase().equals("username")){
            jTextField_username.setText("");
            jTextField_username.setForeground(Color.black);
        }
        //set border to label icon
        //Create a border yellow color
        Border jpanel_title_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow);
        //set border black to Jpanel_title
        jLabel_username.setBorder(jpanel_title_border);
    }//GEN-LAST:event_jTextField_usernameFocusGained

    private void jLabel_signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_signupMouseClicked
        Register_Form reg = new Register_Form();
        reg.setVisible(true);
        reg.pack();
        reg.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLabel_signupMouseClicked

    private void jLabel_signupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_signupMouseEntered
        jLabel_signup.setForeground(Color.white);
    }//GEN-LAST:event_jLabel_signupMouseEntered

    private void jLabel_signupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_signupMouseExited
        jLabel_signup.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_jLabel_signupMouseExited

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel_title;
    private javax.swing.JButton jButton_Login;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_minimize;
    private javax.swing.JLabel jLabel_password;
    private javax.swing.JLabel jLabel_signup;
    private javax.swing.JLabel jLabel_username;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField_password;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}
