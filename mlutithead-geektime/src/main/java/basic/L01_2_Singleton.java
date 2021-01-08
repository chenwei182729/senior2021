package basic;

/**
 * @author chenxinwei
 * @date 2021/1/5 15:59
 **/
public class L01_2_Singleton {
    static L01_2_Singleton instance;

    static L01_2_Singleton getInstance() {
        if (instance == null) {
            synchronized (L01_2_Singleton.class) {
                instance = new L01_2_Singleton();
            }
        }
        return instance;
    }

}
/**
 * new 正常操作是：
 * 1. 分配一块内存 M
 * 2. 将内存 M 上初始化Singleton对象
 * 3. 然后 M 的地址赋值给 instance 变量
 * <p>
 * 实际优化后的执行路径却是这样：
 * 1. 分配一块内存 M
 * 2. 然后 M 的地址赋值给 instance 变量
 * 3. 将内存 M 上初始化Singleton对象
 * 引起的问题是什么呢？
 * 假设A执行getInstance()方法，当执行完成指令2时，恰好发生了线程切换，切换到了B上
 * 如果此时线程B也执行getInstance()方法，instance!=null,直接返回了instance,
 * 此时instance没有初始化，如果这个时候访问instance的成员变量就可能触发空指针异常
 **/