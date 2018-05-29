package com.javacore.thread.threadlocal;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class MyTest extends Thread {
    private Account account;

    public MyTest(String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                //将账户名替换成当前线程名
                account.setName(getName());
            }
            System.out.println(account.getName() + "账户的i值：" + i);
        }
    }
}
