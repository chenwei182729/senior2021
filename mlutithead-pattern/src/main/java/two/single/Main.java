package two.single;

/**
 * @author chenxinwei
 * @date 2021/2/22 15:27
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit ctrl + c to exit");
        Gate gate = new Gate();
        new UserThread(gate,"Alice","Alaska").start();
        new UserThread(gate,"Bobby","Brazil").start();
        new UserThread(gate,"Chris","Canda").start();
    }
}
