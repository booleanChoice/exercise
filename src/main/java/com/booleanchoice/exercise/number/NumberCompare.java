package com.booleanchoice.exercise.number;

import java.util.*;

public class NumberCompare {
    static Long a = 999999999999999999L;
    static Double b = 3.1415926;
    static Integer c = 999;
    static Short d = 9999;
    static Object e = true;

    public static void main(String[] args) {

        System.out.println(a.doubleValue() > b);
        System.out.println(c.doubleValue() > d.doubleValue());
        if (e instanceof Boolean && (Boolean)e) {
            System.out.println("123");
        }
        System.out.println("".length());

        Object s = "12333";
        String v = s.toString();
        v = v.substring(v.length() - 2, v.length());
        System.out.println(v);
    }
}
