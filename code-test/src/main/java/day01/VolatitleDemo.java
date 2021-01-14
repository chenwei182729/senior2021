package day01;

import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/13 11:18
 **/
public class VolatitleDemo {
    public static void main(String[] args) {
        volatitlePlus();
//        volatitleDemo();
    }

    public static void volatitlePlus() {
        MyData demo = new MyData();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                demo.add10();
            }, "threadA").start();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("主线程number的值：" + demo.number);
    }

    public static void volatitleDemo() {
        MyData demo = new MyData();
        new Thread(() -> {
            System.out.println("修改number的值为: 60");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.add60();
        }, "threadA").start();

        while (demo.number == 0) {

        }
        System.out.println("主线程number的值：" + demo.number);
    }
}

class MyData {
    volatile int number;

    public void add10() {
        number += 60;
    }    public void add60() {
        number += 60;
    }
}