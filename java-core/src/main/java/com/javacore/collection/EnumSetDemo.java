package com.javacore.collection;

import org.junit.Test;

import java.util.*;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
enum Season {
    SPRING, SUMMER, FALL, WINTER
}

public class EnumSetDemo {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(Season.values()));
        try {
            Season season = Season.valueOf("spring");
        } catch (IllegalArgumentException e) {
            System.out.println("转换错误");
        }
    }

    @Test
    public void test3() {
        List<Auth> list = new ArrayList<Auth>();
        Auth auth = new Auth();
        auth.setId("1");
        list.add(auth);
        list.add(auth);
        System.out.println(list);
    }

    @Test
    public void test4() {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(map.containsKey("1"));
    }

    private class Auth {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
