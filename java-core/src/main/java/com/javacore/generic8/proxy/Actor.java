package com.javacore.generic8.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by root on 9/21/15.
 */
public class Actor {
    public void actMonkey(Class clazz, String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        System.out.println(" men act monkey to dancing");
        Method method = clazz.getDeclaredMethod("dance", String.class);
        method.invoke(clazz.newInstance(), "sun");
        System.out.println("dance finish ..");

    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Actor actor = new Actor();
        actor.actMonkey(Monkey.class, "sun");

    }
}
