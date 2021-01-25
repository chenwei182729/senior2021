package kaikeba.day1;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        ClassLoader classLoader = classLoaderTest.getClass().getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
