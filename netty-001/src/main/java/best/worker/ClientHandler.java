package best.worker;

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
    		ByteBuf resp = (ByteBuf)msg;
    		byte[] responsebody = new byte[resp.readableBytes()];
    		resp.readBytes(responsebody);
    		String str = new String(responsebody, "utf-8");
    		System.err.println("Client: " + str);
		} finally {
			ReferenceCountUtil.release(msg);
		}
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
    }
}
