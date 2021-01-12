package cas;

import java.util.concurrent.TimeUnit;

public class VolatitleDemo01 {
    public static void main(String[] args) {
//        volatitleVisibilityDemo();
        atomicDemo();
    }

    private static void atomicDemo() {
        final MyData myData = new MyData();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                myData.number += 10;
            }, "thread(" + i + ")").start();
        }
        System.out.println(Thread.currentThread().getName() + "\t最终number的值：" + myData.number);

    }

    public static void volatitleVisibilityDemo() {
        System.out.println("可见性测试");
        final MyData myData = new MyData();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.setNumber(60);
                System.out.println(String.format("%s线程中number的值：%d", Thread.currentThread().getName(), myData.number));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "threadA").start();


        while (myData.number == 0) {

        }
        System.out.println("主线程number的值：" + myData.number);
    }
}

class MyData {
    //    int number = 0;
    volatile int number = 0;

    public void setNumber(int number) {
        this.number = number;
    }
}
