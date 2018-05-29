package com.javacore.generic8;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestGenericMethod {
    static <T> void array2Collection(T[] a, Collection<T> collection) {
        for (T o : a) {
            collection.add(o);
        }
    }

    public static void main(String[] args) {
        Object[] oa = new Object[100];
        Collection<Object> oc = new ArrayList<Object>();
        array2Collection(oa, oc);
        System.out.println(oc);
    }
}
