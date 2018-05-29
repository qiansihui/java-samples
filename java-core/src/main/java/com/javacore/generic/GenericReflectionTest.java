package com.javacore.generic;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/25
 * @Description:
 * @CodeReviewer:
 */
public class GenericReflectionTest {
    public static void main(String[] args) {
        String name = "java.util.Collections";
/*        Scanner scanner = new Scanner(System.in);
        System.out.println("enter class name eg java.util.Collections :");
        name = scanner.next();*/

        try {
            Class cl = Class.forName(name);
            printClass(cl);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void printClass(Class cl) {
        System.out.println(cl);
        printTypes(cl.getTypeParameters());
        Type type = cl.getGenericSuperclass();
        if (type != null) {
            System.out.println(" extends");
            printType(type);
        }
    }

    private static void printType(Type type) {
        if (type instanceof Class) {
            Class c = (Class) type;
            System.out.println(c.getName());
        }
    }

    private static void printTypes(TypeVariable[] typeParameters) {
        for (int i = 0; i < typeParameters.length; i++) {
            System.out.println(typeParameters[i]);
        }
    }
}
