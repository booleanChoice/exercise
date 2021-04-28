package com.booleanchoice.exercise.test;

public class Main
{
    private static P p = new P(233);
    public static void main(String[] args) {
        changeVal(p);
        p.out();
        changeRef(p);
        p.out();
    }

    private static void changeVal(P p) {
        p.setA(345);
    }

    private static void changeRef(P p) {
        p = new P(456);
    }
}