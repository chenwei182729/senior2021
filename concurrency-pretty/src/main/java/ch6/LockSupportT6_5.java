package ch6;

import java.util.concurrent.locks.LockSupport;

public class LockSupportT6_5 {

    public void testPark(){
        LockSupport.park(this);
    }
    public static void main(String[] args) throws InterruptedException {
        final LockSupportT6_5 testPark = new LockSupportT6_5();

        testPark.testPark();
    }
}
