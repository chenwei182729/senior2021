package mashibing.juc;

import java.util.concurrent.TimeUnit;

public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }

    public static void main(String[] args) throws Exception {
        M m = new M();
        m = null;
        System.gc();
        System.out.println(m);
        System.in.read();
    }
}
