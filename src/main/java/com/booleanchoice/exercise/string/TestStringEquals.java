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

    public static void main (String[] args) {
        Apple apple = new Apple();
        apple.setColor("NULL");
        System.out.println(DATA_CENTER_FEATURE_NA_VALUES.contains(apple.color));
    }


}