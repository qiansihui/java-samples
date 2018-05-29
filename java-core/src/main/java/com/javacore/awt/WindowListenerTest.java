package com.javacore.awt;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by sunqq on 2015/5/22.
 */
public class WindowListenerTest {
    private Frame frame = new Frame("window listener");
    private TextArea textArea = new TextArea(6, 40);

    public void init() {
        frame.addWindowListener(new MyListener());
        frame.add(textArea);
        frame.pack();
        frame.setVisible(true);
    }

    private class MyListener implements WindowListener {
        public void windowOpened(WindowEvent e) {
            textArea.append("窗口被激活!\n");
        }

        public void windowClosing(WindowEvent e) {
            textArea.append("用户试图关闭窗口!");
            System.exit(0);
        }

        public void windowClosed(WindowEvent e) {
            textArea.append("窗口关闭!\n");
        }

        public void windowIconified(WindowEvent e) {
            textArea.append("窗口最小化\n");
        }

        public void windowDeiconified(WindowEvent e) {
            textArea.append("窗口被恢复\n");
        }

        public void windowActivated(WindowEvent e) {
            textArea.append("窗口被激活\n");
        }

        public void windowDeactivated(WindowEvent e) {
            textArea.append("窗口失去焦点\n");
        }
    }

    public static void main(String[] args) {
        new WindowListenerTest().init();
    }
}
