package myqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyBlockQueue<E> implements MyQueue<E> {
    private List<E> container = new ArrayList<>();
    private final Object lock = new Object();

    @Override
    public E take() {
        synchronized (lock) {
            try {
                while (container.isEmpty()) {
                    System.out.println("==============wait==============");
                    lock.wait();
                }
                return container.remove(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            } finally {
                if (container.isEmpty()) {
                    lock.notifyAll();
                }
            }
        }
    }

    @Override
    public void offer(E e) {
        synchronized (lock) {
            container.add(e);
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        MyBlockQueue<Integer> myBlockQueue = new MyBlockQueue<>();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Integer take = myBlockQueue.take();
                System.out.println(take);
            }
        }, "takeThread").start();


        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myBlockQueue.offer(i);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "putThread").start();

        CountDownLatch countDownLatch = new CountDownLatch(1);


        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
