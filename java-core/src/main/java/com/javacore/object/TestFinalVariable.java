package com.javacore.object;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestFinalVariable {
    //定义成员变量时指定初始值
    final int i = 8;
    final String sb;     //可在普通初始化块和构造器中指定值
    final String bb;
    final static String nb; //可在静态初始化块中指定,构造器中不行

    {
        sb = "xxx";
    }

    static {
        nb = "yyy";
    }

    public TestFinalVariable(String bb) {
        this.bb = bb;
    }
}
