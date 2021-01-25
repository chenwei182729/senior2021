package socket.bio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetingServer {
    public static void main(String[] args) {
        int port = 8888;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                System.out.println("waiting for client on port " + port);
                Socket server = serverSocket.accept();

                System.out.println("Just connected to " + server.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connection to " + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
