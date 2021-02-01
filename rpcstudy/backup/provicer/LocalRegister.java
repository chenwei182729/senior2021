package provider;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxinwei
 * @date 2021/2/1 17:55
 **/
public class LocalRegister {
    private static Map<String, Class> LOCALREGISER = new HashMap<>();

    public static void register(String interfaceName, Class interfaceImpl) {
        LOCALREGISER.put(interfaceName, interfaceImpl);
    }

    public static Class get(String interfaceName) {
        return LOCALREGISER.get(interfaceName);
    }
}
