package com.booleanchoice.exercise.test;

import java.text.DecimalFormat;

public class Main
{
    private static P p = new P(233);
    public static void main(String[] args) {
        Object value = 0.07650001d;
        DecimalFormat df = new DecimalFormat("#.######");
        String rt = df.format(value);
        System.out.println(rt);
        changeVal(p);
        p.out();
        p = changeRef(p);
        p.out();
        System.out.println(Integer.parseInt("1.234"));
    }

    private static void changeVal(P p) {
        Integer integer = new Integer(345);
        p.setA(integer);
    }

    private static P changeRef(P p) {
        p = new P(456);
        return p;
    }



}