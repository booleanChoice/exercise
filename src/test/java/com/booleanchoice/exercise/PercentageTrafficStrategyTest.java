/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author booleanchoice
 * @version $Id: PercentageTrafficStrategyTest.java, v 0.1 2019年01月22日 4:25 PM booleanchoice Exp $
 */
public class PercentageTrafficStrategyTest {

    private int ERROR = -1;

    @Test
    public void getLongWeightTest() {
        int a = 1;
        int b = 2;
        assert a > b;
        int rs = getLongWeight("8A2", FlowTailTypeEnum.SECOND_THIRD);
        Assert.assertEquals(rs, 80);
    }

    private int getLongWeight(Object value, FlowTailTypeEnum tailType) {
        if (null == tailType || FlowTailTypeEnum.DISABLE.equals(tailType)) {
            return ERROR;
        }
        try {
            String val = String.valueOf(value);
            switch (tailType) {
                // 倒数2-3位
                case SECOND_THIRD:
                    if (val.length() > 2) {
                        val = val.substring(val.length() - 3, val.length() - 1);
                        // 如果倒数第二位不是数字，针对影子账号的情况做转换
                        Character secondTail = val.toCharArray()[1];
                        if (!isNumeric(secondTail.toString()) && LETTER_DIGIT.containsKey(secondTail.toString())) {
                            Character thirdTail = val.toCharArray()[0];
                            val = thirdTail.toString().concat(LETTER_DIGIT.get(secondTail.toString()));
                        }
                        return Integer.parseInt(val);
                    }
                    return ERROR;
                // 倒数3-4位
                case THIRD_FOURTH:
                    if (val.length() > 3) {
                        val = val.substring(val.length() - 4, val.length() - 2);
                        return Integer.parseInt(val);
                    }
                    return ERROR;
                // 倒数4-5位
                case FOURTH_FIFTH:
                    if (val.length() > 4) {
                        val = val.substring(val.length() - 5, val.length() - 3);
                        return Integer.parseInt(val);
                    }
                    return ERROR;
                // 倒数5-6位
                case FIFTH_SIXTH:
                    if (val.length() > 5) {
                        val = val.substring(val.length() - 6, val.length() - 4);
                        return Integer.parseInt(val);
                    }
                    return ERROR;
                // 若都不匹配，默认用倒数1-2位的策略
                default:
                    return getLongWeightByTwoNum(val);
            }
        } catch (Exception e) {

            // 异常情况，认为参数非法
            return ERROR;
        }
    }

    private int getLongWeightByTwoNum(String val) {
        try {

            return (int) (Long.valueOf(val) % 100L);
        } catch (Exception e) {
            try {
                Long longVal = Long.valueOf(processAlipayShadowId(val));
                return (int) (longVal % 100L);
            } catch (Exception ex) {

            }
            return ERROR;
        }
    }

    private static final Map<String, String> LETTER_DIGIT = new HashMap<String, String>();

    static {
        LETTER_DIGIT.put("A", "0");
        LETTER_DIGIT.put("B", "1");
        LETTER_DIGIT.put("C", "2");
        LETTER_DIGIT.put("D", "3");
        LETTER_DIGIT.put("E", "4");
        LETTER_DIGIT.put("F", "5");
        LETTER_DIGIT.put("G", "6");
        LETTER_DIGIT.put("H", "7");
        LETTER_DIGIT.put("I", "8");
        LETTER_DIGIT.put("J", "9");
    }

    private String processAlipayShadowId(String alipayId) {
        if (alipayId.length() >= 3) {
            String shadow = alipayId.substring(alipayId.length() - 2, alipayId.length() - 1);
            if (!isNumeric(shadow)) {
                alipayId = LETTER_DIGIT.get(shadow).concat(alipayId.substring(alipayId.length() - 1));
            } else {
                alipayId = alipayId.substring(alipayId.length() - 2);
            }
        }
        return alipayId;
    }

    public static boolean isNumeric(CharSequence cs) {
        if (StringUtils.isEmpty(cs)) {
            return false;
        } else {
            int sz = cs.length();

            for(int i = 0; i < sz; ++i) {
                if (!Character.isDigit(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

}