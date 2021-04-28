/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise.string;

/**
 *
 * @author booleanchoice
 * @version $Id: TestStringIntern.java, v 0.1 2019年03月04日 5:49 PM booleanchoice Exp $
 */
public class TestStringIntern {

    private static final String CONNECTOR = ".";

    public static void main(String[] args) {

        String a = "11";

        String b = "22";

        String c = a + b;

        //c.intern();


        String e = a + new String("22");

        e.intern();

        String d = "11" + "22";

        String f = "1122";


        System.out.println(f == e);

        String haha = "a".concat(CONNECTOR).concat("b");
        String[] xixi = haha.split("\\" + CONNECTOR);
        System.out.println(xixi[1]);


        String decisionId= "bcd__dcsBean_abc_dcsBean";
        String decisionBeanSuffix = "_dcsBean";

        decisionId = decisionId.substring(0, decisionId.lastIndexOf(decisionBeanSuffix));

        System.out.println("decisionId :" + decisionId);


        Object test = null;

        String aaa = (String) test;
        System.out.println(aaa);
        if (!(test instanceof String)) {
            System.out.println(test);
        }

    }

}