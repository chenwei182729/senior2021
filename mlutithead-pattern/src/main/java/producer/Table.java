package producer;

/**
 * @author chenxinwei
 * @date 2020/12/30 14:08
 **/
public class Table {
    private final String[] buffer;
    private int tail;//下一次放蛋糕的位置
    private int head;//下一次取蛋糕的位置
    private int count;

    public Table(int count) {
        this.buffer = new String[count];
    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }

        String cake = buffer[head];
        if (head + 1 >= buffer.length) {
            head = (head + 1) - buffer.length;
        } else {
            head = (head + 1);
        }

        count--;
        notifyAll();
        System.out.println(String.format("%s takes %s", Thread.currentThread().getName(), cake));
        return cake;
    }

    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(String.format("%s puts %s", Thread.currentThread().getName(), cake));

        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        if (tail + 1 >= buffer.length) {
            tail = tail + 1 - buffer.length;
        } else {
            tail = tail + 1;
        }
        count++;
        notifyAll();
    }
}
