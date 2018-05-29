package com.javacore.jdbc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class QueryExecutor {
    JFrame jf = new JFrame("查询执行器");
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private JButton execBn = new JButton("查询");

    private JTextField sqlField = new JTextField(45);
    private static Connection connection;
    private static Statement stmt;
    private ResultSet rs;

    static {
        Jdbc jdbc = new Jdbc();
        try {
            Class.forName(jdbc.driver);
            connection = DriverManager.getConnection(jdbc.url, jdbc.user, jdbc.pw);
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        JPanel top = new JPanel();
        top.add(new JLabel("请输入查询语句："));
        top.add(sqlField);
        top.add(execBn);
        execBn.addActionListener(new ExceListener());

        jf.add(top, BorderLayout.NORTH);
        jf.setSize(700, 480);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new QueryExecutor().init();
    }

    private class ExceListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (scrollPane != null) {
                jf.remove(scrollPane);
            }
            try {
                rs = stmt.executeQuery(sqlField.getText());
                ResultSetMetaData resultSetMetaData = rs.getMetaData();
                Vector<String> columnNames = new Vector<String>();
                Vector data = new Vector();
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                    columnNames.add(resultSetMetaData.getColumnName(i + 1));
                }
                while (rs.next()) {
                    Vector v = new Vector();
                    for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                        v.add(rs.getString(i + 1));
                    }
                    data.add(v);
                }
                model = new DefaultTableModel(data, columnNames);
                JTable table = new JTable(model);
                scrollPane = new JScrollPane(table);
                jf.add(scrollPane);
                jf.validate();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
