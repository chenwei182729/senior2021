package basic;

/**
 * @author chenxinwei
 * @date 2021/1/5 16:44
 **/
public class L05_Account_3 {
    private int id;
    private Integer balance;

    public L05_Account_3(int id, Integer balance) {
        this.id = id;
        this.balance = balance;
    }

    void transfer(L05_Account_3 target, int amt) {
        L05_Account_3 left = this;
        L05_Account_3 right = target;
        if (this.id > target.id) {
            left = target;
            right = this;
        }
        synchronized (left) {
            synchronized (right) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        L05_Account_3 a = new L05_Account_3(1,200000);
        L05_Account_3 b = new L05_Account_3(2,200000);

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
        System.out.println("finish total: " + (a.balance + b.balance));
    }
}
