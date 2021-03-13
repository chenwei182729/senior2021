package myqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockQueue2<E> implements MyQueue<E> {
    private List<E> container = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @Override
    public E take() {
        try {
            lock.lock();
            try {
                while (container.isEmpty()) {
                    System.out.println("==============await==============");
                    condition.await();
                }
                return container.remove(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        } finally {
            if (container.isEmpty()) {
                condition.signalAll();
            }
            lock.unlock();
        }
    }

    @Override
    public void offer(E e) {
        try {
            lock.lock();
            container.add(e);

            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyBlockQueue2<Integer> myBlockQueue = new MyBlockQueue2<>();

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
