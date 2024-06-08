package id.amalia.praktikum.scenes;

import id.amalia.praktikum.controllers.UserController;
import id.amalia.praktikum.models.User;
import id.amalia.praktikum.scenes.User_scene.HomeScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginScene {
    private final Stage stage;

    public LoginScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // INSTANCE LAYOUT START
        Label labelTitle = new Label("Tugas praktikum");
        labelTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        labelTitle.getStyleClass().add("title");
        HBox hBoxTitle = new HBox(labelTitle);
        hBoxTitle.setSpacing(10);
        hBoxTitle.setAlignment(Pos.CENTER); // Center the title horizontally
        VBox vBoxTitle = new VBox(hBoxTitle);
        vBoxTitle.setAlignment(Pos.CENTER); // Center the title vertically

        Label labelLogin = new Label("Login");
        labelLogin.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        labelLogin.getStyleClass().add("text");
        Label labelWelcome = new Label("Selamat datang di Tugas Praktikum. Silahkan login untuk melanjutkan");
        labelWelcome.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        labelWelcome.getStyleClass().add("text");
        // Overflow text
        labelWelcome.setWrapText(true);
        VBox vBoxWelcome = new VBox(labelLogin, labelWelcome);
        vBoxWelcome.setSpacing(5);
        vBoxWelcome.setAlignment(Pos.CENTER); // Center the welcome message

        Label labelEmail = new Label("Email");
        labelEmail.getStyleClass().add("text");
        TextField textFieldEmail = new TextField();
        textFieldEmail.setPromptText("Masukkan email");
        textFieldEmail.setPrefWidth(300);
        textFieldEmail.getStyleClass().add("textfield");
        VBox vBoxEmail = new VBox(labelEmail, textFieldEmail);
        vBoxEmail.setAlignment(Pos.CENTER); // Center the email field

        Label labelPassword = new Label("Password");
        labelPassword.getStyleClass().add("text");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Masukkan password");
        passwordField.setPrefWidth(300);
        passwordField.getStyleClass().add("textfield");
        VBox vBoxPassword = new VBox(labelPassword, passwordField);
        vBoxPassword.setPadding(new Insets(0, 0, 10, 0));
        vBoxPassword.setAlignment(Pos.CENTER); // Center the password field

        Button buttonLogin = new Button("Login");
        buttonLogin.setPrefWidth(300);
        buttonLogin.getStyleClass().add("loginbutton");

        Button buttonRegis = new Button("Register");
        buttonRegis.setPrefWidth(300);
        buttonRegis.getStyleClass().add("registerbutton");

        VBox vBoxInputLogin = new VBox(vBoxEmail, vBoxPassword, buttonLogin, buttonRegis);
        vBoxInputLogin.setSpacing(10);
        vBoxInputLogin.setAlignment(Pos.CENTER); // Center the entire form

        Label labelStatus = new Label(); // Label for displaying status/error messages
        labelStatus.getStyleClass().add("text-status");

        VBox vBoxMainContent = new VBox(vBoxTitle, vBoxWelcome, vBoxInputLogin, labelStatus);
        vBoxMainContent.setPrefWidth(520);
        vBoxMainContent.setSpacing(30);
        vBoxMainContent.setPadding(new Insets(0, 20, 0, 20));
        vBoxMainContent.setAlignment(Pos.CENTER); // Center the main content
        vBoxMainContent.getStyleClass().add("scene");

        Image imagePraktikum = new Image(getClass().getResourceAsStream("/images/LB.png"));
        ImageView imageViewPraktikum = new ImageView(imagePraktikum);
        imageViewPraktikum.setPreserveRatio(true);
        imageViewPraktikum.setFitWidth(420);
        imageViewPraktikum.setFitHeight(580);

        VBox vBoxImagePraktikum = new VBox(imageViewPraktikum);
        vBoxImagePraktikum.setAlignment(Pos.CENTER);
        vBoxImagePraktikum.setBackground(new Background(new BackgroundFill(Color.web("#090f30"), null, null)));

        HBox root = new HBox(vBoxMainContent, vBoxImagePraktikum);
        root.setAlignment(Pos.CENTER); // Center the entire layout horizontally
        root.setAlignment(Pos.CENTER); // Center the entire layout horizontally
        stage.getScene().setRoot(root);
        // INSTANCE LAYOUT END

        // BUTTON ACTION START
        buttonLogin.setOnAction(e -> {
            String email = textFieldEmail.getText();
            String password = passwordField.getText();

            if (email.isEmpty() || password.isEmpty()) {
                labelStatus.setText("Email dan password harus diisi!");
                return;
            }

            User user = UserController.login(email, password);
            if (user != null) {
                int id = user.getId();
                HomeScene homeScene = new HomeScene(stage);
                homeScene.show(id);
            } else {
                labelStatus.setText("Email atau password salah!");
            }
        });

        buttonRegis.setOnMouseClicked(e -> {
            RegisterScene registerScene = new RegisterScene(stage);
            registerScene.show();
        });
        /* ==> BUTTON ACTION END <== */
    }
    protected void show(int id) {}
}