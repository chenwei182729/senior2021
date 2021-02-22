package one.singlethread;

/**
 * @author chenxinwei
 * @date 2021/1/14 18:00
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("Tesing Gate, hit Ctrl + C to exit!");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chirs", "Canada").start();


    }
}
