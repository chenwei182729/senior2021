package net.bio;

import java.io.*;
import java.net.Socket;

/**
 * @author chenxinwei
 * @date 2021/1/21 18:47
 **/
public class Client {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 8888);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("测试客户端服务器通信\n");
        bufferedWriter.flush();

        //
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String message = bufferedReader.readLine();
        System.out.println("服务器返回：【"+message+"】");
    }
}
