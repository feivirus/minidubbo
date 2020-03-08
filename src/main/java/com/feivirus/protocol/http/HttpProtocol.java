package com.feivirus.protocol.http;

import com.feivirus.framework.InterfaceAddress;
import com.feivirus.framework.Invocation;
import com.feivirus.protocol.Protocol;

/**
 * @author feivirus
 */
public class HttpProtocol implements Protocol {
    @Override
    public void start(InterfaceAddress address) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(address.getHostName(), address.getPort());
    }

    @Override
    public String send(InterfaceAddress address, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(address.getHostName(), address.getPort(), invocation);
    }
}
