package com.javacore.Internet.demo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取糗事百科段子内容
 */
public class QiuShiBaiKe {

    public String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlName = url + "?" + param;
            URL realUrl = new URL(urlName);
            URLConnection con = realUrl.openConnection();

            con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            con.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
            con.setRequestProperty("Connection", "keep-alive");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.124 Safari/537.36");

            con.connect();

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        QiuShiBaiKe qiuShiBaiKe = new QiuShiBaiKe();
        //糗事百科地址
        String url = "http://www.qiushibaike.com/text/page/";
        String html = "";
        for (int i = 1; i <= 10; i++) {
            html += qiuShiBaiKe.sendGet(url + i, null);
        }
        System.out.println(html);
        FileWriter fw = new FileWriter("hello.txt");
        Matcher jokeMatcher = Pattern.compile("<div class=\"content\">[^/]*</div>?").matcher(html);
        fw.write("************** 把快乐建立在别人的痛苦上：糗事百科 *************\n");
        while (jokeMatcher.find()) {
            String one = jokeMatcher.group();
            String joke = one.replace("<div class=\"content\">", "").replace("</div>", "");
            fw.write(joke + "\n");
            fw.write("========== 华丽的分割线 ==========\n");
        }
    }
}
