package kaikeba;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * /**
 * 备注：多线程之间按顺序调⽤，实现A->B->C
 * 三个线程启动，要求如下：
 * A打印5次，B打印10次，C打印15次
 * 接着
 * A打印5次，B打印10次，C打印15次
 * 来10轮
 * 1.⾼内聚低耦合前提下，线程操作资源类
 * 2.判断/⼲活/通知
 * 3.多线程交互中，防⽌虚假唤醒(判断只能⽤while，不能⽤if)
 * 4.标志位
 *
 * @author chenxinwei
 * @date 2021/1/12 17:42
 **/
public class ShareDataDay02 {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareData.printc1();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareData.printc2();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareData.printc3();
            }
        }, "C").start();

    }
}

class ShareData {
    private int num = 1; //A: 1 ,B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void printc1() {
        lock.lock();
        try {
            while (num != 1) {
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(String.format("%s \t %d", Thread.currentThread().getName(), i));
            }
            num = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printc2() {
        lock.lock();
        try {
            while (num != 2) {
                c1.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(String.format("%s \t %d", Thread.currentThread().getName(), i));
            }
            num = 3;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printc3() {
        lock.lock();
        try {
            while (num != 3) {
                c1.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(String.format("%s \t %d", Thread.currentThread().getName(), i));
            }
            num = 1;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
