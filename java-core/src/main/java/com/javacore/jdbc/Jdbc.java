package com.javacore.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class Jdbc {
    public String driver, url, user, pw;

    public void init() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\IDE_workspace\\idea_workspace\\git\\java_demo\\src\\main\\java\\com\\sqq\\jdbc13\\db.properties"));
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        pw = properties.getProperty("pw");
    }

    public Jdbc() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Jdbc jdbc = new Jdbc();
        System.out.println(jdbc);
    }

    @Override
    public String toString() {
        return "Jdbc{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
