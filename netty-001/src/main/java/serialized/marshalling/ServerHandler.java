package serialized.marshalling;

import java.io.File;
import java.io.FileOutputStream;

import utils.GzipUtils;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("server channel active..");
    }

    /**
     * 真正的数据最终会走到这个方法进行处理
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //	读取客户端的数据
        Request req = (Request) msg;
        System.err.println("Server: " + req.getId() + ", " + req.getName() + ", " + req.getRequestMessage());
        byte[] attachment = GzipUtils.ungzip(req.getAttachment());
        String path = System.getProperty("user.dir") + File.separatorChar + "netty-data" + File.separatorChar + "receive" + File.separatorChar + "001.jpg";
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(attachment);
        fos.close();

        Response resp = new Response();
        resp.setId(req.getId());
        resp.setName("resp" + req.getName());
        resp.setResponseMessage("响应内容: " + req.getRequestMessage());
        ctx.writeAndFlush(resp);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
    }


}
