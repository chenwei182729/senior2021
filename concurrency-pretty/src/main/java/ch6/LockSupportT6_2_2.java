package ch6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportT6_2_2 {

    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        lock.lock();
        try {
            System.out.println("begin wait");
            condition.await();
            System.out.println("end wait");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        lock.lock();

        try {
            System.out.println("begin signal");
            condition.signal();
            System.out.println("end signal");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


        condition.signal();
    }
}
