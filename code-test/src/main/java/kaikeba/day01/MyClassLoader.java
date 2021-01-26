package kaikeba.day01;

import day01.HelloDemo;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenxinwei
 * @date 2021/1/19 10:00
 **/
public class MyClassLoader extends ClassLoader{
    private String name;

    public MyClassLoader() {
        super(null);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/")+".class";
        InputStream classInputStream = getSystemClassLoader().getResourceAsStream(classPath);
        try {
            byte[] classBytes = new byte[classInputStream.available()];
            classInputStream.read(classBytes);
            Class clazz = defineClass(name, classBytes, 0, classBytes.length);
            resolveClass(clazz);
            return clazz;
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }

    public static void main(String[] args) throws Exception{
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("day01.HelloDemo");
        HelloDemo helloDemo = new HelloDemo();
        ClassLoader classLoader = helloDemo.getClass().getClassLoader();
        System.out.println(aClass.getClassLoader());
        System.out.println(classLoader);
    }
}
