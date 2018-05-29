package com.javacore.inout;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestFile {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println("相对路径:" + file.getPath() + "\t 绝对路径：" + file.getAbsolutePath());
        System.out.println("getAbsoluteFile:" + file.getAbsoluteFile());
        System.out.println("getParentFile:" + file.getParentFile());
        System.out.println("相对路径父路径:" + file.getParent());
        File javaDemo = file.getAbsoluteFile();
        System.out.println(javaDemo.getAbsolutePath());
        for (String name : javaDemo.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if (name.endsWith(".xml")) {
                    return true;
                }
                return false;
            }
        })) {
            System.out.println(name + "\t");
        }
        System.out.println("所有跟路径----");
        for (File root : File.listRoots()) {
            System.out.println(root);

        }
    }
}
