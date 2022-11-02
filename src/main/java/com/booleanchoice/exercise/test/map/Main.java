/*
 * Ant Group
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.booleanchoice.exercise.test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author booleanchoice
 * @version Main.java, v 0.1 2022年10月28日 16:49 booleanchoice
 */
public class Main {

    public static void main(String[] args) {
        Map<String, Object> source = new HashMap<>();
        source.put("i", new Integer("123"));
        source.put("o", new Double("123.321"));

        Foo foo = new Foo();
        foo.setOrigin(source);

        Bar bar = new Bar();
        bar.setAnother(new HashMap<>(foo.getOrigin()));

        source.put("i", new Integer("321"));
    }

}