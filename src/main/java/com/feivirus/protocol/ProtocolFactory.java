package com.feivirus.protocol;

import com.feivirus.protocol.http.HttpProtocol;

/**
 * @author feivirus
 */
public class ProtocolFactory {
    public static Protocol getProtocol() {
        String name = System.getProperty("protocol");
        if (name == null || name.equals("")) {
            System.out.println("没有配置协议, 默认使用http");
            name = "http";
        }

        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":

        }
        return null;
    }
}
