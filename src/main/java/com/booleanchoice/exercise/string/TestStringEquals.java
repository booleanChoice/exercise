/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise.string;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author booleanchoice
 * @version $Id: TestStringEquals.java, v 0.1 2019年03月04日 5:03 PM booleanchoice Exp $
 */
public class TestStringEquals {

    private static final List<String> DATA_CENTER_FEATURE_NA_VALUES = Arrays.asList(new String[] {"null", "NULL", "na", "NA", "n/a", "N/A"});

    private static class Apple {
        private String color;

        public void setColor(String color) {
            this.color = color;
        }
    }

    public static String splitPart0(String str, String separator, Long start, Long end) {
        if (str == null || separator == null){
            return null;
        }
        if (start <= 0) {
            start = 1L;
        }
        if(end == null){
            end = start;
        }
        if (end < start) {
            throw new IllegalArgumentException("截止编号必须大于或等于起始编号");
        }
        if ((!str.contains(separator) && start == 1L)) {
            return str;
        }
        if(separator.isEmpty()){
            return str;
        }
        String[] array = str.split(separator);
        if (array.length < start) {
            return "";
        }
        if (array.length < end) {
            end = ((Number) array.length).longValue();
        }
        StringBuilder sb = new StringBuilder();
        for (long i = start - 1; i < end; i++) {
            sb.append(array[((Number) i).intValue()]).append(separator);
        }
        sb.deleteCharAt(sb.lastIndexOf(separator));
        return sb.toString();
    }


    public static void main (String[] args) {

        System.out.println("".equals(splitPart0("", "-", 2L, null)));
        //Apple apple = new Apple();
        //apple.setColor("NULL");
        //System.out.println(DATA_CENTER_FEATURE_NA_VALUES.contains(apple.color));
    }


}