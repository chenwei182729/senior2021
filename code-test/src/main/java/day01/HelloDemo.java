package day01;

/**
 * 可重入锁
 * @author chenxinwei
 * @date 2021/1/13 17:36
 **/
public class HelloDemo {

    private synchronized static void helloA(){
        System.out.println("helloA");
    }
    private synchronized static void helloB(){
        System.out.println("helloB");
        helloA();
    }

    public static void main(String[] args) {
        helloB();
    }
}
