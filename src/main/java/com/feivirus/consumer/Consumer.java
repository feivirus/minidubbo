package com.feivirus.consumer;

import com.feivirus.framework.Invocation;
import com.feivirus.protocol.http.HttpClient;
import com.feivirus.provider.api.HelloMiniDubboService;

/**
 * @author feivirus
 */
public class Consumer {
    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        Invocation invocation = new Invocation(HelloMiniDubboService.class.getName(),
                "hello",
                new Object[]{"i am consumer"},
                new Class[]{String.class});

        String result = httpClient.send("localhost", 8080, invocation);
        System.out.println("consumer: " + result);
    }
}
