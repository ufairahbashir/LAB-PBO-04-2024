package praktikum.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import praktikum.controller.UserController;
import praktikum.utils.UIUtil;

public class RegisterScene {
    private Stage stage;

    public RegisterScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Pane root = new Pane();
        root.getStyleClass().add("root1");

        /* ==> INSTANCE LAYOUT START <== */
        Label labelTitle = UIUtil.createLabel("Register", 129, 37);
        labelTitle.getStyleClass().add("label-title-register");

        Label labelHello = UIUtil.createLabel("Fill Your Detail Account", 115, 93);
        labelHello.getStyleClass().add("label-hello");

        Label labelFullName = UIUtil.createLabel("Nama Lengkap", 54, 136);
        labelFullName.getStyleClass().add("label-fullName");

        TextField textFieldFullName = UIUtil.createTextField("Masukkan nama lengkap", 38, 157);
        textFieldFullName.getStyleClass().add("text-field-register");

        Label labelEmail = UIUtil.createLabel("Email", 54, 210);
        labelEmail.getStyleClass().add("label-email");

        TextField textFieldEmail = UIUtil.createTextField("Masukkan email", 38, 231);
        textFieldEmail.getStyleClass().add("text-field-register");

        Label labelPassword = UIUtil.createLabel("Password", 54, 283);
        labelPassword.getStyleClass().add("label-password");

        PasswordField passwordField = UIUtil.createPasswordField("Masukkan password", 38, 305);
        passwordField.getStyleClass().add("text-field-register");

        Button buttonRegister = UIUtil.createButton("Register", 124, 400);
        buttonRegister.getStyleClass().add("button-register");

        Label labelStatus = UIUtil.createLabel("", 118, 368);
        labelStatus.getStyleClass().add("label-status");

        Button buttonBack = UIUtil.createButtonWithImage("/images/SignOut3.png", 20, 17, 35, 35);
        buttonBack.setOnAction(e -> {
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
        });

        Image imageSkillup = new Image(getClass().getResourceAsStream("/images/imageRegist.png"));
        ImageView imageViewSkillup = new ImageView(imageSkillup);
        imageViewSkillup.getStyleClass().add("image-skillup");
        imageViewSkillup.setFitWidth(317);
        imageViewSkillup.setFitHeight(405);
        imageViewSkillup.setLayoutX(388);
        imageViewSkillup.setLayoutY(37);

        root.getChildren().addAll(labelTitle, labelHello, labelFullName, textFieldFullName, labelEmail, textFieldEmail, buttonBack, labelPassword, passwordField, buttonRegister, labelStatus, imageViewSkillup);

        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        buttonRegister.setOnAction(e -> {
            String fullName = textFieldFullName.getText();
            String email = textFieldEmail.getText();
            String password = passwordField.getText();
            
            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                labelStatus.setText("Nama, email, dan password harus diisi!");
                return;
            }
            
            if (UserController.isUserExists(email)) {
                labelStatus.setText("Email sudah terdaftar, silahkan login!");
            } else {
                boolean registered = UserController.register(fullName, email, password);
                if (registered) {
                    labelStatus.setText("Registrasi berhasil!");
                } else {
                    labelStatus.setText("Registrasi gagal, coba lagi!");
                }
            }
        });
        /* ==> BUTTON ACTION END <== */

        Scene scene = new Scene(root, 740, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
    }
}
