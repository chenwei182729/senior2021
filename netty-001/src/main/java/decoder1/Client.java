package decoder1;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

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
                    protected void initChannel(SocketChannel sc) throws Exception {
                        //
                        ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
                        sc.pipeline().addLast(new DelimiterBasedFrameDecoder(32 * 1024, buf));
                        sc.pipeline().addLast(new StringDecoder());
                        sc.pipeline().addLast(new ClientHandler());
                    }
                });

        ChannelFuture cf = bootstrap.connect("127.0.0.1", 8765).sync();

        for(int i = 1 ; i <=10 ; i ++){			// 4 + 10 + $_ = 8
            cf.channel().writeAndFlush(Unpooled.wrappedBuffer(("消息" + i + "$_").getBytes()));
        }

        //	等待客户端端口关闭
        cf.channel().closeFuture().sync();
        workGroup.shutdownGracefully();
    }
}
