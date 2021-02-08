package best.worker;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultEventExecutorGroup;

public class Server {

	
	public static void main(String[] args) throws InterruptedException {
		
		//1. 创建两个线程组: 一个用于进行网络连接接受的 另一个用于我们的实际处理（网络通信的读写）
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		
		DefaultEventExecutorGroup defaultEventExecutorGroup = new DefaultEventExecutorGroup(4,
                new ThreadFactory() {
                    private AtomicInteger threadIndex = new AtomicInteger(0);
                    @Override
                    public Thread newThread(Runnable r) {
						System.err.println("defaultEventExecutorGroup");
                        return new Thread(r, "NettyServerCodecThread_" + this.threadIndex.incrementAndGet());
                    }
                });
        
		//2 通过辅助类去构造server/client
		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup, workGroup)
		 .channel(NioServerSocketChannel.class)
		 .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
		 .option(ChannelOption.SO_BACKLOG, 1024)
		 .childOption(ChannelOption.TCP_NODELAY, true)
		 .childOption(ChannelOption.SO_RCVBUF, 1024 * 32)
		 .childOption(ChannelOption.SO_SNDBUF, 1024 * 32)
		 .childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(defaultEventExecutorGroup, new ServerHandler());	//1
			}
		});
		//服务器端绑定端口并启动服务
		ChannelFuture cf = b.bind(8765).sync();
		//使用channel级别的监听close端口 阻塞的方式
		cf.channel().closeFuture().sync();
		
		bossGroup.shutdownGracefully();
		workGroup.shutdownGracefully();
		
	}
}
