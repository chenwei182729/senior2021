package producer2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/15 17:33
 **/
public class MakeThread extends Thread {
    private final Table table;
    private final Random random;
    private static int id = 0;

    public MakeThread(String name, Table table, Long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                String cake = String.format("[ Cake No. %d by %s ]", nextId(), Thread.currentThread().getName());
                table.put(cake);
            }
        } catch (InterruptedException e) {

        }
    }

    private synchronized static int nextId() {
        return id++;
    }

}
