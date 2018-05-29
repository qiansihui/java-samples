package com.javacore.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestJToolBar {
    JFrame jf = new JFrame("测试工具条");
    JTextArea jta = new JTextArea(6, 35);
    JToolBar jtb = new JToolBar();
    JMenuBar jmb = new JMenuBar();
    JMenu edit = new JMenu("编辑");
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Action pasteAction = new AbstractAction("黏贴", new ImageIcon("ps.png")) {
        public void actionPerformed(ActionEvent e) {
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                try {
                    String content = (String) clipboard.getData(DataFlavor.stringFlavor);
                    jta.replaceRange(content, jta.getSelectionStart(), jta.getSelectionEnd());
                } catch (UnsupportedFlavorException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    };
    Action copyAction = new AbstractAction("复制") {
        public void actionPerformed(ActionEvent e) {
            StringSelection contents = new StringSelection(jta.getSelectedText());
            clipboard.setContents(contents, null);
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                pasteAction.setEnabled(true);
            }
        }
    };

    public void init() {
        pasteAction.setEnabled(false);
        jf.add(new JScrollPane(jta));
        JButton copyBn = new JButton(copyAction);
        JButton pasteBn = new JButton(pasteAction);
        JPanel jp = new JPanel();
        jp.add(copyBn);
        jp.add(pasteBn);
        jf.add(jp, BorderLayout.SOUTH);
        jtb.add(copyAction);
        jtb.addSeparator();
        jtb.add(pasteAction);
        jmb.add(edit);
        jf.setJMenuBar(jmb);
        jtb.setMargin(new Insets(20, 10, 5, 30));
        jf.add(jtb, BorderLayout.NORTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new TestJToolBar().init();

    }
}
