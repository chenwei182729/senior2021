package basic;

/**
 * @author chenxinwei
 * @date 2021/1/5 16:44
 **/
public class L04_Account_1 {
    private final Object balLock = new Object();
    private Integer balance;
    private final Object pwLock = new Object();
    private String password;

    void withDraw(Integer amt) {
        synchronized (balLock) {
            if (this.balance > amt) {
                this.balance -= amt;
            }
        }
    }

    Integer getBalance() {
        synchronized (balLock) {
            return balance;
        }
    }

    void updatePassword(String pw) {
        synchronized (pwLock) {
            this.password = pw;
        }
    }

    String getPassword() {
        synchronized (pwLock) {
            return password;
        }
    }

    public static void main(String[] args) {

    }
}
