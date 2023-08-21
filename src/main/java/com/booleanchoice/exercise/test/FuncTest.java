/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.test;

/**
 * @author booleanchoice
 * @version FuncUtil.java, v 0.1 2023年03月09日 10:59 booleanchoice
 */
public class FuncTest {

    public static Object test(Object... objects) {
        return objects.length;
    }

    public static void main(String[] args) {
        long a = 1;
        long b = 2;
        long c = 3;
        System.out.println(test(a, b, c));

    }

}