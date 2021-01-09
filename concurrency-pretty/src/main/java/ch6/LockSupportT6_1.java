package ch6;

import java.util.concurrent.locks.LockSupport;

public class LockSupportT6_1 {

    public static void main(String[] args) {
        System.out.println("begin park!");
        LockSupport.park();
        System.out.println("end park!");


    }
}
