package consumer;

import framework.ProxyFactory;
import provider.api.HelloService;

/**
 * @author chenxinwei
 * @date 2021/2/1 18:21
 **/
public class Consumer {
    public static void main(String[] args) {
        HelloService proxy = ProxyFactory.getProxy(HelloService.class);
        String result = proxy.sayHello("zzz");
        System.out.println(result);
    }
}
