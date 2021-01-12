package ch6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportT6_4 {

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(() -> {
            System.out.println("child thread begin park!");
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("thread is interrupted");
                LockSupport.park();
            }
            System.out.println("child thread unpark!");
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main thread begin unpark!");

//        LockSupport.unpark(thread);
        thread.interrupt();
    }
}
