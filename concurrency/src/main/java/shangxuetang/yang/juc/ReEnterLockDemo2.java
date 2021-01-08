package shangxuetang.yang.juc;

/**
 * @author chenxinwei
 * @date 2021/1/5 18:31
 **/
public class ReEnterLockDemo2 {
    static Object objectLockA = new Object();

    public synchronized void m1() {
        System.out.println("外层");
        m2();
    }

    public synchronized void m2() {
        System.out.println("中层");
        m3();
    }

    public synchronized void m3() {
        System.out.println("内层");
    }

    public static void main(String[] args) {
        new ReEnterLockDemo2().m1();

    }
}
