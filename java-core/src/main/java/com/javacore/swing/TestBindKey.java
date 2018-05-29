package com.javacore.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestBindKey {
    JFrame jf = new JFrame("test key bind");
    JTextArea jta = new JTextArea(5, 30);
    JButton jb = new JButton("send");
    JTextField jtf = new JTextField(15);

    public void init() {
        jf.add(jta);
        JPanel jp = new JPanel();
        jp.add(jtf);
        jp.add(jb);
        jf.add(jp, BorderLayout.SOUTH);

        Action sendMsg = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
            }
        };
        jb.addActionListener(sendMsg);
        jtf.getInputMap().put(KeyStroke.getKeyStroke('\n'), "send");
        jtf.getActionMap().put("send", sendMsg);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new TestBindKey().init();

    }
}
