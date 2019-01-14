/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise.concurrent;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author booleanchoice
 * @version $Id: Foo.java, v 0.1 2019年01月04日 3:46 PM booleanchoice Exp $
 */
public class Foo {

    public void run() {
        int a = 1;
        int b = 2;
        TestObject testObject1 = new TestObject();
        testObject1.setTestAttr("233");
        TestObject testObject2 = new TestObject();
        testObject2.setTestAttr("456");
        System.out.println("outside test obj1 hashcode is " + testObject1.hashCode());
        System.out.println("outside test obj2 hashcode is " + testObject1.hashCode());
        System.out.println("start running !-------------------");
        CompletableFuture.supplyAsync(() -> {
            System.out.println("inside test obj1 hashcode is " + testObject1.hashCode());
            return a;
        }).thenAccept(this::consumer);
        System.out.println("stop running !-------------------");
    }

    private int call() {
        System.out.println("start calling !-------------------");
        FileOutputStream fos = null;
        try {
            Thread.currentThread().sleep(2000L);
            //// 获取系统home目录
            //Map<String, String> map = System.getenv();
            //String systemHome = map.get("HOME");
            //File file = new File(systemHome + File.separator + "filetest" +  File.separator);
            //if (!file.exists()) {
            //    file.mkdirs();
            //}
            //fos = new FileOutputStream(file);
            //fos.write("2333333333".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fos) {
                try {
                    fos.close();
                } catch (Exception e) {

                }
            }
        }
        System.out.println("stop calling !-------------------");
        return 1;
    }

    private void consumer(int i) {
        System.out.println("start callbacking !-------------------");
        System.out.println(i << 1);
        System.out.println("stop callbacking !-------------------");
    }

}