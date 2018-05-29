package com.javacore.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TestDDL {
    String driver, url, user, pw;
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public void init() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\IDE_workspace\\idea_workspace\\git\\java_demo\\src\\main\\java\\com\\sqq\\jdbc13\\db.properties"));
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        pw = properties.getProperty("pw");
    }

    public void excuteDDL(String sql) throws ClassNotFoundException, SQLException {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pw);
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void excuteSql(String sql) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pw);
            statement = connection.createStatement();
            boolean result = statement.execute(sql);
            if (result) {
                resultSet = statement.getResultSet();
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columCount = resultSetMetaData.getColumnCount();
                while (resultSet.next()) {
                    for (int i = 0; i < columCount; i++) {
                        System.out.print(resultSet.getString(i + 1) + "\t");
                    }
                    System.out.println("\n");
                }
            } else {
                System.out.println("该sql影响行数为：" + statement.getUpdateCount());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeSql(String sql, Object... objects) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pw);
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            boolean result = preparedStatement.execute();
            if (result) {
                resultSet = preparedStatement.getResultSet();
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columCount = resultSetMetaData.getColumnCount();
                while (resultSet.next()) {
                    for (int i = 0; i < columCount; i++) {
                        System.out.print(resultSet.getString(i + 1) + "\t");
                    }
                    System.out.println("\n");
                }
            } else {
                System.out.println("该sql影响行数为：" + preparedStatement.getUpdateCount());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void callProcedure() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pw);
            CallableStatement callableStatement = connection.prepareCall("{call add_pro(?,?,?)}");
            callableStatement.setInt(1, 4);
            callableStatement.setInt(2, 5);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(3));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        TestDDL testDDL = new TestDDL();
        testDDL.init();
       /* String sql = "alter table shop change test_id id int";
        sql = "insert teacher(name) values('chinese')";
        sql = "select * from teacher;";
        sql = "delete from teacher where id=4";
        testDDL.excuteDDL(sql);
        sql = "insert teacher(name) values(?)";
        testDDL.executeSql(sql, "math");
        sql = "select * from teacher";
        testDDL.executeSql(sql);*/
        testDDL.callProcedure();

    }
}
