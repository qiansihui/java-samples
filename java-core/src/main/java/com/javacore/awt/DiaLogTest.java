package com.javacore.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sunqq on 2015/5/22.
 */
public class DiaLogTest {
    Frame frame = new Frame();
    Dialog d1 = new Dialog(frame, "模式对话框", true);
    Dialog d2 = new Dialog(frame, "非模式对话框", false);
    Button b1 = new Button("打开模式对话框");
    Button b2 = new Button("打开非模式对话框");

    public void init() {
        d1.setBounds(20, 30, 300, 400);
        d2.setBounds(20, 30, 300, 400);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d2.setVisible(true);
            }
        });
        frame.add(b1);
        frame.add(b2, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new DiaLogTest().init();
    }
}
