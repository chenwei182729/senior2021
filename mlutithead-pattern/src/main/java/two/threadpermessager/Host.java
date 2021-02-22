package two.threadpermessager;

/**
 * @author chenxinwei
 * @date 2021/2/22 18:13
 **/
public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + "," + c + ") BEGIN");
        new Thread() {
            @Override
            public void run() {
                helper.handle(count, c);
            }
        }.start();
        System.out.println("    request(" + count + "," + c + ") END");
    }
}
