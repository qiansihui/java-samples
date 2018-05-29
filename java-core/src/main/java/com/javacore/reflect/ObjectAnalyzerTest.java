package com.javacore.reflect;

import java.util.ArrayList;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/16
 * @Description:
 * @CodeReviewer:
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            squares.add(i);
            System.out.println(new ObjectAnalyzer().toString(squares));
        }
    }
}
