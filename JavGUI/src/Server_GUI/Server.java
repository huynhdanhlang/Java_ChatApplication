/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server_GUI;
import Server_GUI.ServerGUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class Server extends Thread{
  public static ArrayList<BufferedWriter> clients;           
  public static ServerSocket server; 
  public static String clientname;
  private Socket con;
  private InputStream in;  
  private InputStreamReader inr;  
  private BufferedReader bfr;
  
  public Server(){
      
  }
  
//  public ServerSocket getServerSocket(){
//   return server;
//  }
  
  public Server(Socket con){
   this.con = con;
   try {
         in  = con.getInputStream();
         inr = new InputStreamReader(in);
          bfr = new BufferedReader(inr);
   } catch (IOException e) {
          e.printStackTrace();
   }                          
   }   
  
  /**
  * Method run
  * Tạo luồng mới khi có kết nối và kiểm tra tin nhắn mới
  */
public void run(){
                      
  try{                  
    String msg;
    OutputStream ou =  this.con.getOutputStream();
    Writer ouw = new OutputStreamWriter(ou);
    BufferedWriter bfw = new BufferedWriter(ouw); 
    clients.add(bfw);
    clientname=msg = bfr.readLine();
    while(!"Logout".equalsIgnoreCase(msg) && msg != null)
      {           
       clientname=msg = bfr.readLine();
       sendToAll(bfw, msg);
       System.out.println(clientname);                                              
       }
                                     
   }catch (Exception e) {
     e.printStackTrace();
   
   }                       
    }

//Duyệt qua các clients vaf gửi tin nhắn mới tới chúng.
public void sendToAll(BufferedWriter bwOutput, String msg) throws  IOException 
{
  BufferedWriter bwS;
   
  for(BufferedWriter bw :  clients){
   bwS = (BufferedWriter)bw;
   if(!(bwOutput == bwS)){
        bw.write(msg+"\n");

//    bw.write(nome + " -> " + msg+"\r\n");
//       System.out.println("Day la nome"+nome);
     bw.flush(); 
   }
  }          
}                    
}

