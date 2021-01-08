package basic;

/**
 * @author chenxinwei
 * @date 2021/1/5 16:19
 **/
public class L02_T1_1 {
   volatile static String abc;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            L02_T1_1.abc = "hello";
        });

        Thread t2 = new Thread(() -> {
            System.out.println(L02_T1_1.abc);
        });

        t1.start();
        t2.start();

    }
}
