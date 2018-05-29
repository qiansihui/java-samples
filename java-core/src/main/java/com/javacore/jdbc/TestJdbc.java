package com.javacore.jdbc;

import java.sql.*;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xiaohui", "root", "");
        Statement statement = connection.createStatement();
        String sql = "select * from article;";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
        }
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
