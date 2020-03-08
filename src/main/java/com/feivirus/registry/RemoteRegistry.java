package com.feivirus.registry;

import com.feivirus.framework.InterfaceAddress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feivirus
 */
public class RemoteRegistry {
    /**
     * 每个接口可以有多个提供者
     */
    private static Map<String, List<InterfaceAddress>> REGISTRY = new HashMap<>();

    public static void register(String interfaceName, InterfaceAddress address) {
        List<InterfaceAddress> providerList = REGISTRY.get(interfaceName);

        if (providerList == null) {
            providerList = new ArrayList<>();
        }
        if (!providerList.contains(address)) {
            providerList.add(address);
        }

        REGISTRY.put(interfaceName, providerList);
    }

    public static List<InterfaceAddress> get(String interfaceName) {
        List<InterfaceAddress> providerList = REGISTRY.get(interfaceName);
        return providerList;
    }


}
