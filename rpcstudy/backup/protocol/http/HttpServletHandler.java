package protocol.http;

import framework.Invocation;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import provider.LocalRegister;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;

/**
 * @author chenxinwei
 * @date 2021/2/1 18:14
 **/
public class HttpServletHandler {

    public void handle(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ServletInputStream inputStream = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);

            Invocation invocation = (Invocation) ois.readObject();
            Class implClass = LocalRegister.get(invocation.getInterfaceName());
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());
            IOUtils.write(result, resp.getOutputStream(), "utf-8");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
