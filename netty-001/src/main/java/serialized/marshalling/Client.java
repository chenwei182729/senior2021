package serialized.marshalling;

import utils.GzipUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.File;
import java.io.FileInputStream;

public class Client {


    public static void main(String[] args) throws Exception {

        //1. 创建两个线程组: 只需要一个线程组用于我们的实际处理（网络通信的读写）
        EventLoopGroup workGroup = new NioEventLoopGroup();

        //2 通过辅助类去构造server/client
        Bootstrap b = new Bootstrap();
        b.group(workGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .option(ChannelOption.SO_RCVBUF, 1024 * 32)
                .option(ChannelOption.SO_SNDBUF, 1024 * 32)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                        ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                        ch.pipeline().addLast(new ClientHandler());
                    }
                });
        //	服务器端绑定端口并启动服务
        ChannelFuture cf = b.connect("127.0.0.1", 8765).syncUninterruptibly();
        //	写出实际的对象数据

        for (int i = 0; i < 10; i++) {
            Request req = create(i);
            cf.channel().writeAndFlush(req);
        }


        cf.channel().closeFuture().sync();
        workGroup.shutdownGracefully();

    }

    private static Request create(int seq) throws Exception {
        Request request = new Request();
        request.setId(seq + "");
        request.setName("named:" + seq);
        request.setRequestMessage("messaged:" + seq);
        String path = System.getProperty("user.dir") + File.separatorChar + "netty-data" + File.separatorChar + "sources" + File.separatorChar + "001.jpg";
        FileInputStream fis = new FileInputStream(new File(path));
        byte[] data = new byte[fis.available()];
        fis.read(data);
        fis.close();
        request.setAttachment(GzipUtils.gzip(data));
        return request;
    }


}
