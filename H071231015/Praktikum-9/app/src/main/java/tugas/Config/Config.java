package tugas.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Config {
    private static final String DB_URL = "jdbc:sqlite:data.db";

    protected static Connection connection;
    protected static PreparedStatement preparedStatement;
    protected static ResultSet resultSet;
    protected static String query;

    public static void getConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("BERHASIL");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
