package com.javacore.concurrent;

/**
 * @Author qianqian.sun
 * @Date 2018/3/6
 * 描述：
 */
public class ClassPublic {

    public static void main(String[] args) {
        ClassPublic cp = new ClassPublic();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    System.out.println("interrupt() 将BLOCKED状态中断，恢复为RUNNABLE");
                    Thread.currentThread().interrupt();//恢复中断状态
                }
                System.out.println("执行完毕");
            }
        });
        thread.start();
        thread.interrupt();
    }
}
