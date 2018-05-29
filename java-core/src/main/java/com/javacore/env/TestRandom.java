package com.javacore.env;

import java.util.Random;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNum = random.nextInt(3);
            System.out.println(randomNum);
        }
    }
}
