package framework;

import protocol.Protocol;
import protocol.ProtocolFactory;
import register.RemoteRegister;

/**
 * @author chenxinwei
 * @date 2021/2/1 18:23
 **/
public class ProxyFactory {
    public static <T> T getProxy(Class<T> interfaceClass) {
        return (T) java.lang.reflect.Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass},
                (proxy, method, args) -> {
                    Protocol protocal = ProtocolFactory.getProtocol();
                    Invocation invocation = new Invocation(interfaceClass.getName(),
                            method.getName(),
                            method.getParameterTypes(),
                            args);
                    URL url = RemoteRegister.getRandom(interfaceClass.getName());
                    String result = protocal.send(url, invocation);
                    return result;
                });
    }
}
