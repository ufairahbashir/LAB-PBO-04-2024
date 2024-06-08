package id.amalia.praktikum.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import id.amalia.praktikum.controllers.UserController;

public class RegisterScene {
    private Stage stage;

    public RegisterScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        /* ==> INSTANCE LAYOUT START <== */
        Label labelTitle = new Label("Tugas Praktikum");
        labelTitle.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 30));
        labelTitle.getStyleClass().add("title");
        HBox hBoxTitle = new HBox(labelTitle);
        hBoxTitle.setSpacing(10);
        hBoxTitle.setAlignment(Pos.CENTER); // Center the title horizontally
        VBox vBoxTitle = new VBox(hBoxTitle);
        vBoxTitle.setAlignment(Pos.CENTER); // Center the title vertically

        Label labelHello = new Label("Register");
        labelHello.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        labelHello.getStyleClass().add("text");
        Label labelWelcome = new Label("Silahkan daftar untuk bergabung di Tugas Praktikum");
        labelWelcome.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        labelWelcome.getStyleClass().add("text");
        // Overflow text
        labelWelcome.setWrapText(true);
        VBox vBoxWelcome = new VBox(labelHello, labelWelcome);
        vBoxWelcome.setSpacing(5);
        vBoxWelcome.setAlignment(Pos.CENTER); // Center the welcome message

        Label labelUsername = new Label("Username");
        labelUsername.getStyleClass().add("text");
        TextField textFieldUsername = new TextField();
        textFieldUsername.setPromptText("Masukkan username");
        textFieldUsername.setPrefWidth(200);
        textFieldUsername.getStyleClass().add("textfield");
        VBox vBoxUsername = new VBox(labelUsername, textFieldUsername);
        vBoxUsername.setAlignment(Pos.CENTER); // Center the username field

        Label labelName = new Label("Nama");
        labelName.getStyleClass().add("text");
        TextField textFieldName = new TextField();
        textFieldName.setPromptText("Masukkan nama");
        textFieldName.setPrefWidth(200);
        textFieldName.getStyleClass().add("textfield");
        VBox vBoxName = new VBox(labelName, textFieldName);
        vBoxName.setAlignment(Pos.CENTER); // Center the name field

        Label labelEmail = new Label("Email");
        labelEmail.getStyleClass().add("text");
        TextField textFieldEmail = new TextField();
        textFieldEmail.setPromptText("Masukkan email");
        textFieldEmail.setPrefWidth(200);
        textFieldEmail.getStyleClass().add("textfield");
        VBox vBoxEmail = new VBox(labelEmail, textFieldEmail);
        vBoxEmail.setAlignment(Pos.CENTER); // Center the email field

        Label labelPassword = new Label("Password");
        labelPassword.getStyleClass().add("text");
        TextField textFieldPassword = new TextField();
        textFieldPassword.setPromptText("Masukkan password");
        textFieldPassword.setPrefWidth(200);
        textFieldPassword.getStyleClass().add("textfield");
        VBox vBoxPassword = new VBox(labelPassword, textFieldPassword);
        vBoxPassword.setPadding(new Insets(0, 0, 10, 0));
        vBoxPassword.setAlignment(Pos.CENTER); // Center the password field

        Button buttonRegister = new Button("Register");
        buttonRegister.setPrefWidth(300);
        buttonRegister.getStyleClass().add("registerbutton");

        Button buttonLogin = new Button("Login");
        buttonLogin.setPrefWidth(300);
        buttonLogin.getStyleClass().add("loginbutton");

        VBox vBoxInputRegister = new VBox(vBoxUsername, vBoxName, vBoxEmail, vBoxPassword, buttonRegister, buttonLogin);
        vBoxInputRegister.setSpacing(10);
        vBoxInputRegister.setAlignment(Pos.CENTER); // Center the entire form

        Label labelStatus = new Label();
        labelStatus.getStyleClass().add("text-status");

        VBox vBoxMainContent = new VBox(vBoxTitle, vBoxWelcome, vBoxInputRegister, labelStatus);
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
        stage.getScene().setRoot(root);
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        buttonRegister.setOnAction(e -> {
            String username = textFieldUsername.getText();
            String name = textFieldName.getText();
            String email = textFieldEmail.getText();
            String password = textFieldPassword.getText();

            if (username.isEmpty() || name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                labelStatus.setText("Username, Nama, Email, dan Password tidak boleh kosong");
                return;
            } else if (!email.matches("^[\\w._%+-]+@gmail\\.com$")) {
                labelStatus.setText("Email harus berakhiran @gmail.com");
                return;
            } else if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
                labelStatus.setText("Password minimal 8 karakter memiliki huruf besar, huruf kecil, dan angka");
                return;
            } else if (UserController.isUsernameOrEmailTaken(username, email)) {
                labelStatus.setText("Email atau Username telah digunakan");
                return;
            } else {
                UserController.register(username, name, email, password);
                LoginScene loginScene = new LoginScene(stage);
                loginScene.show();
            }
        });
        
        buttonLogin.setOnMouseClicked(e -> {
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
        });
        /* ==> BUTTON ACTION END <== */
        textFieldUsername.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                textFieldName.requestFocus();
            }
        });

        textFieldName.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                textFieldEmail.requestFocus();
            }
        });

        textFieldEmail.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                textFieldPassword.requestFocus();
            }
        });

        textFieldPassword.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                buttonRegister.fire();
            }
        });
    }
    protected void show(int id) {}
}