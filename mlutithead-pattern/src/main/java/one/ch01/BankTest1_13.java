package one.ch01;

/**
 * @author chenxinwei
 * @date 2021/1/7 15:09
 **/
public class BankTest1_13 {
    private int money;
    private final String name;

    public BankTest1_13(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public void deposit(int m) {
        money += m;
    }

    public boolean withdraw(int m) {
        if (money >= m) {
            money -= m;
            check();
            return true;
        } else {
            return false;
        }
    }

    private void check() {
        if (money < 0) {
            System.out.println("可用金额为负");
        }
    }

    public String getName() {
        return name;
    }
}
