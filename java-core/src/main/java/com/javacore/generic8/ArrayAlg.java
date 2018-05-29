package com.javacore.generic8;

import java.lang.reflect.Array;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/25
 * @Description:
 * @CodeReviewer:
 */
class ArrayAlg {
    public static <T extends Comparable> Pair<T> minMax(T[] ss) {
        if (ss == null || ss.length == 0) {
            return null;
        }
        T min = ss[0];
        T max = ss[0];
        for (int i = 0; i < ss.length; i++) {
            if (min.compareTo(ss[i]) > 0) {
                min = ss[i];
            }
            if (max.compareTo(ss[i]) < 0) {
                max = ss[i];
            }
        }
        return new Pair<T>(min, max);
    }

    public static <T> T middle(T[] a) {
        return a[a.length / 2];
    }

    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
        }
        return min;
    }

    public static <T> T[] minMax(T[] a) {
        T[] mm = (T[]) Array.newInstance(a.getClass().getComponentType(), 2);
        return mm;
    }
}
