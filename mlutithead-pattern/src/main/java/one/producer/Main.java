package one.producer;

/**
 * @author chenxinwei
 * @date 2020/12/30 14:08
 **/
public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        new MakeThread("MakeThread-1", table, 31415).start();
        new MakeThread("MakeThread-2", table, 92653).start();
        new MakeThread("MakeThread-3", table, 58979).start();

        new EaterThread("EaterThread-1", table, 32384).start();
        new EaterThread("EaterThread-2", table, 62643).start();
        new EaterThread("EaterThread-3", table, 38327).start();
    }
}
