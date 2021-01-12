package kaikeba;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenxinwei
 * @date 2021/1/12 17:51
 **/
public class ProdConsBlockQueueDemoDay02_3 {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(5));
        new Thread(() -> {
            System.out.println(String.format("%s 线程启动", Thread.currentThread().getName()));

            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod-1").start();
        new Thread(() -> {
            System.out.println(String.format("%s 线程启动", Thread.currentThread().getName()));

            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod-2").start();


        new Thread(() -> {
            System.out.println(String.format("%s 线程启动", Thread.currentThread().getName()));

            try {
                myResource.myCons();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "cons-2").start();
        
        new Thread(() -> {
            System.out.println(String.format("%s 线程启动", Thread.currentThread().getName()));

            try {
                myResource.myCons();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "cons-2").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myResource.stop();
    }
}

class MyResource {
    private volatile boolean FLAG = true;//

    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);

            if (retValue) {
                System.out.println(String.format("%s \t 插入队列 %s 成功", Thread.currentThread().getName(), retValue));
            } else {
                System.out.println(String.format("%s \t 插入队列 %s 失败", Thread.currentThread().getName(), retValue));
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(String.format("%s \t 老板叫停了，FLAG已更新为false,停止生产", Thread.currentThread().getName()));
    }


    public void myCons() throws Exception {
        String res = null;
        while (FLAG) {
            res = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (res == null || "".equals(res)) {
                System.out.println(String.format("[%s]插入队列失败", Thread.currentThread().getName()));
                return;
            }
            System.out.println(String.format("消费队[%s]列成功", Thread.currentThread().getName()));
        }
    }

    public void stop() {
        this.FLAG = false;
    }
}