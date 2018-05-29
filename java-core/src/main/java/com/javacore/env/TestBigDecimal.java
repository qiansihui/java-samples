package com.javacore.env;

import java.math.BigDecimal;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        System.out.println("0.05+0.01=" + (0.05 + 0.01));
        BigDecimal b1 = new BigDecimal("0.05");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(b1.add(b2));
    }
}
