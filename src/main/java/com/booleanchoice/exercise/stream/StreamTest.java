/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author booleanchoice
 * @version $Id: StreamTest.java, v 0.1 2019年01月09日 3:48 PM booleanchoice Exp $
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(1, "red"));
        apples.add(new Apple(2, "yellow"));
        Map<Integer, Apple> appleMap = apples.stream().collect(Collectors.toMap(Apple::getId, each -> each));
        appleMap.get(1).setColor("blue");
        appleMap.get(2).getTag().setTagName("xixixi");
        System.out.println(apples.get(0).getColor());
        System.out.print(apples.get(1).getTag().getTagName());
        System.out.println(00 == 0);

        String val = "abcd";
        System.out.println(val.substring(val.length() - 2));
        Map map = new HashMap();
        map.put("23", "!23");
        dealMap(map);
        System.out.println(map);
    }

    public static Map dealMap(Map map) {
        map.put("23", "87687687");
        return map;
    }

}