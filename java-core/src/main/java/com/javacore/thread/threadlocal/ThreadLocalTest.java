package com.javacore.thread.threadlocal;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        //启动两条线程，共享同一个account
        Account at = new Account("初始名");
        /*虽然两线程共享同一个账户，但由于账户名是ThreadLocal类型
        两条线程将导致由同一个Account,但有两个账户名副本，
        所以i==6之后，两线程访问同一个账户看到不同账户名*/
        new MyTest("线程甲", at).start();
        new MyTest("线程乙", at).start();

    }
}
