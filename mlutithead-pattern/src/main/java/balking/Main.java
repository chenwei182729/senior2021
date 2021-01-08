package balking;

/**
 * @author chenxinwei
 * @date 2020/12/30 11:37
 **/
public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangeThread("ChangerThread", data).start();
        new SaveThread("saveThread", data).start();
    }
}
