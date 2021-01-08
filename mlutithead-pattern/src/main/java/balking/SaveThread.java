package balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2020/12/30 11:37
 **/
public class SaveThread extends Thread {
    private final Data data;

    public SaveThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                data.save();
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
