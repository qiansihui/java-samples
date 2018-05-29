package com.javacore.object.fractory;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class BetterPrint implements Out {

    public void print(String[] strings) {
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
