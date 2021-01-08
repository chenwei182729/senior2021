package basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenxinwei
 * @date 2021/1/6 10:01
 **/
public class L21_Test {
    private AtomicLong count = new AtomicLong(0);

    public long get(){
        return count.get();
    }
    void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        L21_Test test = new L21_Test();
        new Thread(() -> {
            test.add10K();
            System.out.println("end1");
        }).start();

        new Thread(() -> {
            test.add10K();
            System.out.println("end2");
        }).start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(test.get());
    }
}
