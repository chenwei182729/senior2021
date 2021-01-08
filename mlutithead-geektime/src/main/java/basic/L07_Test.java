package basic;

import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/6 10:01
 **/
public class L07_Test {
    private long count = 0;

    synchronized long get() {
        return count;
    }

    synchronized void set(long v) {
        count = v;
    }

    void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            set(get() + 1);
        }
    }

    public static void main(String[] args) {
        L07_Test l07_test = new L07_Test();
        l07_test.add10K();
        new Thread(() -> {
            l07_test.add10K();
            System.out.println("end1");
        }).start();

        new Thread(() -> {
            l07_test.add10K();
            System.out.println("end2");
        }).start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(l07_test.get());
    }
}
