package com.javacore.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sunqq on 2015/5/21.
 */
public class CardLayoutTest {
    Frame f = new Frame("card layout");
    String[] names = {"one", "two", "three", "four", "five"};
    Panel pl = new Panel();
    CardLayout c = new CardLayout();

    public void init() {
        pl.setLayout(c);
        for (int i = 0; i < names.length; i++) {
            pl.add("btn" + names[i], new Button(names[i]));
        }
        Panel p = new Panel();
        Button previous = new Button("prev");
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.previous(pl);
            }
        });
        Button next = new Button("next");
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.next(pl);
            }
        });
        Button first = new Button("first");
        first.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.first(pl);
            }
        });
        Button third = new Button("third");
        third.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.show(pl, "btnthree");
            }
        });
        p.add(previous);
        p.add(next);
        p.add(first);
        p.add(third);
        f.add(pl);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new CardLayoutTest().init();
    }
}
