package balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author chenxinwei
 * @date 2020/12/30 11:37
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

    public synchronized void change(String content) {
        this.content = content;
        this.changed = true;
    }

    public synchronized void save() throws IOException {
        if (!this.changed) {
            return;
        }
        doSave();
        this.changed = false;
    }

    public void doSave() throws IOException {
        System.out.println(String.format("%s calls doSave,content = %s", Thread.currentThread().getName(), this.content));
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
