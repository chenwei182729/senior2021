package ch2;

import java.util.Random;

/**
 * @author chenxinwei
 * @date 2021/1/13 17:42
 **/
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
