package com.javacore.env;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/16
 * @Description:
 * @CodeReviewer:
 */
public class TestPath {
    public static void main(String[] args) throws FileNotFoundException {
        String path = System.getProperty("user.dir");
        String filePath = path + "/src/main/java/com/sqq/env9/环境交互.html";
        Scanner in = new Scanner(new File(filePath));
        System.out.println(path);
        System.out.println(filePath);
        while (in.hasNext()) {
            System.out.println(in.nextLine());
        }
    }
}
