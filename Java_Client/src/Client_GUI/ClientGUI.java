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
        textPanel_append(" Connecting........");
        try {

            socket = new Socket(host, port);
            dos = new DataOutputStream(socket.getOutputStream());

            /**
             * Send our username *
             */
            String encrypt_username = encrypt.encrypt("CMD_SHOW_USER_JOIN_IN_CHAT " + returnusername(), secretKey);
            dos.writeUTF(encrypt_username);
            textPanel_append(" Connected" + "\n");
            textPanel_append(" type your message now.!" + "\n");

            /**
             * Start Client Thread *
             */
            new Thread(new ClientThread(socket, this)).start();
            jButton1.setEnabled(true);
            // were now connected
            isConnected = true;

        } catch (IOException e) {
            isConnected = false;
            JOptionPane.showMessageDialog(this, "Unable to Connect to Server, please try again later.!", "Connection Failed", JOptionPane.ERROR_MESSAGE);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
        jTextField_messagecontent.setBounds(30, 340, 310, 30);

        jButton_send.setBackground(new java.awt.Color(204, 204, 255));
        jButton_send.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_send.setText("Send Message");
        jButton_send.setPreferredSize(new java.awt.Dimension(37, 22));
        jButton_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sendActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_send);
        jButton_send.setBounds(350, 340, 110, 30);
        jPanel1.add(jTextField_port);
        jTextField_port.setBounds(270, 80, 80, 30);
        jPanel1.add(jTextField_ip);
        jTextField_ip.setBounds(30, 80, 210, 30);

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
        jLabel2.setText("Chat");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 120, 40);

        jButton_connect.setText("Connect");
        jButton_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_connectActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_connect);
        jButton_connect.setBounds(380, 80, 80, 30);

        jButton1.setText("Leave chat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(370, 10, 86, 22);

        jButton2.setText("Send file");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(30, 310, 90, 20);

        textpanel_useronline.setEditable(false);
        jScrollPane1.setViewportView(textpanel_useronline);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(350, 120, 110, 180);

        chatArea.setEditable(false);
        jScrollPane2.setViewportView(chatArea);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 122, 310, 180);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(508, 441));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SendFile s = new SendFile();
        host = jTextField_ip.getText();
        port = Integer.valueOf(jTextField_port.getText());
        if (s.prepare(username, host, port, this)) {
            s.setLocationRelativeTo(null);
            s.setVisible(true);
            attachmentOpen = true;
        } else {
            JOptionPane.showMessageDialog(this, "Unable to establish File Sharing at this moment, please try again later.!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
        jButton_connect.setEnabled(false);
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
                textPanel_append(" Unable to Send Message now, Server is not available at this time please try again later or Restart this Application.!");
            } catch (BadLocationException ex) {
                Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_sendActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Logout your Account.?");
        if (confirm == 0) {
            try {
                socket.close();
//                setVisible(false);
                /**
                 * Login Form *
                 */
//                new Login_Sigup.Login_Form().setVisible(true);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        jButton_connect.setEnabled(true);
        jTextField_ip.setEditable(true);
        jTextField_port.setEditable(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    public ImageIcon getImageFile() throws SQLException {
        String getUsername = returnusername();
        String query = "SELECT `picture` FROM `user` WHERE `username` = ?";
        s = MySQL_connect.getConnection().prepareStatement(query);
        s.setString(1,getUsername);
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
    public void appendOnlineList(Vector list) throws SQLException {
        sampleOnlineList(list);  // - Sample Method()
    }

    /*
      ************************************  Show Online Sample  *********************************************
     */
    private void sampleOnlineList(Vector list) throws SQLException {
        textpanel_useronline.setEditable(true);
        textpanel_useronline.removeAll();
        textpanel_useronline.setText("");
        Iterator i = list.iterator();
        while (i.hasNext()) {
            Object e = i.next();
            /*  Show Online Username   */
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel.setBackground(Color.white);
//            Icon icon = new ImageIcon(this.getClass().getResource("/images/account.png"));
            JLabel label = new JLabel(getImageFile());
            System.out.println("Online list: " + e);
            label.setText(" " + e);
            panel.add(label);
            int len = textpanel_useronline.getDocument().getLength();
            textpanel_useronline.setCaretPosition(len);
            textpanel_useronline.insertComponent(panel);
            /*  Append Next Line   */
            sampleAppend();
            
        }
//        textpanel_useronline.setEditable(false);
    }

    //
    private void sampleAppend() {
        int len = textpanel_useronline.getDocument().getLength();
        textpanel_useronline.setCaretPosition(len);
        textpanel_useronline.replaceSelection("\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane chatArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton_connect;
    private javax.swing.JButton jButton_send;
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
