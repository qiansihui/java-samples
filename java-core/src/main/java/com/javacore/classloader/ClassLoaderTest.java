package com.javacore.classloader;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/30
 * @Description:
 * @CodeReviewer:
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame jFrame = new ClassLoaderFrame();
            }
        });
    }

}

class ClassLoaderFrame extends JFrame {
    public ClassLoaderFrame() {
        setTitle("ClassLoader Test");
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout());
    }
}
