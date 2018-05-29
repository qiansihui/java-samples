package com.javacore.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sunqq on 2015/5/22.
 */
public class FileDialogTest {
    Frame frame = new Frame("file Dialog");
    FileDialog d1 = new FileDialog(frame, "choose file open", FileDialog.LOAD);
    FileDialog d2 = new FileDialog(frame, "save file", FileDialog.SAVE);
    Button b1 = new Button("open");
    Button b2 = new Button("save");

    public void init() {
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
                System.out.println(d1.getDirectory() + d1.getFile());
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d2.setVisible(true);
                System.out.println(d2.getDirectory() + d2.getFile());
            }
        });
        frame.add(b1);
        frame.add(b2, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FileDialogTest().init();
    }
}
