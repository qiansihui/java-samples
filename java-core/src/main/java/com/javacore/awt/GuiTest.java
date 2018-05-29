package com.javacore.awt;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sunqq on 2015/5/22.
 */
public class GuiTest {
    Frame f = new Frame("gui");
    Button ok = new Button("OK");
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox male = new Checkbox("male", cbg, true);    //单选框,放入组,是否选中
    Checkbox female = new Checkbox("female", cbg, false);
    Checkbox married = new Checkbox("marry?", false);
    Choice colorChooser = new Choice(); //下拉列表
    List colorList = new List(6, true);//列表选择框

    public void init() {
        colorChooser.add("red");
        colorChooser.add("blue");
        colorList.add("red");
        colorList.add("black");

        Panel bottom = new Panel();
        bottom.add(ok);
        f.add(bottom, BorderLayout.SOUTH);
        Panel checkPanel = new Panel();
        checkPanel.add(colorChooser);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);
        Box topLeft = Box.createVerticalBox();
        topLeft.add(checkPanel);
        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);
        f.add(top);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiTest().init();

    }
}
