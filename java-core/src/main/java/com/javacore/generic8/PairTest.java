package com.javacore.generic8;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/25
 * @Description:
 * @CodeReviewer:
 */
public class PairTest {
    public static void main(String[] args) {
        String[] ss = new String[]{"11", "22", "33", "bb", "aa"};
        Pair<String> mm = ArrayAlg.minMax(ss);
        System.out.println("min is " + mm.getFirst());
        System.out.println("max is " + mm.getSecond());
        Pair<String> nn = new Pair<String>("ss", "ss");
    }
}

