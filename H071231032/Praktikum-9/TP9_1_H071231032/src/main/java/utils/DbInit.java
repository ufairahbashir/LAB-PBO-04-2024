package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInit {
    public static void initializeDatabase() {
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users (\n" +
                "   id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "   username TEXT NOT NULL UNIQUE,\n" +
                "   password TEXT NOT NULL\n" +
                ");";

        try (Connection conn = DatabaseConnection.connecting(); Statement stmt = conn.createStatement()) {
            stmt.execute(createUsersTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}