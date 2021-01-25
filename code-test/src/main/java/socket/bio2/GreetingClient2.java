package socket.bio2;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class GreetingClient2 {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            new Client().connext();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            new Client().connext();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(() -> {
            new Client().connext();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();

    }
}

class Client {
    private static String host = "127.0.0.1";
    private static int port = 8888;
    private Socket client = null;

    public void connext() {
        try {
            if (client == null) {
                client = new Socket(host, port);
            }
            new Thread(() -> {
                try {
                    OutputStream os = client.getOutputStream();
                    DataOutputStream out = new DataOutputStream(os);
                    out.writeUTF("hello from " + client.getLocalSocketAddress() + "threadName[" + Thread.currentThread().getName() + "]");

                    InputStream is = client.getInputStream();
                    DataInputStream in = new DataInputStream(is);
                    System.out.println("Server say " + in.readUTF());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}