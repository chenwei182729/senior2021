package one.producer2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/15 17:32
 **/
public class EaterThread extends Thread {
    private final Table table;
    private final Random random;

    public EaterThread(String name, Table table, Long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true) {
                table.take();
                TimeUnit.MILLISECONDS.sleep(random.nextInt(300));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
