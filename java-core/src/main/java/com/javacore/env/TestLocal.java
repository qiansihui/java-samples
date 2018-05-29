package com.javacore.env;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestLocal {
    static String path = "C:\\IDE_workspace\\idea_workspace\\git\\java_demo\\src\\main\\java\\com\\sqq\\env9\\msg_zh_CN.properties";

    public void store() throws IOException {
        Properties properties = new Properties();
        properties.put("msg", "你好");
        properties.store(new FileOutputStream("msg_zh_CN.properties"), "msg");
    }

    public static void main(String[] args) throws IOException {
//        new TestLocal().store();
        Locale locale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("msg", locale);
        System.out.println(resourceBundle.getString("msg"));

    }
}
