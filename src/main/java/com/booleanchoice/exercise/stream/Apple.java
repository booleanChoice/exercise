/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise.stream;

/**
 *
 * @author booleanchoice
 * @version $Id: Apple.java, v 0.1 2019年01月09日 3:47 PM booleanchoice Exp $
 */
public class Apple {

    private int id;

    private String color;

    private AppleTag tag;

    public Apple(int id, String color) {
        this.id = id;
        this.color = color;
        tag = new AppleTag();
        tag.setTagName("hahah");
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AppleTag getTag() {
        return tag;
    }

    public void setTag(AppleTag tag) {
        this.tag = tag;
    }

}