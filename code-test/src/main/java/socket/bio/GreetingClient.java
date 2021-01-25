package socket.bio;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class GreetingClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8888;
        try {
            Socket client = new Socket(host, port);
            OutputStream os = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(os);
            out.writeUTF("hello from " + client.getLocalSocketAddress());
            InputStream is = client.getInputStream();
            DataInputStream in = new DataInputStream(is);
            System.out.println("Server say " + in.readUTF());
            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
