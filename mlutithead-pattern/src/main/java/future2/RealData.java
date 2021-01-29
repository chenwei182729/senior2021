package future2;

import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/28 18:32
 **/
public class RealData implements Data {
    private final String content;

    public RealData(int count, char c) {
        System.out.println("\t making realData(" + count + ", " + c + ") Begin");

        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\t making realData(" + count + ", " + c + ") End");
        content = new String(buffer);
    }

    @Override
    public String getContent() {
        return content;
    }
}
