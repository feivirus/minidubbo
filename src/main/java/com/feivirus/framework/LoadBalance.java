package com.feivirus.framework;

import java.util.List;
import java.util.Random;

/**
 * @author feivirus
 */
public class LoadBalance {
    public static InterfaceAddress random(List<InterfaceAddress> addressList) {
        Random random = new Random();

        int n = random.nextInt(addressList.size());
        return addressList.get(n);
    }
}
