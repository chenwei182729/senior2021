package guarded.code2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/14 18:15
 **/
public class ClientThread extends Thread {
    private final String name;
    private final Random random;
    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        this.name = name;
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No. " + i);
            requestQueue.putRequest(request);
            System.out.println(Thread.currentThread().getName() + " request " + request);

            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
