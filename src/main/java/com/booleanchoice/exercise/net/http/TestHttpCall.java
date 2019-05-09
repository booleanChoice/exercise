/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise.net.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author booleanchoice
 * @version $Id: TestHttpCall.java, v 0.1 2019年04月11日 7:12 PM booleanchoice Exp $
 */
public class TestHttpCall {

    private static String url = "http://localhost:8080/invoke/executeDynamicDecision";
    private static String param1 = JSON.parseObject("{\n"
        + "\t\"decisionId\": \"JiebeiCreditV1\",\n"
        + "\t\"inputs\": {\n"
        + "\t\t\"PHONE_NO\":\"18729044748\",\"ID_CARD\":\"61012119980209673X\"\n"
        + "\t}\n"
        + "}").toJSONString();
    private static String param2 = JSON.parseObject("{\n"
        + "\t\"decisionId\": \"JBTELowAck\",\n"
        + "\t\"inputs\": {\n"
        + "\t\t\"PHONE_NO\":\"13606661853\",\"ID_CARD\":\"341221199007034995\"\n"
        + "\t}\n"
        + "}").toJSONString();

    public static void main(String[] args) {
        HttpCall httpCall = new HttpCall();
        Runnable call1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(httpCall.post(url, param1));
            }
        };
        Runnable call2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(httpCall.post(url, param2));
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
