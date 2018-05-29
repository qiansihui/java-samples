package com.javacore.annotation;

import java.lang.annotation.Annotation;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestMyTag {
    @MyTag(name = "sqq", age = 18)
    public void test() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Annotation[] array = TestMyTag.class.getMethod("test").getAnnotations();
        for (Annotation annotation : array) {
            System.out.println("name:" + ((MyTag) annotation).name() + "\tage:" + ((MyTag) annotation).age());
        }
    }


}
