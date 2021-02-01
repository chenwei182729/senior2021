package sqlsession;

import java.lang.reflect.Proxy;

public class MySqlSession {
    private Excutor excutor = new MyExcutor();

    private MyConfiguration myConfiguration = new MyConfiguration();

    public <T> T selectOne(String statement, Object parameter) {
        return excutor.query(statement, parameter);
    }

    public <T> T getMapper(Class<T> clazz) {
        //动态代理调用
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},
                new MyMapperProxy(myConfiguration, this));
    }
}
