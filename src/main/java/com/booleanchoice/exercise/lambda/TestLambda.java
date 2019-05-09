/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author booleanchoice
 * @version $Id: TestLambda.java, v 0.1 2019年05月09日 10:04 AM booleanchoice Exp $
 */
public class TestLambda {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        Map<String, Object> rs
            = map.entrySet().stream().filter((e) -> "1".equals(e.getKey())).collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));
        System.out.println(rs);
    }

}