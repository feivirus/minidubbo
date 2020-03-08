package com.feivirus.protocol;

import com.feivirus.protocol.http.HttpProtocol;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author feivirus
 */
public class ProtocolFactory {
    /**
     * 1.不能通过注解，选择具体用哪个协议的实现类，这里文件取出来的有多个协议的实现类
     * 2.协议的实现类如果有依赖其他类，不能实现依赖注入
     * 3.针对实现类没有AOP功能，做拦截操作
     * @return
     */
    public static Protocol getProtocolBySpi() {
        ServiceLoader<Protocol> serviceLoader = ServiceLoader.load(Protocol.class);
        Iterator<Protocol> iterator = serviceLoader.iterator();
        return iterator.next();
    }

    public static Protocol getProtocolByProperty() {
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
