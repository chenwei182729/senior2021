# senior2021

java高级

## 手写dubbo

1. RemoteRegister 类似于远程注册中心
2. Invocation包装信息类，存储接口的信息，如接口名，方法参数，方法名
3. ProxyFactory 生成代理类 
**主要核心在ProxyFactory生成代理类这块**.
主要是使用Invocation包装接口，生成一个代理类
- Invocation虽然只是接口，但足够拿到方法的名字和方法的参数
- 接口做为信息传递的载体
- 通过网络传输将接口名，方法名和方法参数传递到服务器，并执行其方法，将结果通过网络协议传送至客户端


