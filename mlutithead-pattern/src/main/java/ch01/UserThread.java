package ch01;

/**
 * @author chenxinwei
 * @date 2021/1/8 9:13
 **/
public class UserThread extends Thread {
    private final Gate gate;
    private final String myname;
    private final String myaddress;

    public UserThread(Gate gate, String myname, String myaddress) {
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s BEGIN", myaddress));
        while (true) {
            gate.pass(myname, myaddress);
        }
    }
}
