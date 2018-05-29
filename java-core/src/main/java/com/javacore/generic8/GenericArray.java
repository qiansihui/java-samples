package com.javacore.generic8;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class GenericArray {
    public static void main(String[] args) {
        List<?>[] lsa = new ArrayList<?>[10];
        Object[] oa = lsa;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li;
        String s = (String) lsa[1].get(0);
    }
}
