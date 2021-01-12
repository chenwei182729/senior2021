package kaikeba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chenxinwei
 * @date 2021/1/12 8:29
 **/
public class SpinLockDemoDay02 {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t come in");
        while (!atomicReference.compareAndSet(null, thread)) {
            System.out.println(thread.getName() + "\t compareAndSet");
        }
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + "\t unlock");
    }

    public static void main(String[] args) {
        SpinLockDemoDay02 spinLockDemo = new SpinLockDemoDay02();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                spinLockDemo.myLock();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spinLockDemo.unLock();
            }, "thread(" + i + ")").start();
        }
    }
}