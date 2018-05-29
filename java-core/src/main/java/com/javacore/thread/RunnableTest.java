package com.javacore.thread;

/**
 * @Author: sunqianqian
 * @Description: 总算看到多线程并发执行的情形了<br>
 * 两个子线程共享变量i
 * 优点：可继承其他类
 * 多线程共享同一个target对象
 * 缺点：编程稍微复杂
 * @CodeReviewer:
 */
public class RunnableTest implements Runnable {

    private int i = 0;

    public void run() {
        System.out.println("通过继承Runnable接口实现多线程");
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "+++" + i);
            if (i == 20) {
                RunnableTest runnableTest = new RunnableTest();
                new Thread(runnableTest, "子线程1").start();
                new Thread(runnableTest, "子线程2").start();
            }
        }
    }
}
