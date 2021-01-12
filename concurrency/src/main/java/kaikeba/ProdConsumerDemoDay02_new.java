package kaikeba;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenxinwei
 * @date 2021/1/12 17:21
 * 题⽬：现在两个线程，可以操作初始值为零的⼀个变量，
 * 实现⼀个线程对该变量加1，⼀个线程对该变量-1，
 * 实现交替，来10轮，变量初始值为0.
 * 1.⾼内聚低耦合前提下，线程操作资源类
 * 2.判断/⼲活/通知
 * 3.防⽌虚假唤醒(判断只能⽤while，不能⽤if)
 * 知识⼩总结：多线程编程套路+while判断+新版写法
 */
public class ProdConsumerDemoDay02_new {
    public static void main(String[] args) {
        AirconditionNew aircondition = new AirconditionNew();
        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "threadA").start();
        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "threadB").start();
        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "threadC").start();
        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "threadD").start();

    }
}

class AirconditionNew {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void increment() throws Exception {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }

            number++;
            //干活

            System.out.println(String.format("%s \t %d", Thread.currentThread().getName(), number));
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            //干活

            System.out.println(String.format("%s \t %d", Thread.currentThread().getName(), number));
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}