package provider;

import framework.URL;
import protocol.Protocol;
import protocol.ProtocolFactory;
import provider.api.HelloService;
import provider.impl.HelloServiceImpl;
import register.RemoteRegister;


/**
 * @author chenxinwei
 * @date 2021/2/1 17:58
 **/
public class Provider {
    public static void main(String[] args) throws Exception {
        System.out.println(HelloService.class.getName() + "========" + HelloServiceImpl.class);

        URL url = new URL("localhost", 8080);
        RemoteRegister.register(HelloService.class.getName(), url);

        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);
    }
}
