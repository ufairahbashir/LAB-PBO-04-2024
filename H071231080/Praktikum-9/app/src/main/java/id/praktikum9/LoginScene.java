package id.praktikum9;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScene {
    public static Scene createScene(Stage primaryStage, App app) {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10, 20, 5, 20));
        layout.setId("layout-login");

        TextField usernameField = new TextField();
        
        usernameField.setPromptText("Enter your username");
        usernameField.setId("user-field");
        usernameField.setMaxWidth(255);

        usernameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                usernameField.setStyle("-fx-border-color: #007bff; -fx-border-width: 1; -fx-border-style: solid;");
            } else {
                usernameField.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1; -fx-border-style: solid;");
            }
        });
        

        HBox userBox = new HBox(10, usernameField);
        userBox.setAlignment(Pos.CENTER);
        userBox.setSpacing(5);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setId("pass-field");
        passwordField.setMaxWidth(180);
        passwordField.setMinHeight(16);

        passwordField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                passwordField.setStyle("-fx-border-color: #007bff; -fx-border-width: 1; -fx-border-style: solid;");
            } else {
                passwordField.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1; -fx-border-style: solid;");
            }
        });

        TextField textField = new TextField();
        textField.setPromptText("Enter your password");
        textField.setId("pass-field-visible");
        textField.setVisible(false);
        textField.setManaged(false);
        textField.setMaxWidth(180);
        textField.setMinHeight(16);


        

        textField.textProperty().bindBidirectional(passwordField.textProperty());

        Button eyeButton = new Button();
        try {
            Image eyeIcon = new Image("file:src/main/resources/image/eye.png");
            ImageView eyeImageView = new ImageView(eyeIcon);
            eyeImageView.setFitHeight(20);
            eyeImageView.setFitWidth(20);
            eyeButton.setGraphic(eyeImageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        eyeButton.setOnAction(e -> {
            if (passwordField.isVisible()) {
                passwordField.setVisible(false);
                passwordField.setManaged(false);
                textField.setVisible(true);
                textField.setManaged(true);
            } else {
                passwordField.setVisible(true);
                passwordField.setManaged(true);
                textField.setVisible(false);
                textField.setManaged(false);
            }
        });

        HBox passwordBox = new HBox(10, passwordField, textField, eyeButton);
        passwordBox.setAlignment(Pos.CENTER);
        passwordBox.setSpacing(2);

        Button loginButton = new Button("Login");
        loginButton.setId("btn-login");
        loginButton.setOnAction(e -> {
            if (usernameField.getText().equals(app.getUsername()) && passwordField.getText().equals(app.getPassword())) {
                primaryStage.setScene(HomeScene.createScene(primaryStage, app));
            } else {
                Label errorLabel = new Label("Invalid username or password!");
                errorLabel.setId("error-label");
                if (!layout.getChildren().contains(errorLabel)) {
                    layout.getChildren().add(errorLabel);
                }
            }
        });

        Image profile = new Image("file:src/main/resources/image/biodata2.png");
        ImageView profileImageView = new ImageView(profile);
        profileImageView.setFitHeight(155);
        profileImageView.setFitWidth(155);

        VBox imageLayout = new VBox(20);
        imageLayout.setAlignment(Pos.CENTER);
        imageLayout.getChildren().add(profileImageView);


        layout.getChildren().addAll(imageLayout, new Label("Username:"), userBox, new Label("Password:"), passwordBox, loginButton);

        layout.setId("layoutAll");

        Scene scene = new Scene(layout, 500, 600);
        scene.getStylesheets().add("styles/stylesLoginScene.css");
        return scene;
    }
}
