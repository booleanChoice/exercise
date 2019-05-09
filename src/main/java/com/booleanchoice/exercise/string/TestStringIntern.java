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

    public static void main(String[] args) {

        String a = "11";

        String b = "22";

        String c = a + b;

        //c.intern();


        String e = a + new String("22");

        e.intern();

        String d = "11" + "22";

        String f = "1122";

        Integer haha = null;
        if (haha == 2) {
            System.out.println("1234");
        } else {
            System.out.println("2333");
        }

        System.out.println(f == e);

    }

}