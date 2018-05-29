package com.javacore.generic8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class GenericSuper {
    public static <T> T copy(java.util.Collection<? super T> dest, Collection<T> src) {
        T last = null;
        for (T els : src) {
            last = els;
            dest.add(els);
        }
        return last;
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<Number>();
        List<Integer> integerList = new ArrayList<Integer>();
        Integer last = copy(numberList, integerList);
    }
}
