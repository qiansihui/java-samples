package com.javacore.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author qianqian.sun
 * @Date 2018/1/4
 * 描述：
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (null == is) return super.loadClass(name);
                try {
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = classLoader.loadClass("com.javacore.jvm.ClassLoaderTest");
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);
        System.out.println(ClassLoaderTest.class);
    }
}
