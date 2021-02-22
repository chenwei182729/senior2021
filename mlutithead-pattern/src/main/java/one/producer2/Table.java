package one.producer2;

/**
 * @author chenxinwei
 * @date 2021/1/15 17:32
 **/
public class Table {
    private final String[] buffer;
    private int head;
    private int tail;
    private int count;

    public Table(int tableSize) {
        this.buffer = new String[tableSize];
        head = 0;
        tail = 0;
        count = 0;
    }

    public synchronized void put(String str) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " put " + str);
        if (count >= buffer.length) {
            wait();
        }
        tail = (tail + 1) % buffer.length;
        buffer[tail] = str;
        count++;
        notifyAll();
    }

    public synchronized void take() throws InterruptedException {
        if (count <= 0) {
            wait();
        }
        head = (head + 1) % buffer.length;
        String ret = buffer[head];
        count--;
        notifyAll();
        System.out.println(String.format("%s takes %s", Thread.currentThread().getName(), ret));
    }
}
