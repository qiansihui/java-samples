package com.javacore.thread;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class DaemonThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(getName() + "---" + i);
        }
    }

    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();
        //将线程设置为后台线程
        daemonThread.setDaemon(true);
        daemonThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "===" + i);
        }
        //mian线程结束 后台线程也结束
    }
}
