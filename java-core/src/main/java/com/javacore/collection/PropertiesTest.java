package com.javacore.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        String logPaht = "C:\\IDE_workspace\\idea_workspace\\git\\java_demo\\src\\main\\java\\com\\sqq\\collection7\\a.ini";
        Properties properties = new Properties();
        properties.setProperty("username", "sqq");
        properties.setProperty("password", "123");
        properties.store(new FileOutputStream(logPaht), "hello");
        Properties properties1 = new Properties();
        properties1.setProperty("gender", "male");
        properties1.load(new FileInputStream(logPaht));
        System.out.println(properties1);
    }
}
