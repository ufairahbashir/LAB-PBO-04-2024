package id.praktikum9;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ProfileScene {
    public static Scene createScene(Stage primaryStage, App app) {
        // Membuat HBox dengan jarak antar elemen sebesar 20
        HBox mainLayout = new HBox(20);
        mainLayout.setPadding(new javafx.geometry.Insets(35)); // Menambahkan padding
        mainLayout.setAlignment(Pos.CENTER); // Menyusun elemen secara horizontal di tengah

        mainLayout.setId("main-layout"); // Mengatur warna latar belakang

        // Membuat ImageView untuk menampilkan gambar profil
        Image profileImage = new Image("/image/IMG_5871.jpg");
        ImageView profileImageView = new ImageView(profileImage);
        profileImageView.setFitHeight(156);
        profileImageView.setFitWidth(140);

        Rectangle clip = new Rectangle(140, 155);
        clip.setArcWidth(45);
        clip.setArcHeight(45);
        profileImageView.setClip(clip);

        // Membungkus ImageView dalam StackPane untuk menambahkan latar belakang dengan radius
        StackPane imageContainer = new StackPane(profileImageView);
        imageContainer.setId("image");
        imageContainer.setPrefSize(140, 155);

        // Menambahkan imageContainer langsung ke mainLayout
        mainLayout.getChildren().add(imageContainer);

        // Membuat VBox untuk teks dengan jarak antar elemen sebesar 20
        VBox textLayout = new VBox(20);
        textLayout.setAlignment(Pos.CENTER_LEFT); // Menyusun teks secara vertikal di kiri

        // Membuat label untuk nama, usia, dan alamat
        Label namaLabel = new Label("Name\t:\n " + app.getName());
        namaLabel.setId("name-label");

        Label umurLabel = new Label("Age\t\t:\n " + app.getAge());
        umurLabel.setId("umur-label");

        Label alamatLabel = new Label("Address  :\n\t " + app.getAdress());
        alamatLabel.setId("alamat-label");
        alamatLabel.setMaxWidth(300);
        alamatLabel.setWrapText(true);

        // Menambahkan label ke textLayout
        textLayout.getChildren().addAll(namaLabel, umurLabel, alamatLabel);

        // Menambahkan textLayout ke mainLayout
        mainLayout.getChildren().add(textLayout);

        mainLayout.getStylesheets().add("/styles/stylesProfileScene.css");

        // Membuat tombol kembali ke HomeScene
        Button backButton = new Button("Back to Home");
        backButton.setId("back-btn");
        backButton.setOnAction(e -> primaryStage.setScene(HomeScene.createScene(primaryStage, app)));

        // Membuat VBox utama untuk layout keseluruhan
        VBox layout = new VBox(20);
        layout.setPadding(new javafx.geometry.Insets(20));
        layout.setAlignment(Pos.CENTER); // Menyusun seluruh layout di tengah
        layout.getChildren().addAll(mainLayout, backButton);
        layout.setId("layout"); // Mengatur warna latar belakang

        Scene scene = new Scene(layout, 500, 600);
        scene.getStylesheets().add("/styles/stylesProfileScene.css");

        // Mengembalikan Scene yang sudah dibuat
        return scene;
    }
}
