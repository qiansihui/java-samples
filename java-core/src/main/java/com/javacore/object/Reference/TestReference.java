package com.javacore.object.Reference;

import java.lang.ref.WeakReference;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestReference {
    public static void main(String[] args) {
        String s = new String("hello");
        WeakReference weakReference = new WeakReference(s);
        s = null;
        System.out.println(weakReference.get());
        System.gc();
        System.runFinalization();
        System.out.println(weakReference.get());
    }
}
