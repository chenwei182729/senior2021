package shangxuetang.yang.juc;

/**
 * @author chenxinwei
 * @date 2021/1/5 18:31
 **/
public class ReEnterLockDemo1 {
    static Object objectLockA = new Object();

    public static void m1(){
        new Thread(()->{
            synchronized (objectLockA){
                System.out.println("外层");
                synchronized (objectLockA){
                    System.out.println("中层");
                    synchronized (objectLockA){
                        System.out.println("内层");
                    }
                }

            }
        }).start();
    }

    public static void main(String[] args) {
        m1();
    }
}
