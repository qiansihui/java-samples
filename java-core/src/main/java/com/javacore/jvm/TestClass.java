package com.javacore.jvm;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @Author qianqian.sun
 * @Date 2018/1/4
 * 描述：
 */
public class TestClass {

    private int m;

    private int inc() {
        return m + 1;
    }

    public static void main(String[] args) {
        NumberFormat usFormat = NumberFormat.getIntegerInstance();
        System.out.println(usFormat.format(new BigDecimal("200000")));
        ;

    }
}
