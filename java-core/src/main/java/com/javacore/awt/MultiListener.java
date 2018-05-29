package com.javacore.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sunqq on 2015/5/22.
 */
public class MultiListener {
    private Frame frame = new Frame("multi listener");
    private TextArea textArea = new TextArea(6, 40);
    private Button b1 = new Button("one");
    private Button b2 = new Button("two");

    public void init() {
        FirstListener f1 = new FirstListener();
        b1.addActionListener(f1);
        b1.addActionListener(new SecondListener());

        b2.addActionListener(f1);
        frame.add(textArea);
        Panel p = new Panel();
        p.add(b1);
        p.add(b2);
        frame.add(p, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private class FirstListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textArea.append("第一个事件监听器触发,时间源是:" + e.getActionCommand() + "\n");
        }
    }

    private class SecondListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textArea.append("单机了" + e.getActionCommand() + "按钮+\n");
        }
    }

    public static void main(String[] args) {
        new MultiListener().init();
    }
}
