package protocol.dubbo;

import framework.Invocation;
import framework.URL;
import protocol.Protocol;

/**
 * @Author: wanghz
 * @Date: 2020/5/1 6:19 PM
 */
public class DubboProtocol implements Protocol {

    @Override
    public void start(URL url) {
        NettyServer server = new NettyServer();
        server.start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        NettyClient client = new NettyClient();
        return client.send(url.getHostname(), url.getPort(), invocation);
    }
}
