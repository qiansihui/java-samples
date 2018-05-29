package com.javacore.generic8;

import java.io.File;
import java.util.ArrayList;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class GenericTest {
    public static void main(String[] args) {
        ArrayList<File> list = new ArrayList<File>();
        list.add(new File("/home"));
        File a = (File) list.get(0);

    }
}
