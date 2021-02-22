package two.workerthread;

/**
 * @author chenxinwei
 * @date 2021/2/22 17:40
 **/
public class WorkerThread extends Thread {
    private Channel channel;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true){
            Request request=channel.takeRequest();
            request.execute();
        }
    }
}
