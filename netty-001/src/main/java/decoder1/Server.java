package decoder1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 多reactor多worker模式
 */
public class Server {

    public static void main(String[] args) throws Exception {
        //1. 创建两个线程组： 一个用于网络连接接收，另一个用于实际处理（网络通信的读写）
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        //2. 通过辅助类构造Server/Client
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .option(ChannelOption.SO_KEEPALIVE, false)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_RCVBUF, 1024 * 32)
                .childOption(ChannelOption.SO_SNDBUF, 1024 * 32)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        //	设置特殊分隔符
                        ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
                        sc.pipeline().addLast(new DelimiterBasedFrameDecoder(32 * 1024, buf));
                        //	设置字符串形式的解码
                        sc.pipeline().addLast(new StringDecoder());
                        sc.pipeline().addLast(new ServerHandler());
                    }
                });
        //4 绑定连接
        ChannelFuture channelFuture = serverBootstrap.bind(8765).sync();
        channelFuture.channel().closeFuture().sync();

        // 等待服务器监听商品关闭
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }
}
