package suspension;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2020/12/29 18:24
 **/
public class ClientThread extends Thread {
    private final Random random;
    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No." + i);
            System.out.println(String.format("%s request %s\n", Thread.currentThread().getName(), request));
            requestQueue.putRequest(request);

            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
