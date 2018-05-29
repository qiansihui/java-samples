package com.javacore.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qianqian.sun
 * @Date 2018/2/7
 * 描述：-Xms100M -Xmx100 -XX:+PrintGCDetails
 */
public class JConsole {
    static class OOMObject {
        private byte[] place = new byte[64 * 1024]; // 64kb
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
