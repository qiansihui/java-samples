package com.javacore.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class SwingComponent {
    JFrame f = new JFrame("swing");
    JButton ok = new JButton("ok");
    JRadioButton male = new JRadioButton("male", true);
    JRadioButton female = new JRadioButton("female", false);
    ButtonGroup bg = new ButtonGroup();
    JCheckBox married = new JCheckBox("married?", false);
    String[] colors = new String[]{"red", "green", "blue"};
    JComboBox colorChooser = new JComboBox(colors);
    JList colorList = new JList(colors);
    JTextArea ta = new JTextArea(8, 20);
    JTextField name = new JTextField(40);
    JMenuBar mb = new JMenuBar();
    JMenu file = new JMenu("file");
    JMenu edit = new JMenu("edit");
    JMenuItem newItem = new JMenuItem("new");
    JMenuItem saveItem = new JMenuItem("save");
    JMenuItem exitItem = new JMenuItem("exit");
    JCheckBoxMenuItem autoWrap = new JCheckBoxMenuItem("自动换行");
    JMenuItem copyItem = new JMenuItem("copy");
    JMenuItem pasteItem = new JMenuItem("paste");
    JMenu format = new JMenu("format");
    JMenuItem commentItem = new JMenuItem("注释");
    JMenuItem cancelItem = new JMenuItem("取消注释");
    JPopupMenu pop = new JPopupMenu();
    ButtonGroup flavorGroup = new ButtonGroup();
    JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal style", true);
    JRadioButtonMenuItem windowItem = new JRadioButtonMenuItem("window style");
    JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("motif sytle");

    public void init() {
        JPanel bottom = new JPanel();
        bottom.add(name);
        bottom.add(ok);
        f.add(bottom, BorderLayout.SOUTH);
        JPanel checkPanel = new JPanel();
        checkPanel.add(colorChooser);
        bg.add(male);
        bg.add(female);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);
        Box topLeft = Box.createVerticalBox();
        JScrollPane taJsp = new JScrollPane(ta);
        topLeft.add(taJsp);
        topLeft.add(checkPanel);
        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);
        f.add(top);

        newItem.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
        newItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ta.append("user click new menu \n");
            }
        });
        file.add(newItem);
        file.add(saveItem);
        file.add(exitItem);
        edit.add(autoWrap);
        edit.add(copyItem);
        edit.add(pasteItem);
        commentItem.setToolTipText("comment your code");

        format.add(commentItem);
        format.add(cancelItem);
        edit.add(new JMenuItem("_"));
        edit.add(format);
        mb.add(file);
        mb.add(edit);
        f.setJMenuBar(mb);
        // line right menu
        flavorGroup.add(metalItem);
        flavorGroup.add(windowItem);
        flavorGroup.add(motifItem);

        pop.add(metalItem);
        pop.add(windowItem);
        pop.add(motifItem);

        ActionListener flavorListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getActionCommand().equals("Metal style")) {
                        changeFlavor(1);
                    } else if (e.getActionCommand().equals("window style")) {
                        changeFlavor(2);

                    } else if (e.getActionCommand().equals("motif sytle")) {
                        changeFlavor(3);
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        };
        metalItem.addActionListener(flavorListener);
        windowItem.addActionListener(flavorListener);
        motifItem.addActionListener(flavorListener);
        ta.setComponentPopupMenu(pop);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);

    }

    private void changeFlavor(int flavor) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        switch (flavor) {
            case 1:
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case 2:
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case 3:
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }
        SwingUtilities.updateComponentTreeUI(f.getContentPane());
        SwingUtilities.updateComponentTreeUI(mb);
        SwingUtilities.updateComponentTreeUI(pop);

    }

    public static void main(String[] args) {
        new SwingComponent().init();
    }

}
