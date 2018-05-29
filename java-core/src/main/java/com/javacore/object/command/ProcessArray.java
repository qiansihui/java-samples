package com.javacore.object.command;

/**
 * @Author: sunqianqian
 * @Description: 命令模式
 * @CodeReviewer:
 */
public class ProcessArray {
    //使用传入的command接口执行处理行为,是行为和方法分离
    public void process(int[] target, Command command) {
        command.process(target);
    }
}
