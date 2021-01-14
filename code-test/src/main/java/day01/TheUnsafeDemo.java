package day01;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author chenxinwei
 * @date 2021/1/13 11:05
 **/
public class TheUnsafeDemo {
    final static Unsafe unsafe;
    final static long offSetStatus;
    int status = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            offSetStatus = unsafe.objectFieldOffset(TheUnsafeDemo.class.getDeclaredField("status"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TheUnsafeDemo theUnsafeDemo = new TheUnsafeDemo();
        boolean success = unsafe.compareAndSwapInt(theUnsafeDemo, offSetStatus, 0, 1);
        System.out.println(success);
        System.out.println(theUnsafeDemo.status);
    }
}
