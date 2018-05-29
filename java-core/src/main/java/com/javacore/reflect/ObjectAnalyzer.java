package com.javacore.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/16
 * @Description:
 * @CodeReviewer:
 */
public class ObjectAnalyzer {
    public String toString(Object object) {
        if (object == null) {
            return "null";
        }
        if (visited.contains(object)) {
            return "...";
        }
        visited.add(object);
        Class clazz = object.getClass();
        if (clazz == String.class) {
            return (String) object;
        }
        if (clazz.isArray()) {
            String r = clazz.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(object); i++) {
                if (i > 0) {
                    r += ",";
                }
                Object val = Array.get(object, i);
                if (clazz.getComponentType().isPrimitive()) {
                    r += val;
                } else {
                    r += toString(val);
                }
            }
            return r + "}";
        }

        String r = clazz.getName();
        do {
            r += "[";
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    if (!r.endsWith("[")) {
                        r += ",";
                    }
                    r += field.getName() + "=";
                    try {
                        Class t = field.getType();
                        Object val = field.get(object);
                        if (t.isPrimitive()) {
                            r += val;
                        } else {
                            r += toString(val);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            clazz = clazz.getSuperclass();
        } while (clazz != null);
        return r;
    }

    private ArrayList<Object> visited = new ArrayList<Object>();
}
