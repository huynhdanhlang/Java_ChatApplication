package Client_GUI;

import Encrypt_Decrypt.EncrytDecrypt_Mess;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

public class ClientThread implements Runnable {
    final static String secretKey = "secrete";
    EncrytDecrypt_Mess encryptdecrypt = new EncrytDecrypt_Mess();
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    ClientGUI main;
    StringTokenizer st;
    protected DecimalFormat df = new DecimalFormat("##,#00");

    public ClientThread(Socket socket, ClientGUI main) throws BadLocationException {
        this.main = main;
        this.socket = socket;
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            main.textPanel_append("[IOException]: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String data = dis.readUTF();
                System.out.println("This is dataclient: " + data);

                String decrypt_data=  encryptdecrypt.decrypt(data, secretKey);
                System.out.println("This is readUTF: " + decrypt_data);
                st = new StringTokenizer(decrypt_data);
                System.out.println("This is StringTokenizer: " + st);
                /**
                 * Get Message CMD *
                 */
                // format: [Token] [username] [message content]
                String CMD = st.nextToken();
                switch (CMD) {
                    case "CMD_MESSAGE":
                        String msg = "";
                        String frm = st.nextToken();
                        while (st.hasMoreTokens()) {
                            msg = msg + " " + st.nextToken();
                        }
                        main.textPanel_append(" " + frm + ": " + msg + "\n");
                        break;

                    case "CMD_ADD_USER_ONLINE":
                        Vector online = new Vector();
                        String[] user = null;
                        user = decrypt_data.split(" ");
                        user = Arrays.copyOfRange(user, 1, user.length);
                        ImageIcon[] icon= new ImageIcon[user.length];
                        
//                        while (st.hasMoreTokens()) {
//                            
//                            String list = st.nextToken();
//                            if (!list.equalsIgnoreCase(main.returnusername())) {
//                                online.add(list);
//                            }
//                        }
                        synchronized(this){
                            for (int i = 0; i< user.length; i++){  
                        icon[i] = main.getImageFile(user[i]);

                        }
                            this.notify();
                        }
                        main.appendOnlineList(user,icon);
                        break;

                    //  This will inform the client that there's a file receive, Accept or Reject the file  
                    case "CMD_FILE_ACEPT_REJECT":  // Format:  CMD_FILE_ACEPT_REJECT [sender] [receiver] [filename]
                        String sender = st.nextToken();
                        String receiver = st.nextToken();
                        String fname = st.nextToken();
                        int confirm = JOptionPane.showConfirmDialog(main, "From: " + sender + "\nFilename: " + fname + "\nWould you like to Accept?");
//                        main.textPanel_append("This is confirm: "+confirm);
                        if (confirm == 0) { // client accepted the request, then inform the sender to send the file now
                            /* Select where to save this file   */
                            main.openFolder();
                            try {
                                dos = new DataOutputStream(socket.getOutputStream());
                                // Format:  CMD_SEND_FILE_ACCEPT [ToSender] [Message]
                                String format = "CMD_SEND_FILE_ACCEPT " + sender + " accepted";
                                String encrypt_format = encryptdecrypt.encrypt(format, secretKey);
                                dos.writeUTF(encrypt_format);

                                /*  this will create a filesharing socket to handle incoming file and this socket will automatically closed when it's done.  */
                                Socket fSoc = new Socket(main.getMyHost(), main.getMyPort());
                                DataOutputStream fdos = new DataOutputStream(fSoc.getOutputStream());
                                String filesharing ="CMD_HANDLE_FILE_SHARING_SOCKET " + main.returnusername();
                                String encrypt_filesharing =encryptdecrypt.encrypt(filesharing, secretKey);
                                fdos.writeUTF(encrypt_filesharing);
                                /*  Run Thread for this   */
                                new Thread(new ReceivingFileThread(fSoc, main)).start();
                            } catch (IOException e) {
                                System.out.println("[CMD_FILE_ACEPT_REJECT]: " + e.getMessage());
                            }
                        } else { // client rejected the request, then send back result to sender
                            try {
                                dos = new DataOutputStream(socket.getOutputStream());
                                // Format:  CMD_SEND_FILE_ERROR [ToSender] [Message]
                                String format = "CMD_SEND_FILE_ERROR " + sender + " Client rejected your request or connection was lost.!";
                                String encrypt_format = encryptdecrypt.encrypt(format, secretKey);
                                dos.writeUTF(encrypt_format);
                            } catch (IOException e) {
                                System.out.println("[CMD_FILE_ACEPT_REJECT]: " + e.getMessage());
                            }
                        }
                            break;

                    default:
                        main.textPanel_append("[CMDException]: Unknown Command " + CMD);
                        break;
                }
            }
        } catch (IOException e) {
            try {
                main.textPanel_append(" Server Connection was lost, please try again later.!");
            } catch (BadLocationException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
