package id.praktikum9;


import java.io.FileInputStream;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScene {
    public static Scene createScene(Stage primaryStage, App app) {
        VBox layout = new VBox(20);
        layout.setAlignment(javafx.geometry.Pos.CENTER); 
        layout.setId("layout-home");

        Button tambahBotton = new Button("");
        tambahBotton.setMaxWidth(40);
        tambahBotton.setMaxHeight(40);
        tambahBotton.setId("input-btn");


        tambahBotton.setOnAction(e -> {
            try{
                primaryStage.setScene(InputScene.createScene(primaryStage, app));
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        try{
            FileInputStream iconStream = new FileInputStream("src/main/resources/image/tambahProfile3.png");
            Image iconTambah = new Image(iconStream);

            ImageView imageView1 = new ImageView(iconTambah);
            imageView1.setFitHeight(90);
            imageView1.setFitWidth(90);
            tambahBotton.setGraphic(imageView1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // BorderPane.setAlignment(tambahBotton, Pos.CENTER);
        // BorderPane.setMargin(tambahBotton, new Insets(10));


        Button profileButton = new Button("");
        profileButton.setMaxWidth(50);
        profileButton.setMaxHeight(50);
        profileButton.setId("profile-btn");
        profileButton.setOnAction(e -> {
            try{
                primaryStage.setScene(ProfileScene.createScene(primaryStage, app));
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        try{
            FileInputStream iconStream = new FileInputStream("src/main/resources/image/profile2.png");
            Image iconProfile = new Image(iconStream);

            ImageView imageView2 = new ImageView(iconProfile);
            imageView2.setFitHeight(90);
            imageView2.setFitWidth(90);
            profileButton.setGraphic(imageView2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        HBox hboxButtons = new HBox(40);
        hboxButtons.setAlignment(Pos.CENTER);
        hboxButtons.getChildren().addAll(tambahBotton, profileButton);

        StackPane buttonPane = new StackPane(hboxButtons);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setPadding(new javafx.geometry.Insets(30, 0, 0, 0));


        Button logoutButton = new Button("Logout");
        logoutButton.setId("logout-btn");
        logoutButton.setOnAction(e -> primaryStage.setScene(LoginScene.createScene(primaryStage, app)));


        layout.getChildren().addAll(hboxButtons, logoutButton);

        Scene scene = new Scene(layout, 500, 600);
        scene.getStylesheets().add("/styles/stylesHomeScene.css");
        return scene;
    }
}
