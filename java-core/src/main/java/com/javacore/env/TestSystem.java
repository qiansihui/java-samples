package com.javacore.env;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestSystem {
    public static void main(String[] args) throws IOException {
        Map<String, String> env = System.getenv();
        for (String name : env.keySet()) {
            System.out.println(name + " ----> " + env.get(name));
        }
        Properties properties = System.getProperties();
        properties.store(new FileOutputStream("sys.txt"), "sys env");


    }
}
