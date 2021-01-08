package balking;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2020/12/30 11:37
 **/
public class ChangeThread extends Thread {
    private final Data data;
    private final Random random = new Random();

    public ChangeThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No. " + i);
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                data.save();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
