package com.javacore.awt;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class gui21 extends JFrame {
    private ImageIcon m1 = new ImageIcon("image/us.gif");
    private ImageIcon m2 = new ImageIcon("image/my.gif");
    private ImageIcon m3 = new ImageIcon("image/uk.gif");
    ImageIcon m[] = new ImageIcon[]{m1, m2, m3};

    public gui21() {
        Random j = new Random();
        setLayout(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            add(new JLabel(m[1 + j.nextInt(2)]));
        }
    }

    public static void main(String[] args) {

        gui21 frame = new gui21();
        frame.setSize(200, 200);
        frame.setTitle("Exercise12_7");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
