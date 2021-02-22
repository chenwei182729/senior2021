package two.single;

/**
 * @author chenxinwei
 * @date 2021/2/22 15:35
 **/
public class UserThread extends Thread {
    private final Gate gate;
    private String name;
    private String address;

    public UserThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        System.out.println(name + " BEGIN");
        while (true) {
            gate.pass(this.name, this.address);
        }
    }
}
