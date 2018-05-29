package com.javacore.jdbc;

import java.sql.*;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestResult {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Jdbc jdbc = new Jdbc();

    public void query(String sql) throws SQLException {
        try {
            Class.forName(jdbc.driver);
            connection = DriverManager.getConnection(jdbc.url, jdbc.user, jdbc.pw);
            //传入控制结果集可滚动，可更新的参数
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = preparedStatement.executeQuery();
            resultSet.last();
            int rows = resultSet.getRow();
            for (int i = rows; i > 0; i--) {
                resultSet.absolute(i);
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
                resultSet.updateString(2, "tea_" + resultSet.getString(2));
                resultSet.updateRow();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        TestResult testResult = new TestResult();
        String sql = "select * from teacher";
        testResult.query(sql);
    }
}
