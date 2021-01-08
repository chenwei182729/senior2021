package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxinwei
 * @date 2021/1/5 17:31
 **/
public class L05_Allocator {
    private static volatile L05_Allocator instance;

    public static L05_Allocator getInstance() {
        if (instance == null) {
            synchronized (L05_Allocator.class) {
                if (instance == null) {
                    instance = new L05_Allocator();
                }
            }
        }
        return instance;
    }

    private L05_Allocator() {

    }

    private List<Object> als = new ArrayList<>();

    synchronized boolean apply(Object from, Object to) {
        if (als.contains(from) || als.contains(to)) {
            return false;
        } else {
            als.add(from);
            als.add(to);
        }
        return true;
    }

    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
    }
}
