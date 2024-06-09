package tugas.praktikum;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
    private String name = "Andi Achmad Raihan";
    private String birthday = "21 April 2005";
    private String hobby = "berburu ubur ubur";
    private String status = "taken";

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(mainMenuScene(stage));
        stage.show();
    }

    private Scene mainMenuScene(Stage stage) {
        Label judul1 = new Label("WELCOME");
        judul1.getStyleClass().add("judul");
        judul1.relocate(220, 120);

        Button btn1 = new Button("Go to Profile");
        btn1.getStyleClass().add("button");
        btn1.relocate(240, 210);
        btn1.setOnAction(e -> stage.setScene(profileScene(stage)));

        Pane root = new Pane();
        root.getChildren().addAll(judul1, btn1);
        root.getStyleClass().add("latar");
        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
        stage.setTitle("App");
        return scene;
    }

    private Scene profileScene(Stage stage) {
        Label profil = new Label("PROFILE");
        profil.getStyleClass().add("judul");
        profil.relocate(250, 50);

        Label hasilNama = new Label("Name: " + name);
        hasilNama.getStyleClass().add("input");
        hasilNama.relocate(90, 120);

        Label hasilDate = new Label("Birthday: " + birthday);
        hasilDate.getStyleClass().add("input");
        hasilDate.relocate(90, 160);

        Label hasilHobby = new Label("Hobby: " + hobby);
        hasilHobby.getStyleClass().add("input");
        hasilHobby.relocate(90, 200);

        Label hasilStatus = new Label("Status: " + status);
        hasilStatus.getStyleClass().add("input");
        hasilStatus.relocate(90, 240);

        Button back = new Button("Back");
        back.getStyleClass().add("buttonS");
        back.relocate(440, 340);
        back.setOnAction(e -> stage.setScene(mainMenuScene(stage)));

        Pane root = new Pane();
        root.getChildren().addAll(profil, back, hasilNama, hasilDate, hasilHobby, hasilStatus);
        root.getStyleClass().add("latar");
        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
