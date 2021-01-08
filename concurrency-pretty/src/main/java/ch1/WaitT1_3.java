package ch1;

import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/8 17:25
 **/
public class WaitT1_3 {
    private static volatile Object reourceA = new Object();
    private static volatile Object reourceB = new Object();

    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(() -> {
            try {
                synchronized (reourceA) {
                    System.out.println("ThreadA get resourceA lock");
                    synchronized (reourceB) {
                        System.out.println("ThreadA get reourceB lock");
                        System.out.println("ThreadA release resourceA lock");
                        reourceA.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ThreadA");

        Thread threadB = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                synchronized (reourceA) {
                    System.out.println("ThreadB get resourceA lock");
                    System.out.println("threadB try resourceB lock. . .");
                    synchronized (reourceB) {
                        System.out.println("ThreadB get reourceA lock");
                        System.out.println("ThreadB release resourceA lock");
                        reourceA.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ThreadA");

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("Main Over");
    }
}
