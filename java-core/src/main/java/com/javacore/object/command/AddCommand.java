package com.javacore.object.command;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class AddCommand implements Command {
    public void process(int[] target) {
        int sum = 0;
        for (int i : target) {
            sum += i;
        }
        System.out.println(sum);
    }
}
