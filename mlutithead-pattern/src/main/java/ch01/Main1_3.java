package ch01;

/**
 * @author chenxinwei
 * @date 2021/1/7 14:39
 **/
public class Main1_3 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        for (int i = 0; i < 10000; i++) {
            System.out.print("Good!");
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print("Nice!");
        }
    }
}
