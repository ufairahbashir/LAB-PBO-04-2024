package tugas.Controller;



import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import tugas.Config.Config;
import tugas.Models.Account;
import tugas.Scene.RegisScene;
import tugas.Utils.PasswordHasher;

public class accountController extends Config{
    
    //create
    public static boolean createAccount(String email, String name, String username, String password) {
        try {
            getConnection();
            // query = "CREATE TABLE IF NOT EXISTS account " +
            //     "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, " +
            //     "email TEXT NOT NULL UNIQUE, " +
            //     "username TEXT NOT NULL UNIQUE, " +
            //     "name TEXT NOT NULL, " +
            //     "password TEXT NOT NULL)";
            // preparedStatement = connection.prepareStatement(query);
            // preparedStatement.executeUpdate(query);
            
            // getConnection();
            query = "INSERT INTO account (email, username, name, password) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, PasswordHasher.doHashing(password));// password yang masuk ke database di hashing
            preparedStatement.executeUpdate();
            System.out.println("yessss");
            return true;

        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE constraint failed")) {
                String constraint = e.getMessage().split(":")[1].trim();
                
                if (constraint.contains("email")) {
                    RegisScene.setErrorText("Email already exists!");
                } else if (constraint.contains("username")) {
                    RegisScene.setErrorText("Username already exists!");
                }
            } else {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return false;
    }

    //READ
    public static Account loginAccount(TextField username, TextField password) {
        String usernameText = username.getText();
        String passwordText = password.getText();
        query = "SELECT * FROM account WHERE username =? AND password=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usernameText);
            preparedStatement.setString(2, PasswordHasher.doHashing(passwordText)); // menghasing inputan dan memngecek apakah sama di database
            try (ResultSet login = preparedStatement.executeQuery()) {
                if (login.next()) {
                    int id = login.getInt("id");
                    Account account = new Account(id);
                    return account;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //READ
    public static Account showUserProfile(int id) throws SQLException {
        Account account = null;
        query = "SELECT * FROM account WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                byte[] photoProfileByte = resultSet.getBytes("photoFile");
                ImageView photoProfile;
                if (photoProfileByte != null) {
                    photoProfile = new ImageView(new Image(new ByteArrayInputStream(photoProfileByte)));
                }
                else{
                    photoProfile = new ImageView("/images/null.png");
                }
                account = new Account(id, email, username, name, password, photoProfile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    


    //UPDATE
    public static boolean updateAccount(int id, String email, String username, String name, String password) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
        FileInputStream fis = new FileInputStream(selectedFile);
        
    
        if (selectedFile != null) {
            try {
                getConnection();
                String query = "UPDATE account SET email=?, username=?, name=?, password=?, photoFile=? WHERE id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, name);
                preparedStatement.setString(4, password);
                preparedStatement.setBinaryStream(5, fis, (int) selectedFile.length());
                preparedStatement.setInt(6, id);
                int rowsUpdated = preparedStatement.executeUpdate();
                return rowsUpdated > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
