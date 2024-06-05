package tugas.Scene;

import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tugas.App;
import tugas.Controller.accountController;
import tugas.Models.Account;
import tugas.Utils.imageSet;

public class LoginScene {
    private Stage stage;
    private BorderPane borderPane = new BorderPane();
    private AnchorPane anchorPane = new AnchorPane();
    private static String errorText;
    public static String getErrorText() {
        return errorText;
    }

    public static void setErrorText(String errorText) {
        LoginScene.errorText = errorText;
    }


    private StackPane loginRoot;
    public StackPane getLoginRoot() {return loginRoot;}

    public LoginScene(Stage stage) {
        this.stage = stage;
    }

    private static Account buttonLogin(TextField username, TextField password){
        String usernameText = username.getText();
        String passwordText = password.getText();
        try {
            if (usernameText.isEmpty()) {
                LoginScene.setErrorText("Please enter correct username");
            }
            else if (passwordText.isEmpty()) {
                LoginScene.setErrorText("Please enter correct password");
            }
            else{
                return accountController.loginAccount(username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void show(){
        // ELEMENT 1 : logo instag sama black box
        ImageView logoName = imageSet.setImages("/images/logoName.png", 200, 100);
        Rectangle signBox = new Rectangle(300, 400);
        signBox.setId("signBox");
        VBox element1 = new VBox(logoName, signBox);
        element1.setSpacing(-15);
        element1.setAlignment(Pos.CENTER);



        //ELEMENT 2  : logo, username, pw, login, to regis
        ImageView appLogo = imageSet.setImages("/images/AppLogo.png", 70, 70);
        
        TextField username = new TextField();
        username.setId("input");
        username.setPromptText("Username");
        ImageView userLogo = imageSet.setImages("/images/userLogo.png", 30, 30);
        
        PasswordField password = new PasswordField();
        password.setId("input");
        password.setPromptText("Password");
        ImageView pw = imageSet.setImages("/images/password.png", 30, 30);

        Label warning = new Label();
        warning.setId("warningText");

        HBox input1 = new HBox(userLogo, username);
        input1.setAlignment(Pos.CENTER);
        input1.setSpacing(10);
        HBox input2 = new HBox(pw, password);
        input2.setAlignment(Pos.CENTER);
        input2.setSpacing(10);
        
        Hyperlink regislink = new Hyperlink("Create new account");
        regislink.setId("link");
        regislink.setAlignment(Pos.CENTER);
        regislink.setOnAction(e ->{
            new RegisScene(stage).show();
        });
        Button login = new Button("LOGIN");
        login.setId("basicButton");
        login.setOnAction(e -> {
            Account account = buttonLogin(username, password);
            if (account != null) {
                int id = account.getId();
                try {
                    new HomeScene(stage).show(id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }else{
                warning.setText(getErrorText());
            }
        });

        username.setOnKeyPressed(e ->{
            if (e.getCode() == KeyCode.ENTER) {
                password.requestFocus();
            }
        });

        password.setOnKeyPressed(e ->{
            if (e.getCode() == KeyCode.ENTER) {
                login.fire();
            }
        });

        
        VBox pack = new VBox(appLogo, input1, input2, login, warning, regislink);
        pack.setAlignment(Pos.CENTER);
        pack.setSpacing(25);
        StackPane element2 = new StackPane(pack);
        element2.setMargin(pack, new Insets(60, 0, 0, 0));


        //gabungkan supaya ditengah
        StackPane centerBox = new StackPane(element1, element2);
        HBox content1 = new HBox(centerBox);
        content1.setAlignment(Pos.TOP_CENTER);

        loginRoot = new StackPane(borderPane, anchorPane, content1);
        App.setShow(loginRoot);
        // ScrollPane p = new ScrollPane(loginRoot);
        stage.getScene().setRoot(loginRoot);
    }


}
