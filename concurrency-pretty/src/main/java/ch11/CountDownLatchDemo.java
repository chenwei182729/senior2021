package ch11;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws Exception {
        final Thread threadOne = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("threadOne over");
        }, "threadOne");


        final Thread threadTwo = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("threadTwo over");
        }, "threadTwo");

        threadOne.start();
        threadTwo.start();
        countDownLatch.await();
    }
}
