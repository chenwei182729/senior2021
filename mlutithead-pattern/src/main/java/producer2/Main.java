package producer2;

/**
 * @author chenxinwei
 * @date 2021/1/15 17:32
 **/
public class Main {
    public static void main(String[] args) {
        final Table table = new Table(10);
        new MakeThread("maker1", table, 111L).start();
        new MakeThread("maker2", table, 222L).start();
        new MakeThread("maker3", table, 333L).start();
        new EaterThread("eater1", table, 33L).start();
    }
}
