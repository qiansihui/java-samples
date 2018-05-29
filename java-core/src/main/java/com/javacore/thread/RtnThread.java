package com.javacore.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class RtnThread implements Callable<Integer> {

    //实现call方法，作为线程执行体
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "循环变量i的值:" + i);
        }
        //call()方法可以有返回值
        return i;
    }

    public static void main(String[] args) {
        //创建callable对象
        RtnThread rt = new RtnThread();
        //使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<Integer>(rt);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "循环变量i的值：" + i);
            if (i == 20) {
                //以Callable对象来创建、启动线程
                new Thread(task, "有返回值的线程").start();
            }
        }
        try {
            //获取线程返回值
            System.out.println("子线程的返回值：" + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
