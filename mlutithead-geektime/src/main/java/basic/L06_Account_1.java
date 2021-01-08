package basic;

/**
 * @author chenxinwei
 * @date 2021/1/5 16:44
 **/
public class L06_Account_1 {
    private L06_Allocator allocator = L06_Allocator.getInstance();
    private Integer balance;

    public L06_Account_1(Integer balance) {
        this.balance = balance;
    }

    void transfer(L06_Account_1 target, int amt) {
        allocator.apply(this, target);
        if (this.balance > amt) {
            this.balance -= amt;
            target.balance += amt;
        }
        allocator.free(this, target);
    }


    public static void main(String[] args) throws Exception {
        L06_Account_1 a = new L06_Account_1(200000);
        L06_Account_1 b = new L06_Account_1(200000);

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
