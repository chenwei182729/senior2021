import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/22 8:34
 **/
public class ThreadLocalT1 {
    static ThreadLocal<Person> t1 = new ThreadLocal<Person>() {
        @Override
        protected void finalize() throws Throwable {
            System.out.println(Thread.currentThread().getName() + " t1 被回收了");
        }
    };

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (t1 != null) {
                System.out.println(Thread.currentThread().getName() + " " + t1.get());
            } else {
                System.out.println("t1 is null");

            }
        }, "thread1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1.set(new Person());
            System.out.println(Thread.currentThread().getName() + " " + t1.get());
//            t1.remove(); //这里去掉remove的话，Person是回收不了的
            t1 = null;
            System.gc();
            System.out.println("------------ end -----");
        }, "thread2").start();
        TimeUnit.SECONDS.sleep(3);


        System.in.read();
    }

    static class Person {
        String name = "chen";

        /**
         * 这里只是为了观察垃圾回收，生产环境严禁重写 finalize 方法
         *
         * @throws Throwable
         */
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Person被回收了");
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
