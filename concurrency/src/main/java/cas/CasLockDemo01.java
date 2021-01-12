package cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class CasLockDemo01 {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        final Thread thread = Thread.currentThread();
        System.out.println(String.format("%s come in", thread.getName()));
        while (!atomicReference.compareAndSet(null, thread)) {
            System.out.println(String.format("%s 没抢到，继续循环抢", thread.getName()));
        }
    }

    public void myRelease() {
        final Thread thread = Thread.currentThread();
        System.out.println(String.format("%s release", thread.getName()));
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) {
        final CasLockDemo01 lockDemo01 = new CasLockDemo01();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lockDemo01.myLock();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockDemo01.myRelease();
            }, "thread-" + i).start();
        }
    }

}
