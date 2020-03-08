package com.feivirus.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.feivirus.framework.Invocation;
import com.feivirus.registry.LocalRegistry;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author feivirus
 */
public class HttpServletHandler {
    public void handle(HttpServletRequest request, HttpServletResponse response) {
        try {
            Invocation invocation = JSONObject.parseObject(request.getInputStream(), Invocation.class);
            String interfaceName = invocation.getInterfaceName();
            Class implClass = LocalRegistry.findService(interfaceName);
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamType());

            String result = (String)method.invoke(implClass.newInstance(), invocation.getParams());

            System.out.println("local provider result: " + result);
            IOUtils.write(result, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
