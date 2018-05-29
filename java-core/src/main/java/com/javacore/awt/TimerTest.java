package com.javacore.awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/20
 * @Description:
 * @CodeReviewer:
 */
public class TimerTest {

    public static void main(String[] args) {
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("time is : " + now);
                Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(2000, listener);
        t.start();
        JOptionPane.showMessageDialog(null, "quit program?");
        System.exit(0);
    }
}

