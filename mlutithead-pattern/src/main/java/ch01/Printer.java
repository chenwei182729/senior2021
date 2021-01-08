package ch01;

/**
 * @author chenxinwei
 * @date 2021/1/7 14:56
 **/
public class Printer implements Runnable {
    final String message;

    public Printer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print(message);
        }
    }
}
