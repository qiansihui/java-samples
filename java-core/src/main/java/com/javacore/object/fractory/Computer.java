package com.javacore.object.fractory;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class Computer {
    private Out out;

    public Computer(Out out) {
        this.out = out;
    }

    public void print(String[] strings) {
        out.print(strings);
    }


}
