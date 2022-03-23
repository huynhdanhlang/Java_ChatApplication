/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server_GUI;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import Encrypt_Decrypt.EncryptDecryt_Mess;
public class OnlineListThread implements Runnable {
    final static String secretKey = "secrete";
    EncryptDecryt_Mess encrypt = new EncryptDecryt_Mess();
    ServerGUI main;

    public OnlineListThread(ServerGUI main) {
        this.main = main;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                String msg = "";
                for (int x = 0; x < main.clientList.size(); x++) {
                    msg = msg + " " + main.clientList.elementAt(x);
                }

                for (int x = 0; x < main.socketList.size(); x++) {
                    Socket tsoc = (Socket) main.socketList.elementAt(x);
                    DataOutputStream dos = new DataOutputStream(tsoc.getOutputStream());
                    /**
                     * CMD_ADD_USER_ONLINE [user1] [user2] [user3] *
                     */
                    if (msg.length() > 0) {
                        String encrypt_msg = encrypt.encrypt("CMD_ADD_USER_ONLINE" + msg, secretKey);
                        dos.writeUTF(encrypt_msg);
                    }
                }

                Thread.sleep(1900);
            }
        } catch (InterruptedException e) {
            main.appendMessage("[InterruptedException]: " + e.getMessage());
        } catch (IOException e) {
            main.appendMessage("[IOException]: " + e.getMessage());
        }
    }

}
