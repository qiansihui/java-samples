package com.javacore.collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TreeSetComparator {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet(new Comparator() {
            public int compare(Object o1, Object o2) {
                return (Integer) o2 - (Integer) o1;
            }
        });
        ts.add(2);
        ts.add(1);
        ts.add(3);
        System.out.println(ts);

    }
}
