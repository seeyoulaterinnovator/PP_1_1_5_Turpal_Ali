package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import java.sql.*;
import java.util.Properties;

public class Util {
    private static Connection connection;

    // реализуйте настройку соеденения с БД
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
