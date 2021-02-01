package protocol.http;

import framework.Invocation;
import framework.URL;
import protocol.Protocol;

/**
 * @author chenxinwei
 * @date 2021/2/1 18:06
 **/
public class HttpProtocol implements Protocol {
    @Override
    public void start(URL url) {
        HttpServer server = new HttpServer();
        server.start(url.getHostname(),url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return null;
    }
}
