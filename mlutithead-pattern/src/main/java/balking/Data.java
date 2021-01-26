package balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author chenxinwei
 * @date 2021/1/14 18:26
 **/
public class Data {
    private final String filename;
    private String content;
    private boolean changed;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = false;
    }

    public synchronized void change(String newContent) {
        content = newContent;
        this.changed = true;
    }

    public synchronized void save() throws IOException {
        if (changed) {
            doSave();
            changed = false;
        }
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
