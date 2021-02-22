package one.ch01;

/**
 * @author chenxinwei
 * @date 2021/1/7 14:39
 **/
public class Main1_7 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Printer("Good!"));
        Thread t2 = new Thread(new Printer("Nice!"));
        t1.start();
        t2.start();
    }
}

