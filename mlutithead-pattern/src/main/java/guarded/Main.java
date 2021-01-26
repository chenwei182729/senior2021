package guarded;

/**
 * @author chenxinwei
 * @date 2021/1/14 18:21
 **/
public class Main {
    public static void main(String[] args) {
        final RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"Alice",31415925).start();
        new ServerThread(requestQueue,"Bobby",3141592).start();
    }
}
