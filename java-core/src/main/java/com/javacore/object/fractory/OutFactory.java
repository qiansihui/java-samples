package com.javacore.object.fractory;

/**
 * @Author: sunqianqian
 * @Description: 简单工厂设计模式
 * 将所有生成Out对象的逻辑集中在工厂管理,所有使用Out对象的类只需与Out接口耦合
 * @CodeReviewer:
 */
public class OutFactory {
    public Out getPrinter() {
        return new BetterPrint();
    }

    public static void main(String[] args) {
        new Computer(new OutFactory().getPrinter()).print(new String[]{"hello", "world"});
    }
}
