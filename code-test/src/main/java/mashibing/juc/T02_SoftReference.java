package mashibing.juc;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

public class T02_SoftReference {
    public static void main(String[] args)throws Exception {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(m.get());
        System.gc();


        TimeUnit.SECONDS.sleep(1);
        System.out.println(m.get());
        byte[] b = new byte[1024 * 1024 * 15];
        System.out.println(m.get());
    }
}
