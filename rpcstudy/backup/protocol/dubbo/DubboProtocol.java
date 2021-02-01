package protocol.dubbo;

import framework.Invocation;
import framework.URL;
import protocol.Protocol;

/**
 * @author chenxinwei
 * @date 2021/2/1 18:06
 **/
public class DubboProtocol implements Protocol {

    @Override
    public void start(URL url) {

    }

    @Override
    public String send(URL url, Invocation invocation) {
        return null;
    }
}
