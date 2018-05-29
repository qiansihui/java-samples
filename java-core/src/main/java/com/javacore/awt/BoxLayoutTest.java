package com.javacore.awt;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sunqq on 2015/5/22.
 */
public class BoxLayoutTest {
    private Frame f = new Frame("box layout");

    public void init() {
        f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));    //下面的组件将会垂直排列
        f.add(new Button("one"));
        f.add(new Button("two"));
        f.pack();
        f.setVisible(true);
    }

    private Box horizontal = Box.createHorizontalBox(); //horizontal gui
    private Box vertical = Box.createVerticalBox();//vertical gui

    public void boxInit() {
        horizontal.add(new Button("horizontal btn one"));
        horizontal.add(Box.createHorizontalGlue());     //横向可扩展间距
        horizontal.add(new Button("horizontal btn two"));
        horizontal.add(Box.createHorizontalStrut(10));  //横向不可扩展间距
        horizontal.add(new Button("horizontal btn three"));

        vertical.add(Box.createVerticalGlue());
        vertical.add(new Button("vertical btn one"));
        vertical.add(Box.createVerticalStrut(10));
        vertical.add(new Button("vertical btn two"));
        f.add(horizontal, BorderLayout.NORTH);
        f.add(vertical);
        f.pack();
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new BoxLayoutTest().boxInit();
    }
}
