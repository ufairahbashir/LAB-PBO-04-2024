package id.praktikum9;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InputScene {
    // Metode untuk membuat scene
    public static Scene createScene(Stage primaryStage, App app) {
        // Membuat layout VBox dengan jarak antar elemen sebesar 15 piksel
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER_LEFT); // Menyusun semua elemen di tengah secara vertikal
        layout.setId("layout-input"); // Mengatur id CSS untuk VBox

        // Membuat TextField untuk input nama dengan teks petunjuk
        TextField namaField = new TextField();
        namaField.setPromptText("Enter your name");
        namaField.setId("text-nama"); // Mengatur id CSS untuk TextField nama

        namaField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                namaField.setStyle("-fx-border-color: #007bff; -fx-border-width: 1; -fx-border-style: solid;");
            } else {
                namaField.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1; -fx-border-style: solid;");
            }
        });

        // Membuat TextField untuk input umur dengan teks petunjuk
        TextField umurField = new TextField();
        umurField.setPromptText("Enter your age");
        umurField.setId("text-umur"); // Mengatur id CSS untuk TextField umur

        umurField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                umurField.setStyle("-fx-border-color: #007bff; -fx-border-width: 1; -fx-border-style: solid;");
            } else {
                umurField.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1; -fx-border-style: solid;");
            }
        });

        // Membuat TextField untuk input alamat dengan teks petunjuk
        TextArea alamatField = new TextArea();
        alamatField.setPromptText("Enter your address");
        alamatField.setId("text-alamat"); // Mengatur id CSS untuk TextField alamat

        alamatField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                alamatField.setStyle("-fx-border-color: #007bff; -fx-border-width: 1; -fx-border-style: solid;");
            } else {
                alamatField.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1; -fx-border-style: solid;");
            }
        });
            
        

        

        // Membuat tombol simpan
        Button saveButton = new Button("Save");
        saveButton.setId("save-btn"); // Mengatur id CSS untuk tombol simpan
        // Mengatur aksi yang dilakukan saat tombol simpan ditekan
        saveButton.setOnAction(e -> {
            app.setName(namaField.getText()); // Menyimpan nama ke objek app
            app.setAdress(alamatField.getText()); // Menyimpan alamat ke objek app
            app.setAge(Integer.parseInt(umurField.getText())); // Menyimpan umur ke objek app
            // Mengganti scene ke HomeScene
            primaryStage.setScene(HomeScene.createScene(primaryStage, app));
        });

        VBox saveBox = new VBox(10, saveButton);
        saveBox.setAlignment(Pos.BASELINE_RIGHT);

        // Menambahkan label dan text field ke dalam VBox
        layout.getChildren().addAll(
            new Label("Name:"), namaField, 
            new Label("Age:"), umurField, 
            new Label("Address:"), alamatField, 
            saveBox
        );
        
        layout.setId("layoutAll"); // Mengatur id CSS untuk seluruh VBox
        layout.setPadding(new Insets(20, 30, 20, 30)); // Mengatur padding untuk VBox

        // Membuat scene dengan layout VBox, dengan ukuran 500x600 piksel
        Scene scene = new Scene(layout, 500, 600);
        scene.getStylesheets().add("/styles/stylesInputScene.css"); // Menambahkan stylesheet CSS eksternal
        return scene; // Mengembalikan scene yang sudah dibuat
    }
}
