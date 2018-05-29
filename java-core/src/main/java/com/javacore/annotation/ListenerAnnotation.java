package com.javacore.annotation;

import javax.swing.*;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class ListenerAnnotation {
    private JFrame jf = new JFrame("使用注解添加监听器");
    @ActionListenerFor(listen = "OKListener")
    private JButton ok = new JButton("ok");
    @ActionListenerFor(listen = "CancelListener")
    private JButton cancel = new JButton("cancel");

    public void init() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        JPanel jPanel = new JPanel();
        jPanel.add(ok);
        jPanel.add(cancel);
        jf.add(jPanel);
        ActionListenerInstall.processAnnotation(this);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(100, 100, 500, 100);
        jf.setVisible(true);

    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        new ListenerAnnotation().init();
    }

}
