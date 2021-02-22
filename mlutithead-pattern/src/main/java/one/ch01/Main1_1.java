package one.ch01;

/**
 * @author chenxinwei
 * @date 2021/1/8 9:13
 **/
public class Main1_1 {
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit CTRL+C to exit");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
