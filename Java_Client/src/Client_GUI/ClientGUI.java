package Client_GUI;

import Encrypt_Decrypt.EncrytDecrypt_Mess;
import java.awt.Color;
import java.awt.FlowLayout;
import Login_Sigup.MySQL_connect;
import com.mysql.cj.jdbc.result.ResultSetInternalMethods;
import java.awt.Image;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ClientGUI extends javax.swing.JFrame {
    PreparedStatement s;
    ResultSetInternalMethods rs;
    String username;
    String host;
    int port;
    Socket socket;
    DataOutputStream dos;
    public boolean attachmentOpen = false;
    private boolean isConnected = false;
    private String mydownloadfolder = "D:\\";
    final static String secretKey = "secrete";
    EncrytDecrypt_Mess encrypt = new EncrytDecrypt_Mess();
    private byte[] imagebytes;
    private Image image;

    public ClientGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
        chatArea.setParagraphAttributes(attr, true);
        jTextField_ip.setText("127.0.0.1");
        jTextField_port.setText("7880");
    
    }

    public void initFrame(String username) {
        this.username = username;
        setTitle("You are logged in as: " + username);
        /**
         * Connect *
         */
//        connect();
    }

    public String returnusername() {
        return this.username;
    }

    public void connect(String host, int port) throws BadLocationException {
        textPanel_append(" ??ang k???t n???i........");
        try {

            socket = new Socket(host, port);
            dos = new DataOutputStream(socket.getOutputStream());

            /**
             * Send our username *
             */
            String encrypt_username = encrypt.encrypt("CMD_SHOW_USER_JOIN_IN_CHAT " + returnusername(), secretKey);
            dos.writeUTF(encrypt_username);
            textPanel_append(" ???? k???t n???i" + "\n");
            textPanel_append(" B???n c?? th??? tr?? chuy???n ngay b??y gi???.!" + "\n");

            /**
             * Start Client Thread *
             */
            new Thread(new ClientThread(socket, this)).start();
            jButton_leave.setEnabled(true);
            // were now connected
            isConnected = true;
            
            jTextField_ip.setEditable(false);
            jTextField_port.setEditable(false);
            jButton_send.setEnabled(true);
            jButton_leave.setEnabled(true);
            jButton_sendfile.setEnabled(true);
            jButton_connect.setEnabled(false);

        } catch (IOException e) {
            isConnected = false;
            JOptionPane.showMessageDialog(this, " Kh??ng th??? k???t n???i v???i m??y ch???, vui l??ng th??? l???i sau.!", "K???t n???i th???t b???i", JOptionPane.ERROR_MESSAGE);
            jButton_connect.setEnabled(true);
            textPanel_append("[IOException]: " + e.getMessage());
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField_messagecontent = new javax.swing.JTextField();
        jButton_send = new javax.swing.JButton();
        jTextField_port = new javax.swing.JTextField();
        jTextField_ip = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_connect = new javax.swing.JButton();
        jButton_leave = new javax.swing.JButton();
        jButton_sendfile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textpanel_useronline = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jTextField_messagecontent.setToolTipText("text\tType your message here...");
        jPanel1.add(jTextField_messagecontent);
        jTextField_messagecontent.setBounds(110, 450, 400, 30);

        jButton_send.setBackground(new java.awt.Color(204, 204, 255));
        jButton_send.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_send.setText("G???i");
        jButton_send.setEnabled(false);
        jButton_send.setPreferredSize(new java.awt.Dimension(37, 22));
        jButton_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sendActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_send);
        jButton_send.setBounds(530, 450, 170, 30);
        jPanel1.add(jTextField_port);
        jTextField_port.setBounds(270, 80, 80, 30);
        jPanel1.add(jTextField_ip);
        jTextField_ip.setBounds(20, 80, 220, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("port:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 60, 30, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("Server address:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 60, 90, 16);

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LocalChat");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 240, 40);

        jButton_connect.setText("K???t n???i");
        jButton_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_connectActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_connect);
        jButton_connect.setBounds(380, 80, 80, 30);

        jButton_leave.setText("Tho??t ph??ng chat");
        jButton_leave.setEnabled(false);
        jButton_leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_leaveActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_leave);
        jButton_leave.setBounds(550, 80, 124, 30);

        jButton_sendfile.setText("G???i file");
        jButton_sendfile.setEnabled(false);
        jButton_sendfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sendfileActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_sendfile);
        jButton_sendfile.setBounds(19, 450, 80, 30);

        textpanel_useronline.setEditable(false);
        jScrollPane1.setViewportView(textpanel_useronline);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(530, 120, 170, 290);

        chatArea.setEditable(false);
        jScrollPane2.setViewportView(chatArea);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 122, 490, 290);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-10, 0, 730, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(746, 544));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_sendfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sendfileActionPerformed
        SendFile s = new SendFile();
        host = jTextField_ip.getText();
        port = Integer.valueOf(jTextField_port.getText());
        if (s.prepare(username, host, port, this)) {
            s.setLocationRelativeTo(null);
            s.setVisible(true);
            attachmentOpen = true;
        } else {
            JOptionPane.showMessageDialog(this, " Kh??ng th??? thi???t l???p Chia s??? T???p t???i th???i ??i???m n??y, vui l??ng th??? l???i sau.!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_sendfileActionPerformed

    private void jButton_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_connectActionPerformed
        String host = jTextField_ip.getText();
        String port = jTextField_port.getText();
        try {
            connect(host, Integer.valueOf(port));
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            jButton_connect.setEnabled(true);
            jTextField_ip.setEditable(true);
            jTextField_port.setEditable(true);
        }


    }//GEN-LAST:event_jButton_connectActionPerformed

    private void jButton_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sendActionPerformed
        try {
            String content = returnusername() + " " + jTextField_messagecontent.getText();
            System.out.println(content);
            String encrypt_content = encrypt.encrypt("CMD_SEND_CHAT_ALL_CLIENT"+ " " + content, secretKey);
            dos.writeUTF(encrypt_content);
            textPanel_append(" " + returnusername() + ":" + jTextField_messagecontent.getText() + "\n");
            jTextField_messagecontent.setText("");
        } catch (IOException e) {
            try {
                textPanel_append(" Kh??ng th??? g???i tin nh???n ngay b??y gi???, M??y ch??? kh??ng kh??? d???ng t???i th???i ??i???m n??y, vui l??ng th??? l???i sau ho???c Kh???i ?????ng l???i ???ng d???ng n??y.!");
            } catch (BadLocationException ex) {
                Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_sendActionPerformed

    private void jButton_leaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_leaveActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n tho??t ph??ng chat?","Th??ng b??o",JOptionPane.OK_CANCEL_OPTION);
        if (confirm == 0) {
            try {
                socket.close();
                jButton_leave.setEnabled(false);
                jButton_send.setEnabled(false);
                jButton_sendfile.setEnabled(false);  
                jButton_connect.setEnabled(true);
                jTextField_ip.setEditable(true);
                jTextField_port.setEditable(true);
//                setVisible(false);
                /**
                 * Login Form *
                 */
//                new Login_Sigup.Login_Form().setVisible(true);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    }//GEN-LAST:event_jButton_leaveActionPerformed

    //Insert messsge into jTextPanel
    public void textPanel_append(String str) throws BadLocationException {
        StyledDocument document = (StyledDocument) chatArea.getDocument();
        document.insertString(document.getLength(), str, null);
    }

    /*
        is Connected
     */
    public boolean isConnected() {
        return this.isConnected;
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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI().setVisible(true);

            }
        });
    }

    //---------------------------//
    /*
        Get image file path in online list
     */
    public ImageIcon getImageFile(String username) throws SQLException {
//        String getUsername = returnusername();
        System.out.println("This is username: " + username);

        String query = "SELECT `picture` FROM `user` WHERE `username` = ?";
        s = MySQL_connect.getConnection().prepareStatement(query);
        s.setString(1,username);
        rs = (ResultSetInternalMethods) s.executeQuery();
        if(rs.next()){
            imagebytes = rs.getBytes("picture");
        }
        image=getToolkit().createImage(imagebytes);
        
        Image img = image.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        ImageIcon icon=new ImageIcon(img);
        return icon;
    }

    /*
        Set myTitle
     */
    public void setMyTitle(String s) {
        setTitle(s);
    }

    /*
        Get My Download Folder
     */
    public String getMyDownloadFolder() {
        return this.mydownloadfolder;
    }

    /*
        Get Host
     */
    public String getMyHost() {
        return this.host=jTextField_ip.getText();
    }

    /*
        Get Port
     */
    public int getMyPort() {
        return this.port=Integer.valueOf(jTextField_port.getText());
    }

    /*
        Update Attachment 
     */
    public void updateAttachment(boolean b) {
        this.attachmentOpen = b;
    }

    /*
        This will open a file chooser
     */
    public void openFolder() {
        JFileChooser chooser= new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int open = chooser.showDialog(this, "Browse");
        if (open == chooser.APPROVE_OPTION) {
            mydownloadfolder = chooser.getSelectedFile().toString() + "\\";
        } else {
            mydownloadfolder = "D:\\";
        }
    }

    //------------Show Online List on TextJpanel
    public void appendOnlineList(String[] user,ImageIcon[] icon) throws SQLException {
        sampleOnlineList(user,icon);  // - Sample Method()
    }

    /*
      ************************************  Show Online Sample  *********************************************
     */
    private void sampleOnlineList(String[] user,ImageIcon[] icon) throws SQLException {
        textpanel_useronline.setEditable(true);
        textpanel_useronline.removeAll();
        textpanel_useronline.setText("");
//        Iterator i = list.iterator();
        for (int i=0;i<user.length;i++){
            /*  Show Online Username   */
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel.setBackground(Color.white);
//            Icon icon = new ImageIcon(this.getClass().getResource("/images/account.png"));
            JLabel label = new JLabel(icon[i]);
            System.out.println("Online list: " + user[i]);
            label.setText(" " + user[i]);
            panel.add(label);
            int len = textpanel_useronline.getDocument().getLength();
            textpanel_useronline.setCaretPosition(len);
            textpanel_useronline.insertComponent(panel);
            /*  Append Next Line   */
            sampleAppend();   
        }
            
        
        textpanel_useronline.setEditable(false);
    }

    //
    private void sampleAppend() {
        int len = textpanel_useronline.getDocument().getLength();
        textpanel_useronline.setCaretPosition(len);
        textpanel_useronline.replaceSelection("\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane chatArea;
    public javax.swing.JButton jButton_connect;
    private javax.swing.JButton jButton_leave;
    private javax.swing.JButton jButton_send;
    private javax.swing.JButton jButton_sendfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_ip;
    private javax.swing.JTextField jTextField_messagecontent;
    private javax.swing.JTextField jTextField_port;
    private javax.swing.JTextPane textpanel_useronline;
    // End of variables declaration//GEN-END:variables

}
