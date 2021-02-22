package one.singlethread;

/**
 * @author chenxinwei
 * @date 2021/1/14 17:55
 **/
public class Gate {
    private int count = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void  pass(String name, String address) {
        this.count++;
        this.name = name;
        this.address = address;
        check();
    }

    private synchronized void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("****** BROKEN *******" + toString());
        }
    }

    @Override
    public String toString() {
        return "No." + count + ":" + name + "," + address;
    }
}
