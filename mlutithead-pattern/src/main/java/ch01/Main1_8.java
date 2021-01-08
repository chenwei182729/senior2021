package ch01;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author chenxinwei
 * @date 2021/1/7 14:39
 **/
public class Main1_8 {
    public static void main(String[] args) {
        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new Printer("Good!")).start();
        factory.newThread(new Printer("Nice!")).start();
    }
}

