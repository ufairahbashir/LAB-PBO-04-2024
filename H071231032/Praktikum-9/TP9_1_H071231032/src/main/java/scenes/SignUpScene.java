package scenes;

import dao.UserDAO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.User;

public class SignUpScene {

    private Stage primaryStage;

    public SignUpScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        VBox signUpLayout = new VBox(10);
        signUpLayout.setPadding(new Insets(20));
        signUpLayout.setAlignment(Pos.CENTER);
        signUpLayout.setStyle("-fx-background-color: #2C2C54;");

        Label titleLabel = new Label("Sign Up");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setStyle("-fx-font-size: 14px; -fx-background-radius: 5px;");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-font-size: 14px; -fx-background-radius: 5px;");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");
        confirmPasswordField.setStyle("-fx-font-size: 14px; -fx-background-radius: 5px;");

        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: white;");

        Button signUpButton = new Button("Sign Up");
        signUpButton.setStyle("-fx-background-color: #38ADA9; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 5px;");
        signUpButton.setPrefWidth(100);
        signUpButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();
            String confirmPassword = confirmPasswordField.getText().trim();

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                messageLabel.setText("Please fill in all fields!");
                return;
            }

            if (username.length() < 4 || password.length() < 4) {
                messageLabel.setText("Username and password must be at least 4 characters long!");
                return;
            }

            if (username.length() > 20 || password.length() > 20) {
                messageLabel.setText("Username and password must be at most 20 characters long!");
                return;
            }

            if (username.contains(" ") || password.contains(" ")) {
                messageLabel.setText("Username and/or passwordcannot contain spaces!");
                return;
            }

            if (password.equals(confirmPassword)) {
                UserDAO userDAO = new UserDAO();
                User user = new User(username, password);
                userDAO.addUser(user);
                messageLabel.setText("User registered successfully!");
            } else {
                messageLabel.setText("Passwords do not match!");
            }
        });

        Button backButton = new Button("Back to Login");
        backButton.setStyle("-fx-background-color: #6A89CC; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 5px;");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
            new LoginScene(primaryStage).show();
        });

        signUpLayout.getChildren().addAll(titleLabel, usernameField, passwordField, confirmPasswordField, signUpButton, backButton, messageLabel);

        Scene signUpScene = new Scene(signUpLayout, 400, 300);
        primaryStage.setScene(signUpScene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}