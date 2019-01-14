/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author booleanchoice
 * @version $Id: TestAsync.java, v 0.1 2019年01月04日 3:33 PM booleanchoice Exp $
 */
public class TestAsync {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        TestObject a = null;
        a = (TestObject) map.get("123");

        System.out.println("main started ------------------" + a);
        Foo foo = new Foo();
        foo.run();
        try {
            Thread.currentThread().sleep(1999L);
        } catch (Exception e) {

        }

        System.out.println("main stopped ------------------");
    }

}