/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise.hash;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 *
 * @author booleanchoice
 * @version $Id: Hash.java, v 0.1 2019年05月10日 5:53 PM booleanchoice Exp $
 */
public class Hash {

    public static String getFileMD5String(File file) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        InputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024 * 1024 * 4];
        int numRead = 0;
        while ((numRead = fis.read(buffer)) > 0) {
            md5.update(buffer, 0, numRead);
        }
        fis.close();
        return toHexString(md5.digest());
    }

    private static String toHexString(final byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
            sb.append(hexChar[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    public final static char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
        'b', 'c', 'd', 'e', 'f'};


    public static void main(String args[]) throws Exception {

        System.out.println("BBBBBBBBBB".hashCode());
        System.out.println(hash("BBBBBBBBBB"));
    }

    private static int hash(String key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) & 0x7fffffff;
    }

}