package com.feivirus.registry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feivirus
 */
public class LocalRegistry {

    private static Map<String, Class> registeredServiceMap = new HashMap<>();

    public static void registerService(String interfaceName, Class implClass) {
        registeredServiceMap.put(interfaceName, implClass);
    }

    public static Class findService(String interfaceName) {
        return registeredServiceMap.get(interfaceName);
    }
}
