# senior2021

java高级

## 手写dubbo

1. RemoteRegister 类似于远程注册中心
2. Invocation包装信息类，存储接口的信息，如接口名，方法参数，方法名
3. ProxyFactory 生成代理类 主要是将Invocation包装的接口，生成一个代理类，代理类的逻辑是找到注册中心中接口的实现类 
   
**主要核心在ProxyFactory生成代理类这块**