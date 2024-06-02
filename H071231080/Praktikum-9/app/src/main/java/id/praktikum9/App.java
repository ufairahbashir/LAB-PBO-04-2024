package id.praktikum9;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    private Stage primaryStage;
    private String name;
    private String adress;
    private int age;
    private String username;
    private String password;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        primaryStage.setTitle("Biodata");
        primaryStage.setResizable(false);
        try {
            FileInputStream iconStream = new FileInputStream("src/main/resources/image/biodata.jpg");
            Image icon = new Image(iconStream);
            primaryStage.getIcons().add(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set default username and password
        setUsername("user");
        setPassword("pass");

        // Membuat LoginScene
        Scene loginScene = LoginScene.createScene(primaryStage, this);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    // Setter dan getter untuk atribut name, alamat, age, username, dan password
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
