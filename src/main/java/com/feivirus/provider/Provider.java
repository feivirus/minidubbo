package com.feivirus.provider;

import com.feivirus.framework.InterfaceAddress;
import com.feivirus.protocol.http.HttpServer;
import com.feivirus.provider.api.HelloMiniDubboService;
import com.feivirus.provider.impl.HelloMiniDubboServiceImpl;
import com.feivirus.registry.LocalRegistry;
import com.feivirus.registry.RemoteRegistry;

/**
 * @author feivirus
 */
public class Provider {
    public static void main(String[] args) {
        String hostName = "localhost";
        Integer port = 8080;

        //本地注册
        LocalRegistry.registerService(HelloMiniDubboService.class.getName(), HelloMiniDubboServiceImpl.class);

        //注册中心注册
        InterfaceAddress address = new InterfaceAddress(hostName, port);
        RemoteRegistry.register(HelloMiniDubboService.class.getName(), address);

        HttpServer httpServer = new HttpServer();
        httpServer.start(hostName, port);
    }

}
