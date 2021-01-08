package ch01;

/**
 * @author chenxinwei
 * @date 2021/1/7 15:33
 **/
public class Main_T1_13 {
    public static void main(String[] args) {
        BankTest1_13 bank = new BankTest1_13(1000000, "A Band Bank");

        new ClientThread(bank).start();
        new ClientThread(bank).start();
    }
}

class ClientThread extends Thread {
    private BankTest1_13 bank;

    public ClientThread(BankTest1_13 bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            boolean ok = bank.withdraw(1000);
            if (ok) {
                bank.deposit(1000);
            }
        }
    }
}