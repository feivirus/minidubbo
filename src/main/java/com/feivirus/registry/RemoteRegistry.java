package com.feivirus.registry;

import com.feivirus.framework.InterfaceAddress;

import java.io.*;
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

    private static String addressFilePath = "/tmp/miniDubboAddress.txt";

    public static void register(String interfaceName, InterfaceAddress address) {
        List<InterfaceAddress> providerList = REGISTRY.get(interfaceName);

        if (providerList == null) {
            providerList = new ArrayList<>();
        }
        if (!providerList.contains(address)) {
            providerList.add(address);
        }

        REGISTRY.put(interfaceName, providerList);
        saveFile();
    }

    public static List<InterfaceAddress> get(String interfaceName) {
        REGISTRY = getFile();

        List<InterfaceAddress> providerList = REGISTRY.get(interfaceName);
        return providerList;
    }

    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(addressFilePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTRY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<InterfaceAddress>> getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(addressFilePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<InterfaceAddress>>)objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
