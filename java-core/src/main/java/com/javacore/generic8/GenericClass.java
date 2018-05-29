package com.javacore.generic8;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class GenericClass<T> {
    private T info;

    public GenericClass(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public static void main(String[] args) {
        GenericClass<String> g1 = new GenericClass<String>("泛型");
        System.out.println(g1.getInfo());
        GenericClass<Double> g2 = new GenericClass<Double>(3.2);
        System.out.println(g2.getInfo());

    }
}
