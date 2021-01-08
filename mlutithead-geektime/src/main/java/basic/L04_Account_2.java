package basic;

/**
 * @author chenxinwei
 * @date 2021/1/5 16:44
 **/
public class L04_Account_2 {
    private Integer balance;

    public L04_Account_2(Integer balance) {
        this.balance = balance;
    }

    void transfer(L04_Account_2 target, int amt) {
//        synchronized (geektime.geektime.basic.L04_Account_2.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
//        }
    }


    public static void main(String[] args) throws Exception {
        L04_Account_2 a = new L04_Account_2(200000);
        L04_Account_2 b = new L04_Account_2(200000);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                a.transfer(b, 100);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                b.transfer(a, 100);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("finish total:" + (a.balance + b.balance));
    }
}
