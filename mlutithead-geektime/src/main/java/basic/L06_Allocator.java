package basic;

import java.util.ArrayList;
import java.util.List;
/**
 * 小试牛刀：一个更好地资源分配器等待 - 通知机制的基本原理搞清楚后，我们就来看看它如何解决一次性申请转出账户和转入账户的问题吧。在这个等待 - 通知机制中，我们需要考虑以下四个要素。互斥锁：上一篇文章我们提到 Allocator 需要是单例的，所以我们可以用 this 作为互斥锁。线程要求的条件：转出账户和转入账户都没有被分配过。何时等待：线程要求的条件不满足就等待。何时通知：当有线程释放账户时就通知。
 */

/**
 * @author chenxinwei
 * @date 2021/1/5 17:31
 **/
public class L06_Allocator {
    private static volatile L06_Allocator instance;

    public static L06_Allocator getInstance() {
        if (instance == null) {
            synchronized (L06_Allocator.class) {
                if (instance == null) {
                    instance = new L06_Allocator();
                }
            }
        }
        return instance;
    }

    private L06_Allocator() {

    }

    private List<Object> als = new ArrayList<>();

    synchronized void apply(Object from, Object to) {
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        als.add(from);
        als.add(to);
    }

    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }
}
