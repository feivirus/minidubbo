package com.feivirus.framework;

import com.feivirus.protocol.Protocol;
import com.feivirus.protocol.ProtocolFactory;
import com.feivirus.protocol.http.HttpClient;
import com.feivirus.protocol.http.HttpProtocol;
import com.feivirus.provider.api.HelloMiniDubboService;
import com.feivirus.registry.RemoteRegistry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author feivirus
 */
public class ProxyFactory {

    public static <T> T getProxyVersion2(Class interfaceClass) {
        T result = (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Protocol protocol = ProtocolFactory.getProtocol();
                        Invocation invocation = new Invocation(interfaceClass.getName(),
                                method.getName(),
                                args,
                                method.getParameterTypes());
                        /**
                         * RemoteRegistry的地址列表需要去zk，redis等注册中心获取
                         */
                        InterfaceAddress address = LoadBalance.random(
                                RemoteRegistry.get(interfaceClass.getName()));

                        String result = protocol.send(address, invocation);
                        return result;
                    }
                });
        return result;
    }


    public static <T> T getProxyVersion1(Class interfaceClass) {
        T result = (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        HttpClient httpClient = new HttpClient();
                        Invocation invocation = new Invocation(interfaceClass.getName(),
                                method.getName(),
                                args,
                                method.getParameterTypes());

                        String result = httpClient.send("localhost", 8080, invocation);
                        return result;
                    }
                });
        return result;
    }
}
