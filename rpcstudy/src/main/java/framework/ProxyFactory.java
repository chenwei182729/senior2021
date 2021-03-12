package framework;

import protocol.Protocol;
import protocol.ProtocolFactory;
import protocol.http.HttpClient;
import register.RemoteRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author tanghf
 * @className framework.Proxy.java
 * @createTime 2019/8/22 15:28
 */
public class ProxyFactory {

    public static <T> T getProxy(Class<T> interfaceClass) {
        return (T) java.lang.reflect.Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Protocol protocol = ProtocolFactory.getProtocol();
                        Invocation invocation = new Invocation(interfaceClass.getName(),
                                method.getName(),
                                method.getParameterTypes(),
                                args);
                        URL url = RemoteRegister.getRandom(interfaceClass.getName());
                        String result = protocol.send(url, invocation);
                        return result;
                    }
                });
    }
}
