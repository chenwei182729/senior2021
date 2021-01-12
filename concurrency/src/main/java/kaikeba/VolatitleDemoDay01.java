package kaikeba;

import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/11 17:56
 **/
public class VolatitleDemoDay01 {
    public static void main(String[] args) {
//        volatitleVisibilityDemo();
        atomicDemo();
    }

    public static void volatitleVisibilityDemo() {
        System.out.println("可见性测试");
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread());

            try {
                TimeUnit.SECONDS.sleep(3);
                myData.setTo60();
                System.out.println(Thread.currentThread().getName() + "\t number的值：" + myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "threadA").start();

        while (myData.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "\t main获取 number的值：" + myData.number);
    }

    public static void atomicDemo() {
        System.out.println("原子性测试");
        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }
        System.out.println(Thread.currentThread().getName() + "\t最终number的值：" + myData.number);
    }
}

class MyData {
    volatile int number = 0;
//    int number = 0;

    public void setTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number++;
    }
}