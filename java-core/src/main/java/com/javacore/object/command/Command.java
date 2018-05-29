package com.javacore.object.command;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public interface Command {
    //接口中定义方法用于封装"处理行为"
    void process(int[] target);
}
