package com.javacore.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sunqq on 2015/5/22.
 */
public class EventQs {
    private Frame frame = new Frame("event ");
    private Button ok = new Button("ok");
    private TextField tf = new TextField(30);

    public void init() {
        ok.addActionListener(new OkListener());
        tf.setName("tx");
        frame.add(tf);
        frame.add(ok, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private class OkListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("click ok");
            tf.setText("your input :" + tf.getText());
        }
    }

    public static void main(String[] args) {
        new EventQs().init();
    }
}
