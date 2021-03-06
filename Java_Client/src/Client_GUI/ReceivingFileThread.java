/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_GUI;

import Encrypt_Decrypt.EncrytDecrypt_Mess;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.ProgressMonitorInputStream;

/**
 *
 * @author Hunk501
 */
public class ReceivingFileThread implements Runnable {
    final static String secretKey = "secrete";
    EncrytDecrypt_Mess encryt = new EncrytDecrypt_Mess();
    protected Socket socket;
    protected DataInputStream dis;
    protected DataOutputStream dos;
    protected ClientGUI main;
    protected StringTokenizer st;
    protected DecimalFormat df = new DecimalFormat("##,#00");
    private final int BUFFER_SIZE = 8096;

    public ReceivingFileThread(Socket soc, ClientGUI m) {
        this.socket = soc;
        this.main = m;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("[ReceivingFileThread]: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String data = dis.readUTF();
                System.out.println("This is file en_download: "+data);
                String decrypt_data = encryt.decrypt(data, secretKey);
                st = new StringTokenizer(decrypt_data);
                System.out.println("This is file de_download: "+st);
                String CMD = st.nextToken();

                switch (CMD) {

                    //   This will handle the recieving of a file in background process from other user
                    case "CMD_SEND_FILE":
                        String consignee = null;
                        try {
                            String filename = st.nextToken();
                            int filesize = Integer.parseInt(st.nextToken());
                            System.out.println("File size: "+filesize);
                            consignee = st.nextToken(); // Get the Sender Username
                            main.setMyTitle("Downloading File....");
                            System.out.println("Downloading File....");
                            System.out.println("From: " + consignee);
                            String path = main.getMyDownloadFolder() + filename;
                            /*  Create Stream   */
                            FileOutputStream fos = new FileOutputStream(path);
                            InputStream input = socket.getInputStream();
                            /*  Monitor Progress   */
                            ProgressMonitorInputStream pmis = new ProgressMonitorInputStream(main, "Downloading file please wait...", input);
                            /*  Buffer   */
                            BufferedInputStream bis = new BufferedInputStream(pmis);
                            /**
                             * Create a temporary file *
                             */
                            byte[] buffer = new byte[BUFFER_SIZE];
                            int count, percent = 0;
                            while ((count = bis.read(buffer)) != -1) {
                                percent = percent + count;
                                int p = (percent / filesize);
                                main.setMyTitle("??ang t???i file " + p + "%");
                                fos.write(buffer, 0, count);
                            }
                            fos.flush();
                            fos.close();
                            main.setMyTitle("B???n ??ang ????ng nh???p: " + main.returnusername());
                            JOptionPane.showMessageDialog(null, "T???p ???? ???????c t???i v??o \n'" + path + "'");
                            System.out.println("File ???? ???????c l??u: " + path);
                        } catch (IOException e) {
                            /*
                                Send back an error message to sender
                                Format: CMD_SEND_FILERESPONSE [username] [Message]
                             */
                            DataOutputStream eDos = new DataOutputStream(socket.getOutputStream());
                            String encryString = encryt.encrypt("CMD_SEND_FILERESPONSE " + consignee + " K???t n???i b??? m???t, vui l??ng th??? l???i sau.!", secretKey);
                            eDos.writeUTF(encryString);

                            System.out.println(e.getMessage());
                            main.setMyTitle("You are logged in as: " + main.returnusername());
                            JOptionPane.showMessageDialog(main, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
                            socket.close();
                        }
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("[ReceivingFileThread]: " + e.getMessage());
        }
    }
}
