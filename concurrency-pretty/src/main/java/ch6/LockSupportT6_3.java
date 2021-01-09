package ch6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportT6_3 {

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(() -> {
            System.out.println("child thread begin park!");
            LockSupport.park();
            System.out.println("child thread unpark!");
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main thread begin unpark!");

        LockSupport.unpark(thread);
    }
}
