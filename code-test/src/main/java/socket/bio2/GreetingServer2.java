package socket.bio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetingServer2 {
    public static void main(String[] args) {
        int port = 8888;
        ServerSocket serverSocket = null;
        int num = 0;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                System.out.println("waiting for client on port " + port);
                Socket server = serverSocket.accept();

                Thread serverThread = new Thread(new ServerThread(server), "serverThread" + (num++));
                serverThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ServerThread implements Runnable {
    Socket server = null;

    public ServerThread(Socket socket) {
        this.server = socket;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(Thread.currentThread().getName() + " -----------finalize------------");
    }

    @Override
    public void run() {
        try {
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connection to " + server.getLocalSocketAddress() + "\nGoodbye!,ThreadName[" + Thread.currentThread().getName() + "]");
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}