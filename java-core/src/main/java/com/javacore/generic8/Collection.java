package com.javacore.generic8;

import java.util.List;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public interface Collection<E> {
    //类型通配符
    void method1(List<?> list);

    void method2(List<? extends E> list);

    //泛型形式
    <T> boolean containsAll(Collection<T> c);

    <T extends E> boolean addAll(Collection<E> c);
}
