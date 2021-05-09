/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login_Sigup;

import com.mysql.cj.jdbc.result.ResultSetInternalMethods;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ASUS
 */
public class Register_Form extends javax.swing.JFrame {

    /**
     * Creates new form Register_Form
     */
    //Create a btn Group
    ButtonGroup btn = new ButtonGroup();
    //Craete a path image
    String path_image = null;
    
    public Register_Form() {
        initComponents();

        this.setLocationRelativeTo(null);

        //set border label_minimize and label_close
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_minimize.setBorder(label_border);
        jLabel_close.setBorder(label_border);

        //Create border for JTextField and JpasswordFeild
        Border user_pass_border = BorderFactory.createMatteBorder(1, 5, 1, 1, new Color(230, 93, 16));
        jTextField_fullname.setBorder(user_pass_border);
        jTextField_username.setBorder(user_pass_border);
        jPasswordField_password.setBorder(user_pass_border);
        jPasswordField_confirmpass.setBorder(user_pass_border);
        jTextField_phone.setBorder(user_pass_border);

        //Add a button group
        btn.add(jRadioButton_male);
        btn.add(jRadioButton_female);
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
        jLabel_close = new javax.swing.JLabel();
        jLabel_minimize = new javax.swing.JLabel();
        Jpanel_title = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton_sigup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField_fullname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_phone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton_male = new javax.swing.JRadioButton();
        jRadioButton_female = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jButton_select_images = new javax.swing.JButton();
        jLabel_pathimages = new javax.swing.JLabel();
        jPasswordField_password = new javax.swing.JPasswordField();
        jPasswordField_confirmpass = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setLayout(null);

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
        jLabel_close.setBounds(400, 10, 24, 21);

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
        jLabel_minimize.setBounds(370, 10, 24, 21);

        Jpanel_title.setBackground(new java.awt.Color(0, 153, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Register");

        javax.swing.GroupLayout Jpanel_titleLayout = new javax.swing.GroupLayout(Jpanel_title);
        Jpanel_title.setLayout(Jpanel_titleLayout);
        Jpanel_titleLayout.setHorizontalGroup(
            Jpanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel_titleLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        Jpanel_titleLayout.setVerticalGroup(
            Jpanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel_titleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(Jpanel_title);
        Jpanel_title.setBounds(150, 0, 136, 41);

        jButton_sigup.setBackground(new java.awt.Color(255, 92, 34));
        jButton_sigup.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_sigup.setForeground(new java.awt.Color(255, 255, 255));
        jButton_sigup.setText("Đăng ký");
        jButton_sigup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_sigup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_sigupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_sigupMouseExited(evt);
            }
        });
        jButton_sigup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sigupActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_sigup);
        jButton_sigup.setBounds(170, 340, 100, 41);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Full name");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(60, 100, 50, 23);

        jTextField_fullname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_fullname.setPreferredSize(new java.awt.Dimension(7, 22));
        jPanel3.add(jTextField_fullname);
        jTextField_fullname.setBounds(130, 100, 210, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Username");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(60, 130, 60, 23);

        jTextField_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_username.setPreferredSize(new java.awt.Dimension(7, 22));
        jPanel3.add(jTextField_username);
        jTextField_username.setBounds(130, 130, 210, 19);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Password");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(60, 160, 50, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Confirm Password");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 190, 95, 23);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Phone");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(80, 220, 40, 23);

        jTextField_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_phone.setPreferredSize(new java.awt.Dimension(7, 22));
        jTextField_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_phoneKeyTyped(evt);
            }
        });
        jPanel3.add(jTextField_phone);
        jTextField_phone.setBounds(130, 220, 211, 23);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Gender");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(80, 250, 40, 23);

        jRadioButton_male.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton_male.setText("Male");
        jPanel3.add(jRadioButton_male);
        jRadioButton_male.setBounds(130, 250, 47, 19);

        jRadioButton_female.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton_female.setText("Female");
        jPanel3.add(jRadioButton_female);
        jRadioButton_female.setBounds(200, 250, 61, 19);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Image");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(80, 280, 40, 23);

        jButton_select_images.setText("select image");
        jButton_select_images.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_select_imagesActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_select_images);
        jButton_select_images.setBounds(130, 280, 100, 22);

        jLabel_pathimages.setText("image path");
        jPanel3.add(jLabel_pathimages);
        jLabel_pathimages.setBounds(240, 280, 180, 20);

        jPasswordField_password.setPreferredSize(new java.awt.Dimension(7, 22));
        jPanel3.add(jPasswordField_password);
        jPasswordField_password.setBounds(130, 160, 210, 22);

        jPasswordField_confirmpass.setPreferredSize(new java.awt.Dimension(7, 22));
        jPanel3.add(jPasswordField_confirmpass);
        jPasswordField_confirmpass.setBounds(130, 190, 211, 22);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/NewsletterSignup-Background.jpg"))); // NOI18N
        jPanel3.add(jLabel10);
        jLabel10.setBounds(0, 0, 440, 410);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_sigupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_sigupMouseEntered
        jButton_sigup.setBackground(new Color(255, 82, 20));
    }//GEN-LAST:event_jButton_sigupMouseEntered

    private void jButton_sigupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_sigupMouseExited
        jButton_sigup.setBackground(new Color(255, 92, 34));
    }//GEN-LAST:event_jButton_sigupMouseExited

//    public void clearFields() {
//        jTextField_fullname.setText("");
//        jTextField_username.setText("");
//        jPasswordField_password.setText("");
//        jPasswordField_confirmpass.setText("");
//        jTextField_phone.setText("");
//        path_image = "";
//        btn.clearSelection();
//
//    }
    private void jButton_sigupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sigupActionPerformed
        String full_name = jTextField_fullname.getText();
        String username = jTextField_username.getText();
        String password = String.valueOf(jPasswordField_password.getPassword());
        String phone = jTextField_phone.getText();
        String gender = "Male";

        if (jRadioButton_female.isSelected()) {
            gender = "Female";
        }
        if (checkFields()) {
            try {
                if (!checkUsername(username)) {
                    PreparedStatement s;
                    String query = "INSERT INTO `user`(`full_name`, `username`, `password`, `phone`, `gender`, `picture`) VALUES (?,?,?,?,?,?)";

                    s = MySQL_connect.getConnection().prepareStatement(query);
                    s.setString(1, full_name);
                    s.setString(2, username);
                    s.setString(3, password);
                    s.setString(4, phone);
                    s.setString(5, gender);

                    try {
                        if (path_image != null) {
                            InputStream image = new FileInputStream(new File(path_image));
                            s.setBlob(6, image);
                        } else {
                            s.setNull(6, java.sql.Types.NULL);
                        }

                        if (s.executeUpdate() != 0) {
                            JOptionPane.showMessageDialog(this, "Account created successfully");
                        } else {
                            JOptionPane.showMessageDialog(this, "Create fail! Check your information");
                        }
//                        clearFields();
                        Login_Form log = new Login_Form();
                        log.setVisible(true);
                        log.pack();
                        log.setLocationRelativeTo(null);
                        this.dispose();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Register_Form.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(Register_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_sigupActionPerformed

    private void jLabel_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseClicked
        //Minimize app
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimizeMouseClicked

    private void jLabel_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseEntered
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_minimize.setBorder(label_border);
        jLabel_minimize.setForeground(Color.white);
    }//GEN-LAST:event_jLabel_minimizeMouseEntered

    private void jLabel_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseExited
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_minimize.setBorder(label_border);
        jLabel_minimize.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_minimizeMouseExited

    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseClicked
        //Close app
        Login_Form login = new Login_Form();
        login.setVisible(true);
        login.pack();
        this.dispose();
    }//GEN-LAST:event_jLabel_closeMouseClicked

    private void jLabel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseEntered
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_close.setBorder(label_border);
        jLabel_close.setForeground(Color.white);
    }//GEN-LAST:event_jLabel_closeMouseEntered

    private void jLabel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseExited
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_close.setBorder(label_border);
        jLabel_close.setForeground(Color.black);

    }//GEN-LAST:event_jLabel_closeMouseExited

    private void jTextField_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_phoneKeyTyped
        // Only allow input number
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_phoneKeyTyped

    private void jButton_select_imagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_select_imagesActionPerformed
        String path = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        //file extension
        FileNameExtensionFilter extension = new FileNameExtensionFilter("*Images", "jpg", "png", "jpeg");
        chooser.addChoosableFileFilter(extension);

        int filestate = chooser.showSaveDialog(null);
        //check if the user choose a image
        if (filestate == JFileChooser.APPROVE_OPTION) {
            File select_image = chooser.getSelectedFile();
            path = select_image.getAbsolutePath();
            jLabel_pathimages.setText(path);
            path_image = path;
        }
    }//GEN-LAST:event_jButton_select_imagesActionPerformed

    //Check input fields 
    public boolean checkFields() {
        String full_name = jTextField_fullname.getText();
        String username = jTextField_username.getText();
        String password = String.valueOf(jPasswordField_password.getPassword());
        String confirmpass = String.valueOf(jPasswordField_confirmpass.getPassword());
        String phone = jTextField_phone.getText();

        if (full_name.trim().equals("") || username.trim().equals("")
                || password.trim().equals("") || confirmpass.trim().equals("")
                || phone.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "one or more field empty");
            return false;
        } else if (!password.equals(confirmpass)) {
            JOptionPane.showMessageDialog(this, "password don't match. Please check again.");
            return false;
        } else {
            return true;
        }
    }

    //check username is already used in database.
    public boolean checkUsername(String username) throws SQLException {
        PreparedStatement s;
        ResultSetInternalMethods rs;
        boolean username_is_exist = false;
        String query = "SELECT * FROM `user` WHERE `username`= ?";

        s = MySQL_connect.getConnection().prepareStatement(query);
        s.setString(1, username);
        rs = (ResultSetInternalMethods) s.executeQuery();
        while (rs.next()) {
            username_is_exist = true;
            JOptionPane.showMessageDialog(this, "Username is already used.");
        }
        return username_is_exist;
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel_title;
    private javax.swing.JButton jButton_select_images;
    private javax.swing.JButton jButton_sigup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_minimize;
    private javax.swing.JLabel jLabel_pathimages;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField_confirmpass;
    private javax.swing.JPasswordField jPasswordField_password;
    private javax.swing.JRadioButton jRadioButton_female;
    private javax.swing.JRadioButton jRadioButton_male;
    private javax.swing.JTextField jTextField_fullname;
    private javax.swing.JTextField jTextField_phone;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}
