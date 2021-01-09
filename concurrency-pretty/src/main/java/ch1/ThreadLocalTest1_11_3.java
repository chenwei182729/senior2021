package ch1;

public class ThreadLocalTest1_11_3 {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello world");

        new Thread(() ->
                System.out.println(String.format("thread : %s", threadLocal.get()))
        ).start();

        System.out.println(String.format("main : %s", threadLocal.get()));
    }
}
