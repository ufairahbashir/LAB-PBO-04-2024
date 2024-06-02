package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection connecting() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:src/main/resources/database/Users.db";

            conn = DriverManager.getConnection(url);
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.out.println(e + "");
        } 
        return conn;
    }
}