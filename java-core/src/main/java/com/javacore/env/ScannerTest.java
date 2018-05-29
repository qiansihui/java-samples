package com.javacore.env;

import java.util.Scanner;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("write : ");
        while (in.hasNext() && !in.next().equals("exit")) {
            System.out.println("your write: " + in.nextLine());
        }
    }


}
