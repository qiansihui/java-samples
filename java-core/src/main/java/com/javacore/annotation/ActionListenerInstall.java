package com.javacore.annotation;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class ActionListenerInstall {

    public static void processAnnotation(Object obj) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            ActionListenerFor a = field.getAnnotation(ActionListenerFor.class);
            if (a != null && field.get(obj) instanceof AbstractButton) {
                Class listenerClazz = Class.forName("com.sqq.annotation14." + a.listen());
                ActionListener a1 = (ActionListener) listenerClazz.newInstance();
                AbstractButton b = (AbstractButton) field.get(obj);
                b.addActionListener(a1);
            }
        }

    }
}
