package ch4;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenxinwei
 * @date 2021/1/13 18:10
 **/
public class AtomicTest {
    private static AtomicLong atomicLong = new AtomicLong(0);
    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    private static Integer[] arrayTwo = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};

    public static void main(String[] args) throws Exception {
        Thread threadOne = new Thread(() -> {
            int size = arrayOne.length;
            for (int i = 0; i < size; i++) {
                if (arrayOne[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        }, "threadOne");

        Thread threadTwo = new Thread(() -> {
            int size = arrayTwo.length;
            for (int i = 0; i < size; i++) {
                if (arrayTwo[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        }, "threadTwo");
        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();
        System.out.println("count: " + atomicLong.get());
    }
}
