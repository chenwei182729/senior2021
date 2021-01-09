package ch2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnSafe2 {
    static final Unsafe unsafe ;

    static final long stateOffset;
    private volatile long state = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe=(Unsafe)field.get(null);
            stateOffset = unsafe.objectFieldOffset(TestUnSafe2.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnSafe2 testUnSafe = new TestUnSafe2();
        final Boolean success = unsafe.compareAndSwapInt(testUnSafe, stateOffset, 0, 1);
        System.out.println(success);
    }
}
