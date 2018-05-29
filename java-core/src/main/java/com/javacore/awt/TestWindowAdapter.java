package com.javacore.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by sunqq on 2015/5/22.
 */
public class TestWindowAdapter {
    private Frame frame = new Frame("window adapter");
    private TextArea textArea = new TextArea(6, 40);

    public void init() {
        frame.addWindowListener(new MyListener());
        frame.add(textArea);
        frame.pack();
        frame.setVisible(true);

    }

    private class MyListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            textArea.append("关掉咯");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TestWindowAdapter().init();
    }
}
