package com.javacore.generic8;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class Apple<T extends Number> {
    T size;

    public Apple(T size) {
        this.size = size;
    }

    public T getSize() {
        return size;
    }

    public void setSize(T size) {
        this.size = size;
    }

    public static void main(String[] args) {
        Apple<Integer> a = new Apple<Integer>(6);
        Integer as = a.getSize();
        Apple b = a;
        Number bs = b.getSize();
        // b type of size is easier
//        Integer bs2 = b.getSize();
    }
}
