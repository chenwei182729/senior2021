import org.openjdk.jol.info.ClassLayout;

/**
 * @author chenxinwei
 * @date 2021/3/8 8:52
 * <p>
 * -XX:+UseCompressedOops  // 开启指针压缩
 * -XX:-UseCompressedOops  // 关闭指针压缩
 * -XX:+PrintCommandLineFlags // 这个参数让JVM打印出那些已经被用户或者JVM设置过的详细的XX参数的名称和值。
 * -XX:MaxTenuringThreshold //可以设置大小，默认为15,就会进入Old区(注意：如果一个对象太大，那么就会直接进入Old区)。
 **/
public class HeapMemory {
    public static void main(String[] args) {
//        Object object = new Object();
//        CompressItem compressItem = new CompressItem(1);
        Object[] objects = new Object[1];
        System.out.println(ClassLayout.parseInstance(objects).toPrintable());
        System.out.println("chen");
    }
}

class CompressItem {
    private int age;

    @Override
    public String toString() {
        return "CompressItem{" +
                "age=" + age +
                '}';
    }

    public CompressItem(int age) {
        this.age = age;
    }
}