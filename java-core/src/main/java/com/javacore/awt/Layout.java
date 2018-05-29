package com.javacore.awt;

import java.awt.*;

/**
 * Created by sunqq on 2015/5/21.
 * 布局管理器
 */
public class Layout {
    public static void main(String[] args) {
        gridBagLayout();
    }

    //流水布局
    public static void flowLayout() {
        Frame f = new Frame("flow layout");
        f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        for (int i = 0; i < 10; i++) {
            f.add(new Button("but" + i));
        }
        f.pack();
        f.setVisible(true);
    }

    //方位布局
    public static void borderLayout() {
        Frame f = new Frame("border layout");
        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("south"), BorderLayout.SOUTH);
        f.add(new Button("north"), BorderLayout.NORTH);
        f.add(new Button("east"), BorderLayout.EAST);
        Panel p = new Panel();
        p.add(new TextField(20));
        p.add(new Button("search"));
        f.add(p);
        f.pack();
        f.setVisible(true);
    }

    //栅格布局
    public static void gridLayout() {
        Frame f = new Frame("cacuta");
        Panel p = new Panel();
        p.add(new TextField(30));
        f.add(p, BorderLayout.NORTH);
        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(3, 5, 4, 4));
        String[] name = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "."};
        for (int i = 0; i < name.length; i++) {
            p2.add(new Button(name[i]));
        }
        f.add(p2);
        f.pack();
        f.setVisible(true);
    }

    static Frame f = new Frame("gridBagLayout");
    static GridBagLayout gb = new GridBagLayout();
    static GridBagConstraints gbc = new GridBagConstraints();
    static Button[] bs = new Button[10];

    //栅格包布局
    public static void gridBagLayout() {
        f.setLayout(gb);
        for (int i = 0; i < bs.length; i++) {
            bs[i] = new Button("button" + i);
        }
        gbc.fill = GridBagConstraints.BOTH; //所有组件都可以横向,纵向扩大
        gbc.weightx = 1;        //横向扩大设置权重
        gbc.weighty = 1;        //纵向扩大设置权重
        addButton(bs[0]);
        gbc.weightx = 2;        //横向扩大设置权重
        addButton(bs[1]);
        addButton(bs[2]);
        gbc.gridwidth = GridBagConstraints.REMAINDER;   //控制的组件将会成为最后一个元素
        addButton(bs[3]);
        gbc.weightx = 0;
        addButton(bs[4]);
        gbc.gridwidth = 3;  //横跨两个网格
        addButton(bs[5]);
        gbc.gridwidth = 1;  //横跨一个网格
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addButton(bs[6]);
        gbc.gridwidth = 1;
        gbc.gridheight = 2;  //纵跨两个网格
        gbc.weighty = 1;
        addButton(bs[7]);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        addButton(bs[8]);
        addButton(bs[9]);
        f.pack();
        f.setVisible(true);
    }

    private static void addButton(Button button) {
        gb.setConstraints(button, gbc); //设置组件受gbc内容对象控制
        f.add(button);
    }

}
