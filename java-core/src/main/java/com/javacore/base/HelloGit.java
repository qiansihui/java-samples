package com.javacore.base;

import java.awt.*;

/**
 * Created by sunqq on 2015/5/21.
 */
public class HelloGit {
    public static void main(String[] args) {
        String id = "[TZ1001034]卡信息或银行预留手机号有误，请您联系银行核实[44e7d5bf97924000bc26ccc66b3e1e74]";
        System.out.println(id.replaceAll("\\[\\w*\\]", ""));
    }

    public void frame() {
        Frame frame = new Frame("hello");
        frame.setBounds(30, 30, 250, 200);
        frame.setVisible(true);
    }

    public static void panel() {
        Frame frame = new Frame("panel");
        Panel panel = new Panel();
        panel.add(new TextField(20));
        panel.add(new Button("click"));
        frame.add(panel);
        frame.setBounds(100, 100, 250, 120);
        frame.setVisible(true);
    }

    public static void scrollPane() {
        Frame frame = new Frame("scroll pane");
        ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        scrollPane.add(new TextField(20));
        scrollPane.add(new Button("click"));
        frame.add(scrollPane);
        frame.setBounds(50, 50, 250, 120);
        frame.setVisible(true);
    }

}
