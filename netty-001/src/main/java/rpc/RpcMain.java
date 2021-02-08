package rpc;

import java.net.InetSocketAddress;

public class RpcMain {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                RpcExporter.exporter("localhost", 8087);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();


        RpcImporter<EchoServer> importer = new RpcImporter<>();

        EchoServer echo = importer.importer(EchoServerImpl.class, new InetSocketAddress("localhost", 8087));

        System.err.println(echo.echo("Are you ok?"));
    }
}
