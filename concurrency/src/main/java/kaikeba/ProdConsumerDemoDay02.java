package kaikeba;

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
public class ProdConsumerDemoDay02 {
    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();
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

class Aircondition {
    private int number = 0;

    public synchronized void increment() throws Exception {
        while (number != 0) {
            this.wait();
        }

        number++;
        //干活

        System.out.println(String.format("%s \t %d", Thread.currentThread().getName(), number));
        notifyAll();
    }

    public synchronized void decrement() throws Exception {
        while (number == 0) {
            this.wait();
        }

        number--;
        //干活

        System.out.println(String.format("%s \t %d", Thread.currentThread().getName(), number));
        notifyAll();
    }

}