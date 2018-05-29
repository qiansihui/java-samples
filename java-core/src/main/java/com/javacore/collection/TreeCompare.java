package com.javacore.collection;

import java.util.TreeSet;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TreeCompare {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new A(1));
        treeSet.add(new A(2));
        System.out.println(treeSet);
    }
}

class A implements Comparable {
    private int i;

    public A(int i) {
        this.i = i;
    }

    public int compareTo(Object o) {
        return ((A) o).getI() - this.i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                '}';
    }
}
