package com.booleanchoice.exercise.test;

public class Main
{
    private static P p = new P(233);
    public static void main(String[] args) {
        changeVal(p);
        p.out();
        p = changeRef(p);
        p.out();
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