package balking;

/**
 * @author chenxinwei
 * @date 2021/1/14 18:44
 **/
public class Main {
    public static void main(String[] args) {
        final Data data = new Data("data.txt", "(empty)");
        new ChangeThread("changeThread", data).start();
        new SaveThread("saveThread", data).start();
    }
}
