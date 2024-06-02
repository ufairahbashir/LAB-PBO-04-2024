package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.User;

public class LoginScene {
    private Stage primaryStage;

    public LoginScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        VBox loginLayout = new VBox(10);
        loginLayout.setPadding(new Insets(20));
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setStyle("-fx-background-color: #2C2C54;");

        Label titleLabel = new Label("Login");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white;");

        Label usernameLabel = new Label("Username");
        TextField usernameField = new TextField();
        usernameField.setStyle("-fx-font-size: 14px; -fx-background-radius: 5px;");

        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle("-fx-font-size: 14px; -fx-background-radius: 5px;");

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #38ADA9; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 5px;");
        loginButton.setPrefWidth(100);
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (new User(username, password).authenticate()) {
                new DashboardScene(primaryStage).show();
            } else {
                showAlert("Invalid username or password");
            }
        });

        Button signUpButton = new Button("Sign Up");
        signUpButton.setStyle("-fx-background-color: #6A89CC; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 5px;");
        signUpButton.setPrefWidth(100);
        signUpButton.setOnAction(e -> new SignUpScene(primaryStage).show());

        loginLayout.getChildren().addAll(titleLabel, usernameLabel, usernameField, passwordLabel, passwordField, loginButton, signUpButton);

        Scene loginScene = new Scene(loginLayout, 400, 300);
        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}