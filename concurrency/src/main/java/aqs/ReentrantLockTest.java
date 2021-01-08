package aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenxinwei
 * @date 2020/12/30 11:37
 **/
public class ReentrantLockTest {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CountDownLatch count = new CountDownLatch(2);
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.add(10);
                System.out.println("t1: " + counter.getCount());
            }
            count.countDown();
        }, "t1").start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.add(10);
//                System.out.println("t2: " + counter.getCount());
            }
            count.countDown();
        }, "t2").start();

        System.out.println(counter.getCount());
    }
}

class Counter {
    private final Lock lock = new ReentrantLock();
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void add(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }
}