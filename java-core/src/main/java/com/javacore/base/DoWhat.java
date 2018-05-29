package com.javacore.base;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

/**
 * Created by sunqq on 2015/5/23.
 */
public class DoWhat {
    private Frame frame = new Frame("干嘛呢?");
    private Button ok = new Button("start");
    private Label label = new Label("result");
    private TextArea textArea = new TextArea();
    private String[] todolist = {"eat", "sleep", "read"};

    public void init() {
        for (String s : todolist) {
            textArea.append("#" + s + "\n");
        }
        ok.addActionListener(new ToDo());
        frame.addWindowListener(new MyWindowListener());
        frame.add(textArea, BorderLayout.NORTH);
        frame.add(label);
        frame.add(ok, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DoWhat().init();
    }

    private class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private class ToDo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String[] todo = textArea.getText().split("#");
            Random random = new Random();
            int index = random.nextInt(todo.length);
            todo[0] = "hide item->play game";
            label.setText(index + "  random item:     " + todo[index]);
        }
    }
}
