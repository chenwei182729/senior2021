package shangxuetang.yang.juc;

/**
 * @author chenxinwei
 * @date 2021/1/5 18:31
 **/
public class ReEnterLockDemo {
    static Object objectLockA = new Object();

    public static void m1() {
        new Thread(() -> {
            synchronized (objectLockA) {
                System.out.println("外层");
            }
        }).start();
    }

    public static void main(String[] args) {
        m1();
    }
}
