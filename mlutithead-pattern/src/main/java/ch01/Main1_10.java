package ch01;

import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/7 15:08
 **/
public class Main1_10 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Good!");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
