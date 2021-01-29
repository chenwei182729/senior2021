package workerthread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/28 17:14
 **/
public class Request {
    private final String name;
    private final int number;
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.number = number;
        this.name = name;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);

        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "[ Request from" + name + " No." + number + "]";
    }
}
