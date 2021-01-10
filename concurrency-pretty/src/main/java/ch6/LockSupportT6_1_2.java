package ch6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportT6_1_2 {

    public static void main(String[] args) {
        final Thread threadA = new Thread(() -> {
            System.out.println("threadA begin park!");
            LockSupport.park();
            System.out.println("threadA end park!");
        });

        final Thread threadB = new Thread(() -> {
//            System.out.println("threadB begin unpark threadA!");
//            LockSupport.unpark(threadA);
//            System.out.println("threadB end unpark threadA!");
            System.out.println("threadB begin interrupt threadA!");
            threadA.interrupt();
            System.out.println("threadB end interrupt threadA!");
        });

        threadA.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }
}
