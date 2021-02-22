package two.workerthread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/2/22 17:31
 **/
public class ClientThread extends Thread{
    private final Channel channel;
    private static final Random random = new Random();
    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel=channel;
    }

    @Override
    public void run() {
        try{
            for (int i=0;true;i++){
                Request request=new Request(getName(),i);
                channel.putRequest(request);
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            }
        }catch (InterruptedException e){

        }
    }
}
