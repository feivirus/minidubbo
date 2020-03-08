package com.feivirus.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * @author feivirus
 */
public class HttpUtil {
    public static String doPostJson(String hostName, Integer port, String url, String body) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        StringEntity entity = new StringEntity(body, "UTF-8");

        StringBuffer buffer = new StringBuffer("http://");
        buffer.append(hostName);
        buffer.append(":");
        buffer.append(port);
        buffer.append(url);
        HttpPost httpPost = new HttpPost(buffer.toString());

        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpPost);

            HttpEntity responseEntity = response.getEntity();

            return EntityUtils.toString(responseEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return null;
    }
}
