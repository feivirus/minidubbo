package com.feivirus.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.feivirus.framework.Invocation;
import com.feivirus.utils.HttpUtil;

/**
 * @author feivirus
 */
public class HttpClient {
    public String send(String hostName, Integer port, Invocation invocation) {
        String body = JSONObject.toJSONString(invocation);
        String response = HttpUtil.doPostJson(hostName, port, "/", body);
        return response;
    }
}
