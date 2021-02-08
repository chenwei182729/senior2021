package serialized.marshalling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	System.err.println("client channel active..");
    }
    
    /**
     * 真正的数据最终会走到这个方法进行处理
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    	try {
        	ByteBuf buf = (ByteBuf) msg;
            byte[] request = new byte[buf.readableBytes()];
            buf.readBytes(request);
            String requestBody = new String(request, "utf-8");
            System.err.println("Client: " + requestBody);			
		} finally {
			ReferenceCountUtil.release(msg);
		}
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
    }
}
