package ch1;

import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/8 17:42
 **/
public class NotifyAllTest {
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("ThreadA get resourceA lock");
                try {
                    System.out.println("ThreadA begin wait");
                    resourceA.wait();
                    System.out.println("ThreadA end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadA");

        Thread threadB = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("ThreadB get resourceA lock");
                try {
                    System.out.println("ThreadB begin wait");
                    resourceA.wait();
                    System.out.println("ThreadB end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadB");
        Thread threadC = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("ThreadC begin notify get resourceA lock");
                resourceA.notify();
//                resourceA.notifyAll();
            }
        }, "threadC");

        threadA.start();
        threadB.start();
        TimeUnit.SECONDS.sleep(1);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("Main over");
    }
}
