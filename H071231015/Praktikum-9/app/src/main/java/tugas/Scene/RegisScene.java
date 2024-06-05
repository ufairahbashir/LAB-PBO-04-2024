package tugas.Scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tugas.App;
import tugas.Controller.accountController;
import tugas.Utils.imageSet;

public class RegisScene {
    private static String errorText;
    public static String getErrorText() {
        return errorText;
    }

    public static void setErrorText(String errorText) {
        RegisScene.errorText = errorText;
    }

    //regex email
    private static final String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    
    // Regex untuk username
    private static final String usernameRegex1 = "^[a-zA-Z0-9_.]{3,30}$"; // Hanya boleh mengandung huruf, angka, titik, dan garis bawah
    private static final String usernameRegex2 = "^.{3,30}$"; // Minimal 3 karakter dan maksimal 30 karakter
    // private static final String usernameRegex3 = "^[^.]+.*[^.]$"; // Tidak boleh dimulai atau diakhiri dengan titik
    // private static final String usernameRegex4 = "^(?=.*\\.\\.)[^@\\s]+$";

    // Regex untuk password
    private static final String passwordRegex1 = "^(?=.*[a-z]).*$"; // Harus mengandung minimal satu huruf kecil
    private static final String passwordRegex2 = "^(?=.*[A-Z]).*$"; // Harus mengandung minimal satu huruf besar
    private static final String passwordRegex3 = "^(?=.*\\d).*$"; // Harus mengandung minimal satu angka
    private static final String passwordRegex4 = "^(?=.*[@$!%*?&]).*$"; // Harus mengandung minimal satu karakter spesial
    private static final String passwordRegex5 = "^.{6,}$"; // Minimal 6 karakter

    private Stage stage;

    public RegisScene(Stage stage) {
        this.stage = stage;
    }

    private static boolean buttonRegis(TextField email, TextField name, TextField username, TextField password){
        String emailText = email.getText();
        String nameText = name.getText();
        String usernameText = username.getText();
        String passwordText = password.getText(); 

        try {
            if (emailText.isEmpty()) {
                setErrorText("Please enter your email");
                return false;
            }
            else if (nameText.isEmpty()) {
                setErrorText("Please enter your name");
                return false;
            }
            else if (usernameText.isEmpty()) {
                setErrorText("Please enter your username");
                return false;
            }
            else if (passwordText.isEmpty()) {
                setErrorText("Please enter your password");
                return false;
            }
            else{
                boolean isEmailValid = emailText.matches(emailRegex);
                boolean isUsernameValid = true;
                boolean isPasswordValid = true;
                
                if (!isEmailValid) {
                    setErrorText("Please enter correct email");
                    return false;
                }
                
                // Validasi username
                if (!usernameText.matches(usernameRegex1)) {
                    setErrorText("Username only have alfabet, number, \ndot, and underscore");
                    isUsernameValid = false;
                    return false;
                } else if (!usernameText.matches(usernameRegex2)) {
                    setErrorText("Username must be between 3 and \n30 characters long");
                    isUsernameValid = false;
                    return false;
                }
                
                // Validasi password
                if (!passwordText.matches(passwordRegex1)) {
                    isPasswordValid = false;
                    setErrorText("Password must contain at least \none lowercase letter");
                    return false;
                } else if (!passwordText.matches(passwordRegex2)) {
                    isPasswordValid = false;
                    setErrorText("Password must contain at least \none uppercase letter");
                    return false;
                } else if (!passwordText.matches(passwordRegex3)) {
                    isPasswordValid = false;
                    setErrorText("Password must contain at least \none digit");
                    return false;
                } else if (!passwordText.matches(passwordRegex4)) {
                    isPasswordValid = false;
                    setErrorText("Password must contain at least \none special character (@$!%*?&)");
                    return false;
                } else if (!passwordText.matches(passwordRegex5)) {
                    isPasswordValid = false;
                    setErrorText("Password must be at least \n6 characters long");
                    return false;
                }

                if (isEmailValid && isUsernameValid && isPasswordValid) {
                    // Eksekusi perintah untuk menyimpan data
                    accountController.createAccount(emailText, nameText, usernameText, passwordText);
                    System.out.println("Data inserted successfully!");
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void show(){
        // ELEMENT 1 : logo instag sama black box
        Rectangle regisBox = new Rectangle(300, 400);
        regisBox.setId("signBox");
        ImageView regisLogo = imageSet.setImages("/images/logoName.png", 200, 100);
        VBox element1 = new VBox(regisLogo, regisBox);
        element1.setAlignment(Pos.CENTER);
        element1.setSpacing(-20);

        //ELEMENT 2
        TextField email = new TextField();
        email.setId("input");
        email.setPromptText("Email");
        

        TextField name = new TextField();
        name.setId("input");
        name.setPromptText("Full Name");

        TextField username = new TextField();
        username.setId("input");
        username.setPromptText("Username");

        PasswordField password = new PasswordField();
        password.setId("input");
        password.setPromptText("Password");

        Button back = new Button("Back");
        back.setId("basicButton");
        back.setOnAction(e -> {
            new LoginScene(stage).show();
        });

        Button signUp = new Button("Sign Up");
        signUp.setId("basicButton");

        
        HBox buttons = new HBox(back, signUp);
        buttons.setSpacing(20);
        buttons.setAlignment(Pos.CENTER);

        Label warning = new Label();
        warning.setId("warningText");
        
        VBox input1 = new VBox(email, name, username, password, buttons, warning);
        input1.setAlignment(Pos.CENTER);
        input1.setSpacing(20);
        HBox element2 = new HBox(input1);
        element2.setAlignment(Pos.CENTER);
        element2.setPadding(new Insets(40, 0, 0, 0));
        

        email.setOnKeyPressed(e ->{
            if (e.getCode() == KeyCode.ENTER) {
                name.requestFocus();
            }
        });
        name.setOnKeyPressed(e ->{
            if (e.getCode() == KeyCode.ENTER) {
                username.requestFocus();
            }
        });
        username.setOnKeyPressed(e ->{
            if (e.getCode() == KeyCode.ENTER) {
                password.requestFocus();
            }
        });
        password.setOnKeyPressed(e ->{
            if (e.getCode() == KeyCode.ENTER) {
                signUp.fire();
            }
        });

        signUp.setOnAction(e -> {
            if (buttonRegis(email, name, username, password)) {
                new LoginScene(stage).show();
            }else{
                warning.setText(getErrorText());  
            }
        });


        StackPane regisRoot = new StackPane(element1, element2);
        App.setShow(regisRoot);
        stage.getScene().setRoot(regisRoot);
    }
}
