/*
 * Ant Group
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.booleanchoice.exercise.test.map;

import lombok.Data;

import java.util.Map;

/**
 * @author booleanchoice
 * @version Foo.java, v 0.1 2022年10月28日 16:48 booleanchoice
 */
@Data
public class Foo {

    Map<String, Object> origin;

    public Map<String, Object> getOrigin() {
        return origin;
    }

    public void setOrigin(Map<String, Object> origin) {
        this.origin = origin;
    }
}