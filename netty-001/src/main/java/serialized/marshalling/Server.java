package serialized.marshalling;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

	public static void main(String[] args) throws Exception {
		
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		
		ServerBootstrap sb = new ServerBootstrap();
		sb.group(bossGroup, workGroup)
			.channel(NioServerSocketChannel.class)
			 .option(ChannelOption.SO_BACKLOG, 1024)
			 .childOption(ChannelOption.TCP_NODELAY, true)
			 .childOption(ChannelOption.SO_RCVBUF, 1024 * 32)
			 .childOption(ChannelOption.SO_SNDBUF, 1024 * 32)
			 .childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
					ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
					ch.pipeline().addLast(new ServerHandler());
				}
			});
			//服务器端绑定端口并启动服务
			ChannelFuture cf = sb.bind(8765).sync();
			//使用channel级别的监听close端口 阻塞的方式
			cf.channel().closeFuture().sync();
			
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
			
		
	}
	
}
