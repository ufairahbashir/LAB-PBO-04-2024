package id.amalia.praktikum.controllers;

import java.sql.ResultSet;

import id.amalia.praktikum.config.DbConfig;
import id.amalia.praktikum.models.User;

public class UserController extends DbConfig {
    // Return role
    // TODO 1: Create login()
    public static User login(String email, String password) {
        query = "SELECT * FROM users WHERE email=? AND password=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet userResult = preparedStatement.executeQuery()) {
                if (userResult.next()) {
                    int id = userResult.getInt("id");
                    User user = new User(id);
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // EXERCISE: Create method register()
    public static boolean register(String username, String name, String email, String password) {
        query = "INSERT INTO users (username, name, email, password) VALUES (?, ?, ?, ?)";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // TODO 5: Create method getUserById(int id)
    public static User getUserById(int id) {
        query = "SELECT * FROM users WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            try (ResultSet userResult = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String name = resultSet.getString("name");
                    String phoneNumber = resultSet.getString("phone_number");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");
                    User user = new User(id, username, name, age, phoneNumber, email);
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isUsernameOrEmailTaken(String username, String email) {
        query = "SELECT * FROM users WHERE username=? OR email=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

 

    // TODO 7: Create method updateUser(User user)
    public static boolean updateUser(int id, String Username, String name, int age, String phone_number, String email) {
        query = "UPDATE users SET Username=?, name=?, age=?, phone_number=?, email=? WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, phone_number);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, id);
            
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
