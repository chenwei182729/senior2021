package protocol.http;

import framework.Invocation;
import framework.URL;
import protocol.Protocol;

/**
 * @Author: wanghz
 * @Date: 2020/5/1 6:17 PM
 */
public class HttpProtocol implements Protocol {

    @Override
    public void start(URL url) {
        HttpServer server = new HttpServer();
        server.start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient client = new HttpClient();
        return client.send(url.getHostname(), url.getPort(), invocation);
    }

}
