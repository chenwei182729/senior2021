package basic;

/**
 * @author chenxinwei
 * @date 2021/1/5 15:52
 **/
public class L01_1 {
    private static long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count = count + 1;
        }
    }

    public static void main(String[] args) {
        long result = calc();
        System.out.println("result: " + result);
    }

    public static long calc() {
        final L01_1 l01_1 = new L01_1();

        Thread th1 = new Thread(() -> {
            l01_1.add10K();
        });

        Thread th2 = new Thread(() -> {
            l01_1.add10K();
        });
        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }
}
