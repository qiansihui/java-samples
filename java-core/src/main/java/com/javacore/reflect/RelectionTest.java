package com.javacore.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/16
 * @Description:
 * @CodeReviewer:
 */
public class RelectionTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter class name eg. java.util.Date");
        String name = in.next();

        try {
            Class clazz = Class.forName(name);
            Class superClazz = clazz.getSuperclass();
            //修饰符
            String modifiers = Modifier.toString(clazz.getModifiers());
            if (modifiers.length() > 0) {
                System.out.println(modifiers);
            }

            System.out.println("class " + name);
            if (superClazz != null && superClazz != Object.class) {
                System.out.println("extends " + superClazz.getName());
            } else {
                System.out.println("直接继承Object");
            }
            printConstructors(clazz);
            printMethods(clazz);
            printFields(clazz);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printConstructors(Class clazz) {
        System.out.println("打印构造器信息。。");
        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            String modifiers = Modifier.toString(clazz.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(clazz.getName() + "(");

            Class[] paramTypes = constructor.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class clazz) {
        System.out.println("打印方法信息。。。");
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            Class reType = method.getReturnType();
            String modifiers = Modifier.toString(clazz.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
                System.out.print(reType.getSimpleName() + " " + clazz.getSimpleName() + "(");
            }
            Class[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.printf(paramTypes[i].getSimpleName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class clazz) {
        System.out.println("打印属性信息。。。");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Class type = field.getType();
            String name = field.getName();
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0) {
                System.out.printf(modifiers + " ");
            }
            System.out.println(type.getSimpleName() + " " + name + ";");
        }
    }
}
