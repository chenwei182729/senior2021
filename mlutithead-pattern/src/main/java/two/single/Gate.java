package two.single;

/**
 * @author chenxinwei
 * @date 2021/2/22 15:33
 **/
public class Gate {
    private int counter;
    private String name;
    private String address;

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println(toString());
        }
    }

    @Override
    public synchronized String toString() {
        return "No. " + counter + ", " + name + ", " + address;
    }
}
