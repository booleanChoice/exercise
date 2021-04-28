/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise.net.http;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author booleanchoice
 * @version $Id: TestHttpCall.java, v 0.1 2019年04月11日 7:12 PM booleanchoice Exp $
 */
public class TestHttpCall {

    private static String url = "";

    public static void main(String[] args) {
        HttpCall httpCall = new HttpCall();
        Runnable call1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(httpCall.post(url, null));
            }
        };
        Runnable call2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(httpCall.post(url, null));
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            executorService.execute(call1);
            executorService.execute(call2);
        }
    }

}

class HttpCall {

    public String post(String url, String param) {
        StringBuilder sb = new StringBuilder();
        HttpPost post = null;
        BufferedReader reader = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();

            // 设置超时时间
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);

            post = new HttpPost(url);
            // 构造消息头
            post.setHeader("Content-type", "application/json; charset=utf-8");
            // 构建消息实体
            StringEntity entity = new StringEntity(param, Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            post.setEntity(entity);
            HttpResponse response = httpClient.execute(post);
            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                if (null != response.getEntity().getContent()) {
                    reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
