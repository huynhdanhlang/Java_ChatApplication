package Server_GUI;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {

    ServerSocket server;
    ServerGUI main;
    boolean keepGoing = true;

    public ServerThread(String ip, int backlog, int port, ServerGUI main) {
        main.appendMessage("[Server]: Starting server in ip " + ip + " port " + port);
        try {
            this.main = main;
            server = new ServerSocket(port, backlog, InetAddress.getByName(ip));
            main.appendMessage("[Server]: Server started.!");
        } catch (IOException e) {
            main.appendMessage("[IOException]: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            while (keepGoing) {
                Socket socket = server.accept();
                main.appendMessage("[Socket]: " + socket);
                /**
                 * SOcket thread *
                 */
                new Thread(new SocketThread(socket, main)).start();
            }
        } catch (IOException e) {
            main.appendMessage("[ServerThreadIOException]: " + e.getMessage());
        }
    }
    public void stop() {
        try {
            keepGoing = false;
            server.close();
            main.appendMessage("Server is now closed..!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
