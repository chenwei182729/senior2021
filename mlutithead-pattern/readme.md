[toc]

## 1. Single Threaded Execution模式

**能通过这座桥的只有一个人**



```JAVA
package two.single;

/**
 * @author chenxinwei
 * @date 2021/2/22 15:27
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit ctrl + c to exit");
        Gate gate = new Gate();
        new UserThread(gate,"Alice","Alaska").start();
        new UserThread(gate,"Bobby","Brazil").start();
        new UserThread(gate,"Chris","Canda").start();
    }
}

```



## 2. Immutable模式

**想破坏也破坏不了** 

- ` java.lang.String`
- ` java.math.BigInteger`
- ` java.util.regex.Pattern`
- ` java.lang.Integer`
- 

```java
public class Main{
    public static void main(Stirng[] args){
        Person alice = new Person("Alice","Alaska");
        new PrintPersonThread(alice).start;
        new PrintPersonThread(alice).start;
        new PrintPersonThread(alice).start;
    }
}
```




## 3. Guarded Suspension模式

**等我准备好哦**

```java
public class Main{
    public static void main(String[] args){
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"Alice",3141592L).start();
        new ServerThread(requestQueue,"Bobby",6535897L);
    }
}
```




## 4. Balking 模式

**不需要就算了**

```java
public class Main{
    public static void main(String[] args){
        Data data = new Data("data.txt","(empty)");
        new ChangerThread("ChangeThread",data).start();
        new ServerThread("ServerThread",data).start();
    }
}
```




## 5. Producer-Consumer模式

**我来做，你来用**



```java
public class Main{
    public static void main(String[] args){
        Table table = new Table(3);
        new MakerThread("MakerThread-1",table,31415).start();
        new MakerThread("MakerThread-1",table,92653).start();
        new MakerThread("MakerThread-1",table,58979).start();
        new EaterThread("MakerThread-1",table,32384).start();
        new EaterThread("MakerThread-1",table,62643).start();
        new EaterThread("MakerThread-1",table,38327).start();
    }
}
```







## 6. Read-Write Lock 模式

**大家一起读没问题，但读的时候不要写哦** 

```java
public class Main{
    public static void main(String[] args){
        Data data = new Data(10);
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new WriteThread(data,"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        new WriteThread(data,"abcdefghijklmnopqrstuvwxyz");
    }
}
```




## 7. Thread-Per-Message模式

**这项工作就交给你了**

```java
public class Main{
    public static void main(String[] args){
        System.out.println("main BEGIN");
        Host host = new Host();
        host.request(10,'A');
        host.request(20,'B');
        host.request(30,'C');
        System.out.println("main END");
    }
}
```







## 8. Worker Thread模式

**工作没来就一直等，工作来了就干活** 

```java
public class Main{
    public static void main(String[] args){
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("Alice",channel).start();
        new ClientThread("Bobby",channel).start();
        new ClientThread("Chris",channel).start();
    }
}
```



## 9. Future模式 

**先给您提货单**



```java
public class Main{
    public static void main(String[] args){
        System.out.println("main BEGIN");
        Host host = new Host();
        Data data1 = host.request(10,'A');
        Data data2 = host.request(20,'B');
        Data data3 = host.request(30,'C');
        System.out.println("main otherJob BEGIN");
        try{
             TimeUnit.SECOND.sleep(1);
        }catch(InterruptedException e){
            
        }
        System.out.println("main otherJob END");
        
        System.out.println("data1 = "+data1.getContent());
        System.out.println("data2 = "+data2.getContent());
        System.out.println("data3 = "+data3.getContent());
       
        System.out.println("main END");
    }
}
```






## 10. Two-Phase Termination 模式

**先收拾房间再睡觉**

```java
public class Main{
    public static void main(String[] args){
        System.out.println("main: BEGIN");
        try{
            CountupThread t = new CountupThread();
            t.start();
            
            //稍微间隔一段时间
            TimeUnit.SECOND.sleep(10);
            //线程的终止请求
            System.out.println("main: shutdownRequest");
            t.shutdownRequest();
            System.out.println("main: join");
            //等待线程终止
            t.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("main: END");
    }
}
```




## 11. Thread-Specific Storage模式

一个线程一个储物柜

```java
public class Main{
    public static void main(String[] args){
        
    }
}
```







## 12. Active Object模式

接收异步消息的主动对象

```java
public class Main{
    public static void main(String[] args){
        
    }
}
```


