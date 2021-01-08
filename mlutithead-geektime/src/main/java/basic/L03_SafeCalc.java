package basic;

/**
 * @author chenxinwei
 * @date 2021/1/5 16:28
 **/
public class L03_SafeCalc {
    long value = 0L;

   synchronized long get() {
        return value;
    }

    synchronized void addOne() {
        value += 1;
    }


    public static void main(String[] args) {
        L03_SafeCalc l03_safeCalc = new L03_SafeCalc();

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("t1: " + l03_safeCalc.get());
                l03_safeCalc.addOne();
            }
        });


        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("th2:" + l03_safeCalc.get());
            }
        });

        th1.start();
        th2.start();
    }
}
