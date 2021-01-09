package ch1;

public class ThreadLocalTest1_11 {
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static void print(String str) {
        System.out.println(String.join(" : ", str, localVariable.get()));
        //1.2清除当前线程本地内存中的localVariable变量
                localVariable.remove();
    }

    public static void main(String[] args) {
        final Thread threadOne = new Thread(() -> {
            localVariable.set("threadOne local variable");
            print("threadOne");
            System.out.println(String.join(" : ", "threadOne remove after", localVariable.get()));
        });

        final Thread threadTwo = new Thread(() -> {
            localVariable.set("threadTwo local variable");
            print("threadTwo");
            System.out.println(String.join(" : ", "threadTwo remove after", localVariable.get()));
        });

        threadOne.start();
        threadTwo.start();
    }
}
