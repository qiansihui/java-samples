package com.javacore.object.command;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class PrintCommand implements Command {
    public void process(int[] target) {
        for (int i : target) {
            System.out.print(i);
        }
    }
}
