package Client_GUI;

import Encrypt_Decrypt.EncryDecry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ClientGUI extends javax.swing.JFrame {

    final static String secretKey = "secrete";
    EncryDecry encrypt = new EncryDecry();

    public ClientGUI() {
        initComponents();
        this.setLocationRelativeTo(null);

        jTextField_nameclient.setText("Lang");
        jTextField_ip.setText("127.0.0.1");
        jTextField_port.setText("7880");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField_messagecontent = new javax.swing.JTextField();
        jButton_send = new javax.swing.JButton();
        jTextField_port = new javax.swing.JTextField();
        jTextField_ip = new javax.swing.JTextField();
        jTextField_nameclient = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_connect = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jTextField_messagecontent.setToolTipText("text\tType your message here...");
        jPanel1.add(jTextField_messagecontent);
        jTextField_messagecontent.setBounds(30, 340, 370, 30);

        jButton_send.setBackground(new java.awt.Color(204, 204, 255));
        jButton_send.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_send.setText("Gửi");
        jButton_send.setPreferredSize(new java.awt.Dimension(37, 22));
        jButton_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sendActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_send);
        jButton_send.setBounds(410, 340, 60, 30);
        jPanel1.add(jTextField_port);
        jTextField_port.setBounds(310, 80, 64, 30);
        jPanel1.add(jTextField_ip);
        jTextField_ip.setBounds(150, 80, 150, 30);
        jPanel1.add(jTextField_nameclient);
        jTextField_nameclient.setBounds(51, 80, 90, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 51));
        jLabel5.setText("Your name:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 60, 60, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("port:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(330, 60, 30, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("Server address:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 60, 80, 16);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 400);

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
        jButton_connect.setBounds(390, 80, 73, 30);

        jButton1.setText("Leave chat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(399, 10, 86, 22);

        jScrollPane2.setViewportView(chatArea);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(50, 122, 400, 150);

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
    private Socket socket;
    private OutputStream ou;
    private Writer ouw;
    private BufferedWriter bfw;

    //Insert messsge into jTextPanel
    public void textPanel_append(String str) throws BadLocationException {
        StyledDocument document = (StyledDocument) chatArea.getDocument();
        document.insertString(document.getLength(), str, null);
    }

    private void jButton_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_connectActionPerformed
        String host = jTextField_ip.getText();
        String port = jTextField_port.getText();
        jTextField_nameclient.setEnabled(false);
        try {
            //Connect to server
            socket = new Socket(host, Integer.valueOf(port));
            System.out.println(socket);
            ou = socket.getOutputStream();
            ouw = new OutputStreamWriter(ou);
            bfw = new BufferedWriter(ouw);
            //Show on Client that Client is connected
            String str = jTextField_nameclient.getText()+" "+"connected successfully";
            bfw.write("\n"+encrypt.encrypt(str, secretKey)+"\n");
            bfw.flush();
            listenMessage();
        } catch (IOException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton_connectActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            senMessage("Logout");
            bfw.close();
            ouw.close();
            ou.close();
            socket.close();
            jTextField_nameclient.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sendActionPerformed

        try {
            senMessage(jTextField_nameclient.getText() + ":" + jTextField_messagecontent.getText());
        } catch (IOException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton_sendActionPerformed
    //Request to server
    public void senMessage(String msg) throws IOException, BadLocationException {

        if (msg.equals("Logout")) {
            textPanel_append("Disconnected\n");
        } else {
            String encrypt = this.encrypt.encrypt(msg, secretKey);
            bfw.write(encrypt + "\n");
        }
        textPanel_append(msg + "\n");

        bfw.flush();
        jTextField_messagecontent.setText("");
    }

    //Client listen changes messge
    public void listenMessage() throws IOException {
        Thread t = new Thread(new Runnable() {
            InputStream in = socket.getInputStream();
            InputStreamReader read_in = new InputStreamReader(in);
            BufferedReader bfr = new BufferedReader(read_in);
            SimpleAttributeSet attr = new SimpleAttributeSet();

            String msg = "";

            @Override
            public void run() {
                StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
                chatArea.setParagraphAttributes(attr, true);
                while (!"Logout".equalsIgnoreCase(msg)) {
                    try {
                        if (bfr.ready()) {
                            msg = bfr.readLine();
                            if (msg.equals("Logout")) {

                                textPanel_append("Logout \n");
                            } else {
                                textPanel_append(msg + "\n");
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
        t.setDaemon(true);
        t.start();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane chatArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_connect;
    private javax.swing.JButton jButton_send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_ip;
    private javax.swing.JTextField jTextField_messagecontent;
    private javax.swing.JTextField jTextField_nameclient;
    private javax.swing.JTextField jTextField_port;
    // End of variables declaration//GEN-END:variables
}
