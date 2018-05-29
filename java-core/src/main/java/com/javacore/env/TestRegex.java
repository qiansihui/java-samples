package com.javacore.env;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestRegex {

    public static void main(String[] args) {
        String date = "现在时间是: 2015年6月7日 09:40:26";
        System.out.println(date.replaceFirst("[^u4E00-u9FA5]+", "哦"));
        System.out.println(Pattern.matches(".*\\d+.*", date));
        Matcher matcher = Pattern.compile("[^u4E00-u9FA5]+:").matcher(date);
        while (matcher.find()) {
            System.out.println("tip is:" + matcher.group());
        }
        Matcher year = Pattern.compile("\\d+年").matcher(date);
        while (year.find()) {
            System.out.println("year is:" + year.group());
        }
        Matcher time = Pattern.compile("\\d+:").matcher(date);

        while (time.find()) {
            System.out.println("time is :" + time.group());
        }

        System.out.println(Pattern.matches("\\d{18,50}", "123451234512345123"));
    }
}
