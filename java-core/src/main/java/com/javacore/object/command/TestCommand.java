package com.javacore.object.command;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestCommand {
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] target = {1, 3, 5, 6};
        pa.process(target, new PrintCommand());
        pa.process(target, new AddCommand());
    }
}
