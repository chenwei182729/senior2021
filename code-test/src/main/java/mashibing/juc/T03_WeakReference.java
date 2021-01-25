package mashibing.juc;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class T03_WeakReference {
    public static void main(String[] args)throws Exception {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
    }
}
