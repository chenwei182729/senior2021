package ch5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chenxinwei
 * @date 2021/1/13 18:44
 **/
public class CopyListDemo {
    private static volatile List<String> list = new CopyOnWriteArrayList<>(Arrays.asList("hello", "alibaba", "welcome", "to", "hangzhou"));

    public static void main(String[] args) throws Exception {
        Thread threadOne = new Thread(() -> {
            list.set(1, "baba");
            list.remove(2);
            list.remove(3);
        }, "threadOne");

        Iterator<String> iterator = list.iterator();
        threadOne.start();
        threadOne.join();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
