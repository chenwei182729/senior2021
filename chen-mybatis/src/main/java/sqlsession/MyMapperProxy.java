package sqlsession;

import config.Function;
import config.MapperBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MyMapperProxy implements InvocationHandler {
    private MySqlSession mySqlSession;

    private MyConfiguration myConfiguration;

    public MyMapperProxy(MyConfiguration myConfiguration, MySqlSession mySqlSession) {
        this.myConfiguration = myConfiguration;
        this.mySqlSession = mySqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean readMapper = myConfiguration.readMapper("UserMapper.xml");
        //是否是xml文件对应的接口
        if (!method.getDeclaringClass().getName().equals(readMapper.getInterfaceName())) {
            return null;
        }
        List<Function> list = readMapper.getList();
        if (null != list || 0 != list.size()) {
            for (Function function : list) {
                //id是否和接口方法名一样
                if (method.getName().equals(function.getFuncName())) {
                    return mySqlSession.selectOne(function.getSql(), String.valueOf(args[0]));
                }
            }
        }
        return null;
    }
}
