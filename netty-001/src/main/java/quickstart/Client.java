package quickstart;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws Exception {
        //1. 创建两个线程组： 只需要一个线程组用于我们实际处理（网络通信的读写）
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        //2. 通过辅助类构造Server/Client

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .option(ChannelOption.SO_RCVBUF, 1024 * 3)
                .option(ChannelOption.SO_SNDBUF, 1024 * 3)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ClientHandler());
                    }
                });

        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8765).sync();
        channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer("hello netty!".getBytes()));
        TimeUnit.SECONDS.sleep(1);

        channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer("hello netty!".getBytes()));

        channelFuture.channel().closeFuture().sync();
        workGroup.shutdownGracefully();
    }
}
