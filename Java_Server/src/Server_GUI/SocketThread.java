/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server_GUI;

import Encrypt_Decrypt.EncryptDecryt_Mess;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class SocketThread implements Runnable {

    Socket socket;
    ServerGUI main;
    DataInputStream dis;
    StringTokenizer st;
    String client, filesharing_username;
    final static String secretKey = "secrete";
    EncryptDecryt_Mess encryptdecrypt = new EncryptDecryt_Mess();
    private final int BUFFER_SIZE = 8096;

    public SocketThread(Socket socket, ServerGUI main) {
        this.main = main;
        this.socket = socket;

        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            main.appendMessage("[SocketThreadIOException]: " + e.getMessage());
        }
    }

    /*   This method will get the client socket in client socket list then establish a connection    */
    private void createConnection(String receiver, String sender, String filename) {
        try {
            main.appendMessage("[createConnection]: creating file sharing connection.");
            Socket s = main.getClientList(receiver);
            if (s != null) { // Client exists
                main.appendMessage("[createConnection]: Socket OK");
                DataOutputStream dosS = new DataOutputStream(s.getOutputStream());
                main.appendMessage("[createConnection]: DataOutputStream OK");
                // Format:  CMD_FILE_ACEPT_REJECT [sender] [receiver] [filename]
                String format = "CMD_FILE_ACEPT_REJECT " + sender + " " + receiver + " " + filename;
                String encrypt_format  = encryptdecrypt.encrypt(format, secretKey);
                dosS.writeUTF(encrypt_format);
                main.appendMessage("[createConnection]: " + format);
            } else {// Client was not exist, send back to sender that receiver was not found.
                main.appendMessage("[createConnection]: Client was not found '" + receiver + "'");
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String format = "CMD_SEND_FILE_ERROR " + "Client '" + receiver + "' was not found in the list, make sure it is on the online list.!";
                String encrypt_format  = encryptdecrypt.encrypt(format, secretKey);
                dos.writeUTF(encrypt_format);
            }
        } catch (IOException e) {
            main.appendMessage("[createConnection]: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                /**
                 * Get Client Data *
                 */
                String data = dis.readUTF();
                System.out.println("Encrypt :" + data);
                String decrypt_clientusername = encryptdecrypt.decrypt(data, secretKey);
                System.out.println("Decrypt :" + decrypt_clientusername);
                st = new StringTokenizer(decrypt_clientusername);
                String CMD = st.nextToken();
                /**
                 * Check CMD *
                 */
                switch (CMD) {
                    case "CMD_SHOW_USER_JOIN_IN_CHAT":
                        /**
                         * CMD_SHOW_USER_JOIN_IN_CHAT [clientUsername] *
                         */
                        String clientUsername = st.nextToken();
                        client = clientUsername;
                        main.setClientList(clientUsername);
                        main.setSocketList(socket);
                        main.appendMessage("[Client]: " + clientUsername + " joins the chatroom.!");
                        break;

                    case "CMD_CHAT":
                        /**
                         * CMD_CHAT [from] [sendTo] [message] *
                         */
                        String from = st.nextToken();
                        String sendTo = st.nextToken();
                        String msg = "";
                        while (st.hasMoreTokens()) {
                            msg = msg + " " + st.nextToken();
                        }
                        Socket tsoc = main.getClientList(sendTo);
                        try {
                            DataOutputStream dos = new DataOutputStream(tsoc.getOutputStream());
                            /**
                             * CMD_MESSAGE *
                             */
                            String content = from + ": " + msg;
                            String encrypt_content = encryptdecrypt.encrypt("CMD_MESSAGE " + content, secretKey);
                            dos.writeUTF(encrypt_content);
                            main.appendMessage("[Message]: From " + from + " To " + sendTo + " : " + msg);
                        } catch (IOException e) {
                            main.appendMessage("[IOException]: Unable to send message to " + sendTo);
                        }
                        break;

                    case "CMD_SEND_CHAT_ALL_CLIENT":
                        /**
                         * CMD_SEND_CHAT_ALL_CLIENT [from] [message] *
                         */
                        String chatall_from = st.nextToken();
                        String chatall_msg = "";
                        while (st.hasMoreTokens()) {
                            chatall_msg = chatall_msg + " " + st.nextToken();
                        }
                        String chatall_content = chatall_from + " " + chatall_msg;
                        for (int x = 0; x < main.clientList.size(); x++) {
                            if (!main.clientList.elementAt(x).equals(chatall_from)) {
                                try {
                                    Socket tsoc2 = (Socket) main.socketList.elementAt(x);
                                    DataOutputStream dos2 = new DataOutputStream(tsoc2.getOutputStream());
                                    String encrypt_chatall_content = encryptdecrypt.encrypt("CMD_MESSAGE " + chatall_content, secretKey);
                                    dos2.writeUTF(encrypt_chatall_content);
                                } catch (IOException e) {
                                    main.appendMessage("[CMD_SEND_CHAT_ALL_CLIENT]: " + e.getMessage());
                                }
                            }
                        }
                        main.appendMessage("[CMD_SEND_CHAT_ALL_CLIENT]: " + chatall_content);
                        break;

                    case "CMD_HANDLE_FILE_SHARING_SOCKET":
                        main.appendMessage("CMD_HANDLE_FILE_SHARING_SOCKET : Client establish a socket connection for file sharing...");
                        String file_sharing_username = st.nextToken();
                        filesharing_username = file_sharing_username;
                        main.setClientFileSharingUsername(file_sharing_username);
                        System.out.println("filesharing_username: "+filesharing_username);
                        main.setClientFileSharingSocket(socket);
                        main.appendMessage("CMD_HANDLE_FILE_SHARING_SOCKET : Username: " + file_sharing_username);
                        main.appendMessage("CMD_HANDLE_FILE_SHARING_SOCKET : File sharing is now open");
                        break;

                    case "CMD_SEND_FILE":
                        main.appendMessage("CMD_SEND_FILE : Client sending a file...");
                        /*
                        Format: CMD_SEND_FILE [Filename] [Size] [Recipient] [Consignee]  from: Sender Format
                        Format: CMD_SEND_FILE [Filename] [Size] [Consignee] to Receiver Format
                         */
                        String file_name = st.nextToken();
                        String filesize = st.nextToken();
                        String sendto = st.nextToken();
                        String consignee = st.nextToken();
                        main.appendMessage("CMD_SEND_FILE : From: " + consignee);
                        main.appendMessage("CMD_SEND_FILE : To: " + sendto);
                        /**
                         * Get the client Socket *
                         */
                        main.appendMessage("CMD_SEND_FILE : preparing connections..");
                        Socket cSock = main.getClientFileSharingSocket(sendto);
                        /* Consignee Socket  */
 /*   Now Check if the consignee socket was exists.   */
                        if (cSock != null) {
                            /* Exists   */
                            try {
                                main.appendMessage("CMD_SEND_FILE : Connected..!");
                                /**
                                 * First Write the filename.. *
                                 */
                                main.appendMessage("CMD_SEND_FILE : Sending file to client...");
                                DataOutputStream cDos = new DataOutputStream(cSock.getOutputStream());
                                String encrypt_sendFile = encryptdecrypt.encrypt("CMD_SEND_FILE " + file_name + " " + filesize + " " + consignee, secretKey);
                                cDos.writeUTF(encrypt_sendFile);
                                /**
                                 * Second send now the file content *
                                 */
                                InputStream input = socket.getInputStream();
                                OutputStream sendFile = cSock.getOutputStream();
                                byte[] buffer = new byte[BUFFER_SIZE];
                                int cnt;
                                while ((cnt = input.read(buffer)) > 0) {
                                    sendFile.write(buffer, 0, cnt);
                                }
                                sendFile.flush();
                                sendFile.close();
                                /**
                                 * Remove client list *
                                 */
                                main.removeClientFileSharing(sendto);
                                main.removeClientFileSharing(consignee);
                                main.appendMessage("CMD_SEND_FILE : File was send to client...");
                            } catch (IOException e) {
                                main.appendMessage("[CMD_SEND_FILE]: " + e.getMessage());
                            }
                        } else {
                            /*   Not exists, return error  */
 /*   FORMAT: CMD_SEND_FILE_ERROR  */
                            main.removeClientFileSharing(consignee);
                            main.appendMessage("CMD_SEND_FILE : Client '" + sendto + "' was not found.!");
                            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                            String encrypt_errorFile = encryptdecrypt.encrypt("CMD_SEND_FILE_ERROR " + "Client '" + sendto + "' was not found, File Sharing will exit.", secretKey);
                            dos.writeUTF(encrypt_errorFile);
                        }
                            break;

                    case "CMD_SEND_FILERESPONSE":
                        /*
                        Format: CMD_SEND_FILERESPONSE [username] [Message]
                         */
                        String receiver = st.nextToken(); // get the receiver username
                        String rMsg = ""; // get the error message
                        main.appendMessage("[CMD_SEND_FILERESPONSE]: username: " + receiver);
                        while (st.hasMoreTokens()) {
                            rMsg = rMsg + " " + st.nextToken();
                        }
                        try {
                            Socket rSock = (Socket) main.getClientFileSharingSocket(receiver);
                            DataOutputStream rDos = new DataOutputStream(rSock.getOutputStream());
                            String encrypt_respone = encryptdecrypt.encrypt("CMD_SEND_FILERESPONSE" + " " + receiver + " " + rMsg, secretKey);
                            rDos.writeUTF(encrypt_respone);
                        } catch (IOException e) {
                            main.appendMessage("[CMD_SEND_FILERESPONSE]: " + e.getMessage());
                        }
                        break;

                    case "CMD_SEND_FILEXD":  // Format: CMD_SEND_FILEXD [sender] [receiver]                        
                        try {
                        String send_sender = st.nextToken();
                        String send_receiver = st.nextToken();
                        String send_filename = st.nextToken();
                        main.appendMessage("[CMD_SEND_FILEXD]: Host: " + send_sender);
                        this.createConnection(send_receiver, send_sender, send_filename);
                    } catch (Exception e) {
                        main.appendMessage("[CMD_SEND_FILEXD]: " + e.getLocalizedMessage());
                    }
                        break;

                    case "CMD_SEND_FILE_ERROR":  // Format:  CMD_SEND_FILE_ERROR [receiver] [Message]
                        String eReceiver = st.nextToken();
                        String eMsg = "";
                        while (st.hasMoreTokens()) {
                            eMsg = eMsg + " " + st.nextToken();
                        }
                        try {
                            /*  Send Error to the File Sharing host  */
                            Socket eSock = main.getClientFileSharingSocket(eReceiver); // get the file sharing host socket for connection
                            DataOutputStream eDos = new DataOutputStream(eSock.getOutputStream());
                            //  Format:  CMD_RECEIVE_FILE_ERROR [Message]
                            String encryString = encryptdecrypt.encrypt("CMD_RECEIVE_FILE_ERROR " + eMsg, secretKey);
                            eDos.writeUTF(encryString);
                        } catch (IOException e) {
                            main.appendMessage("[CMD_RECEIVE_FILE_ERROR]: " + e.getMessage());
                        }
                        break;

                    case "CMD_SEND_FILE_ACCEPT": // Format:  CMD_SEND_FILE_ACCEPT [receiver] [Message]
                        String aReceiver = st.nextToken();
                        String aMsg = "";
                        while (st.hasMoreTokens()) {
                            aMsg = aMsg + " " + st.nextToken();
                        }
                        try {
                            /*  Send Error to the File Sharing host  */
                            Socket aSock = main.getClientFileSharingSocket(aReceiver); // get the file sharing host socket for connection
                            DataOutputStream aDos = new DataOutputStream(aSock.getOutputStream());
                            //  Format:  CMD_RECEIVE_FILE_ACCEPT [Message]
                            String encript_File_accecpt = encryptdecrypt.encrypt("CMD_RECEIVE_FILE_ACCEPT " + aMsg, secretKey);
                            aDos.writeUTF(encript_File_accecpt);
                        } catch (IOException e) {
                            main.appendMessage("[CMD_RECEIVE_FILE_ERROR]: " + e.getMessage());
                        }
                        break;

                    default:
                        main.appendMessage("[CMDException]: Unknown Command " + CMD);
                        break;
                }
            }
        } catch (IOException e) {
            /*   this is for chatting client, remove if it is exists..   */
            System.out.println(client);
            System.out.println("File Sharing: " + filesharing_username);
            main.removeFromTheList(client);
            if (filesharing_username != null) {
                main.removeClientFileSharing(filesharing_username);
            }
            main.appendMessage("[SocketThread]: Client connection closed..!");
        }
    }

}
