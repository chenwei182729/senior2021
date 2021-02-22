package one.ch01;

import net.jcip.annotations.NotThreadSafe;

/**
 * @author chenxinwei
 * @date 2021/1/8 9:13
 **/
@NotThreadSafe
public class Gate {
    private Integer counter = 0;
    private String name;
    private String address;

    public synchronized void pass(String name, String address) {
        counter++;
        this.name = name;
        this.address = address;
        check();
    }

    @Override
    public synchronized String toString() {
        return "No." + counter + ":" + name + ":" + address;
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println(String.format("********** BROKEN ***** %s", toString()));
        }
    }
}
