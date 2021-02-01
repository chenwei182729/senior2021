package provider.impl;

import provider.api.HelloService;

/**
 * @author chenxinwei
 * @date 2021/2/1 17:54
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String username) {
        return "Hello, " + username;
    }
}
