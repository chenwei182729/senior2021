package protocol;

import framework.Invocation;
import framework.URL;

/**
 * @Author: wanghz
 * @Date: 2020/5/1 6:16 PM
 */
public interface Protocol {

    void start(URL url);

    String send(URL url, Invocation invocation);

}
