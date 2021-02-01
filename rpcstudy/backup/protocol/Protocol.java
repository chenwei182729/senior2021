package protocol;

import framework.Invocation;
import framework.URL;

/**
 * @author chenxinwei
 * @date 2021/2/1 18:02
 **/
public interface Protocol {

    void start(URL url);


    String send(URL url, Invocation invocation);
}
