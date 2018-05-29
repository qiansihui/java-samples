package com.javacore.thread;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestDraw {
    //一次存款后跟一次取款
    public static void main(String[] args) {
        Account account = new Account("123", 0);
        new DrawThread("取款者", account, 800).start();
        new DepositThread("存款甲", account, 800).start();
        new DepositThread("存款乙", account, 800).start();
        new DepositThread("存款丙", account, 800).start();
    }
}
