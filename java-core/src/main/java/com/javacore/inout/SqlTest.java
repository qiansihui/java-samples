package com.javacore.inout;

import java.io.FileNotFoundException;

/**
 * @Author: sunqianqian
 * @Date: 2015/7/9
 * @Description:
 * @CodeReviewer:
 */
public class SqlTest {
    public static String hexToStringGBK(String s) {
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        try {
            s = new String(baKeyword, "GBK");// UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
            return "";
        }
        return s;
    }

    public static void main(String[] args) throws FileNotFoundException {
        hexToStringGBK("0xe7");
    }
}
