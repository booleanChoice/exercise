/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise;

/**
 *
 * @author booleanchoice
 * @version $Id: FlowTailTypeEnum.java, v 0.1 2019年01月10日 8:59 PM booleanchoice Exp $
 */
public enum FlowTailTypeEnum {

    FIRST_SECOND(12, "倒数第1位和倒数第2位"),
    SECOND_THIRD(23, "倒数第2位和倒数第3位"),
    THIRD_FOURTH(34, "倒数第3位和倒数第4位"),
    FOURTH_FIFTH(45, "倒数第4位和倒数第5位"),
    FIFTH_SIXTH(56, "倒数第5位和倒数第6位"),
    DISABLE(-1, "无效的尾号类型")
    ;

    /**
     * 获取数值
     */
    public Integer getValue() {
        return value;
    }

    /**
     * 获取含义
     */
    public String getMeaning() {
        return meaning;
    }

    /**
     * 查询数值对应的枚举含义
     *
     * @param type 数值
     */
    public static String findMeaning(final Integer type) {
        if (type == null) {
            return "";
        }
        for (FlowTailTypeEnum flowTailTypeEnumEnum : FlowTailTypeEnum.values()) {
            if (flowTailTypeEnumEnum.getValue().equals(type)) {
                return flowTailTypeEnumEnum.meaning;
            }
        }
        return "";
    }

    /**
     * 查询含义对应的枚举
     *
     * @param type 数值
     */
    public static FlowTailTypeEnum findEnum(final Integer type) {
        for (FlowTailTypeEnum flowTailTypeEnumEnum : FlowTailTypeEnum.values()) {
            if (flowTailTypeEnumEnum.getValue().equals(type)) {
                return flowTailTypeEnumEnum;
            }
        }
        return null;
    }

    /**
     * 构造函数
     *
     * @param value   数值
     * @param meaning 含义
     */
    FlowTailTypeEnum(final int value, final String meaning) {
        this.value = value;
        this.meaning = meaning;
    }

    private final int value;

    private final String meaning;

}