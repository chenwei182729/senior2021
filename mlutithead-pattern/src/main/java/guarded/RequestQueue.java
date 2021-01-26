package guarded;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenxinwei
 * @date 2021/1/14 18:09
 **/
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    public synchronized void pubRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
