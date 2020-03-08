package com.feivirus.provider.impl;

import com.feivirus.provider.api.HelloMiniDubboService;

/**
 * @author feivirus
 */
public class HelloMiniDubboServiceImpl implements HelloMiniDubboService {
    @Override
    public String hello(String message) {
        String result = "i am MiniDubboServiceImpl " + message;
        System.out.println(result);
        return result;
    }
}
