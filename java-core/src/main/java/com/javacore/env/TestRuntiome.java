package com.javacore.env;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestRuntiome {
    public static void main(String[] args) {
        final Runtime runtime = Runtime.getRuntime();
        Frame frame = new Frame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        TextArea textArea = new TextArea();
        textArea.append("系统参数");
        textArea.append("处理器数量:" + runtime.availableProcessors() + "\n");
        textArea.append("空闲内存数;" + runtime.freeMemory() + "\n");
        textArea.append("总内存数:" + runtime.totalMemory() + "\n");
        textArea.append("可用最大内存:" + runtime.maxMemory() + "\n");
        Button button = new Button("paint");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    runtime.exec("notepad.exe");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        frame.add(textArea);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }
}
