package balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.IntToDoubleFunction;

/**
 * @author chenxinwei
 * @date 2021/1/14 18:30
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
