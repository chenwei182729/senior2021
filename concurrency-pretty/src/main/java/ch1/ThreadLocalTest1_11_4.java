package ch1;

/**
 * InheritableThreadLocal 让了线程可以访问父线程的变量
 */
public class ThreadLocalTest1_11_4 {
    static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello world");

        new Thread(() ->
                System.out.println(String.format("thread : %s", threadLocal.get()))
        ).start();

        System.out.println(String.format("main : %s", threadLocal.get()));
    }
}
