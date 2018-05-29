package com.javacore.Internet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class URLDecoderTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "你是这个世界上无与伦比的美丽";
        String urlString = com.sun.deploy.net.URLEncoder.encode(str, "UTF-8");
        System.out.println(urlString);
        System.out.println(URLEncoder.encode(str, "UTF-8"));
        System.out.println("解密后：" + URLDecoder.decode("%E4%BD%A0%E6%98%AF%E8%BF%99%E4%B8%AA%E4%B8%96%E7%95%8C%E4%B8%8A%E6%97%A0%E4%B8%8E%E4%BC%A6%E6%AF%94%E7%9A%84%E7%BE%8E%E4%B8%BD", "UTF-8"));

    }
}
