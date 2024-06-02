package tugas.praktikum;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    private Map<String, String> userCredentials = new HashMap<>();
    private Map<String, String> userProfiles = new HashMap<>();
    private String currentLoggedInUser;
    private String username;
    private String password;
    private String name;
    private String date;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(mainMenuScene(stage));
        stage.show();
    }

    private Scene mainMenuScene(Stage stage) {
        Label judul1 = new Label("WELCOME");
        judul1.getStyleClass().add("judul");
        judul1.relocate(220, 110);

        Button btn1 = new Button("Login");
        btn1.getStyleClass().add("button");
        btn1.relocate(240, 210);
        
        btn1.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, new CornerRadii(10), null)));
        btn1.setOnAction(e -> stage.setScene(loginScene(stage)));

        Button btn2 = new Button("Register");
        btn2.getStyleClass().add("button");
        btn2.relocate(240, 270);
        btn2.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, new CornerRadii(10), null)));
        btn2.setOnAction(e -> stage.setScene(registerScene(stage)));

        Pane root = new Pane();
        root.getChildren().addAll(judul1, btn1, btn2);
        root.getStyleClass().add("latar");
        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        stage.setTitle("NEOPITS");
        return scene;
    }

    private Scene registerScene(Stage stage) {
        Label registerLabel = new Label("REGISTER");
        registerLabel.getStyleClass().add("judul");
        HBox regis = new HBox(registerLabel);
        regis.setPadding(new Insets(0,0,0,155));

        Label nama1 = new Label("Name");
        TextField nama2 = new TextField();
        nama1.getStyleClass().add("input");
        nama1.relocate(90, 140);
        nama2.relocate(190, 140);
        nama2.getStyleClass().add("tabelInput");

        Label dateLabel = new Label("Birthday");
        TextField dateField = new TextField();
        dateLabel.getStyleClass().add("input");
        dateLabel.relocate(90, 180);
        dateField.relocate(190, 180);
        dateField.getStyleClass().add("tabelInput");

        Label usernama1 = new Label("Username");
        TextField usernama2 = new TextField();
        usernama1.getStyleClass().add("input");
        usernama1.relocate(90, 220);
        usernama2.relocate(190, 220);
        usernama2.getStyleClass().add("tabelInput");

        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordLabel.getStyleClass().add("input");
        passwordLabel.relocate(90, 260);
        passwordField.relocate(190, 260);
        passwordField.getStyleClass().add("tabelInput");

        VBox text = new VBox(16, nama2, dateField, usernama2, passwordField);
        VBox label = new VBox(25, nama1, dateLabel, usernama1, passwordLabel);
        HBox regisHBox = new HBox(10,label, text);

        VBox label2 = new VBox(5, regis, regisHBox);

        Label salah1 = new Label();
        salah1.getStyleClass().add("error");
        salah1.relocate(190, 300);

        Button submit = new Button("Regist");
        submit.getStyleClass().add("buttonS");
        submit.relocate(440, 320);
        submit.setOnAction(e -> {
            name = nama2.getText();
            date = dateField.getText();
            username = usernama2.getText();
            password = passwordField.getText();
            if (name.isEmpty() || date.isEmpty() || username.isEmpty() || password.isEmpty()) {
                salah1.setText("Please fill in all fields");
                salah1.getStyleClass().add("warning");
                salah1.relocate(410, 290);
            } else if (password.length() < 8) {
                salah1.setText("Password must be at least 8 characters");
                salah1.getStyleClass().add("warning");
                salah1.relocate(190, 290);
            } else {
                userCredentials.put(username, password);
                userProfiles.put(username, name + ", Birthday\t: " + date);
                stage.setScene(registerSuccess(stage));
            }
        });

        Button back = new Button("Back");
        back.getStyleClass().add("buttonB");
        back.relocate(320, 320);
        back.setOnAction(e -> stage.setScene(mainMenuScene(stage)));

        HBox buton = new HBox(back, salah1, submit);
        buton.setPadding(new Insets(20,0,0,250));
        VBox all = new VBox(20,label2, buton);
        all.setPadding(new Insets(80,0,0,90));

        Pane root = new Pane();
        root.getChildren().addAll(all);
        root.getStyleClass().add("latar");
        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        return scene;
    }

    private Scene registerSuccess(Stage stage) {
        Label success = new Label("Registration Successful");
        success.getStyleClass().add("judul");
        success.relocate(110, 150);

        Button back = new Button("Back");
        back.getStyleClass().add("buttonB");
        back.relocate(270, 250);
        back.setOnAction(e -> stage.setScene(mainMenuScene(stage)));

        Pane root = new Pane();
        root.getChildren().addAll(success, back);
        root.getStyleClass().add("latar");
        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        return scene;
    }

    private Scene loginScene(Stage stage) {
        Label loginLabel = new Label("LOGIN");
        loginLabel.getStyleClass().add("judul");
        HBox login = new HBox(loginLabel);
        login.setPadding(new Insets(0,0,0,175));

        Label usernameLogin1 = new Label("Username");
        TextField usernameLogin2 = new TextField();
        usernameLogin1.getStyleClass().add("input");
        usernameLogin1.relocate(90, 200);
        usernameLogin2.relocate(190, 200);
        usernameLogin2.getStyleClass().add("tabelInput");

        Label passLogin = new Label("Password");
        PasswordField passwordFieldLogin = new PasswordField();
        passLogin.getStyleClass().add("input");
        passLogin.relocate(90, 240);
        passwordFieldLogin.relocate(190, 240);
        passwordFieldLogin.getStyleClass().add("tabelInput");

        VBox labell = new VBox(25,usernameLogin1, passLogin);
        VBox textt = new VBox(16,usernameLogin2, passwordFieldLogin);
        HBox input = new HBox(10,labell, textt);
        
        Label salah2 = new Label();
        salah2.getStyleClass().add("error");
        salah2.relocate(190, 300);
        
        Button submit1 = new Button("Login");
        submit1.getStyleClass().add("buttonS");
        submit1.relocate(440, 300);
        submit1.setOnAction(e -> {
            String username = usernameLogin2.getText();
            String password = passwordFieldLogin.getText();

            if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
                currentLoggedInUser = username;
                stage.setScene(profileScene(stage));
            } else {
                salah2.setText("Invalid username or password");
                salah2.getStyleClass().add("warning");
                salah2.relocate(330, 267);
            }
        });

        Button back = new Button("Back");
        back.getStyleClass().add("buttonB");
        back.relocate(320, 300);
        back.setOnAction(e -> stage.setScene(mainMenuScene(stage)));

        HBox butonn = new HBox(back, submit1, salah2);
        butonn.setPadding(new Insets(0,0,0,250));
        VBox allBox = new VBox(20,login, input, butonn);
        allBox.setAlignment(Pos.CENTER);
        allBox.setPadding(new Insets(80,0,0,90));

        Pane root = new Pane();
        root.getChildren().addAll(allBox);
        root.getStyleClass().add("latar");
        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        return scene;
    }

    private Scene profileScene(Stage stage) {
        Label profil = new Label("PROFILE");
        profil.getStyleClass().add("judul");
        profil.relocate(250, 80);

        String[] profileDetails = userProfiles.get(currentLoggedInUser).split(", ");
        Label hasilNama = new Label("Name\t: " + profileDetails[0]);
        hasilNama.getStyleClass().add("input");
        hasilNama.relocate(90, 190);

        Label hasilDate = new Label("" + profileDetails[1]);
        hasilDate.getStyleClass().add("input");
        hasilDate.relocate(90, 230);

        Button back = new Button("Back");
        back.getStyleClass().add("buttonB");
        back.relocate(440, 340);
        back.setOnAction(e -> stage.setScene(mainMenuScene(stage)));

        Pane root = new Pane();
        root.getChildren().addAll(profil, back, hasilNama, hasilDate);
        root.getStyleClass().add("latar");
        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
