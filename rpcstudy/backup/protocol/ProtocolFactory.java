package protocol;

import protocol.dubbo.DubboProtocol;
import protocol.http.HttpProtocol;

/**
 * @author chenxinwei
 * @date 2021/2/1 18:03
 **/
public class ProtocolFactory {


    public static Protocol getProtocol() {
        String name = System.getProperty("protocolName");

        if (name == null || name.equals("")) {
            name = "http";
        }

        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }
        return new HttpProtocol();
    }
}
