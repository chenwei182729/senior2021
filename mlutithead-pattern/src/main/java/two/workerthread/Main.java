package two.workerthread;

/**
 * @author chenxinwei
 * @date 2021/2/22 17:30
 **/
public class Main {
    public static void main(String[] args){
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("Alice",channel).start();
        new ClientThread("Bobby",channel).start();
        new ClientThread("Chris",channel).start();
    }


}
