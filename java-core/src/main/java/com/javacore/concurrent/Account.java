package com.javacore.concurrent;

/**
 * @Author qianqian.sun
 * @Date 2018/3/11
 * 描述：
 */
class Account {
    public String name;

    public Account(String name) {
        this.name = name;
    }

    void transfer() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
