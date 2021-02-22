package one.ch01;

/**
 * @author chenxinwei
 * @date 2021/1/7 14:39
 **/
public class Main1_5 {
    public static void main(String[] args) {
        PrintThread t1 = new PrintThread("Good!");
        PrintThread t2 = new PrintThread("Nice!");
        t1.start();
        t2.start();
    }
}

class PrintThread extends Thread {
    final String message;

    public PrintThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print(message);
        }
    }
}
