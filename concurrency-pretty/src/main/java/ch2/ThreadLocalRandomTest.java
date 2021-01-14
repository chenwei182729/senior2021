package ch2;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chenxinwei
 * @date 2021/1/13 17:48
 **/
public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < 5; i++) {
            System.out.println(threadLocalRandom.nextInt(5));
        }
    }
}
