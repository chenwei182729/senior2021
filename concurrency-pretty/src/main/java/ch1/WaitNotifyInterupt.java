package ch1;

import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/8 17:37
 **/
public class WaitNotifyInterupt {
    static Object obj = new Object();

    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(() -> {
            try {
                System.out.println("----------begin--------------------");
                synchronized (obj) {
                    obj.wait();
                }
                System.out.println("----------end--------------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ThreadA");


        threadA.start();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("--------------begin interrupt thread---------------");
        threadA.interrupt();
        System.out.println("--------------end interrupt thread---------------");
    }
}
