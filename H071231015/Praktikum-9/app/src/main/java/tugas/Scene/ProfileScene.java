package tugas.Scene;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tugas.Component.Navbar;
import tugas.Controller.accountController;
import tugas.Models.Account;
import tugas.Utils.imageSet;

public class ProfileScene {
    private Stage stage;
    private static final double photoSize = 100;

    public static double getPhotosize() {
        return photoSize;
    }

    public ProfileScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int id) throws SQLException{
        Account account = accountController.showUserProfile(id);

        ImageView profileBackground = imageSet.setImages("/images/profile/template.png", 470, 480);

        ImageView photoProfile = imageSet.setImages(account.getPhotoFile(), getPhotosize(), getPhotosize());
        ImageView border = imageSet.setImages("/images/profile/border.png", getPhotosize(), getPhotosize());
        StackPane imageCombine = new StackPane(photoProfile, border);
        imageCombine.setAlignment(Pos.CENTER_LEFT);
        Button uploadPhoto = new Button();
        uploadPhoto.setGraphic(imageCombine);
        uploadPhoto.setId("upload");
        uploadPhoto.setOnAction(e->{
            try {
                if (accountController.updateAccount(id, account.getEmail(), account.getUsername(), account.getName(), account.getPasswowrd())) {
                    try {
                        new ProfileScene(stage).show(id);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            System.out.println("drtyui");
        });


        Label username = new Label(account.getUsername());
        username.setId("profileUsername");
        Label name = new Label(account.getName());
        name.setId("profileName");

        VBox profile = new VBox(username, uploadPhoto, name);
        profile.setSpacing(20);
        profile.setPadding(new Insets(20, 0, 0, 20));

        StackPane element1 = new StackPane(profileBackground, profile);
        





        Navbar navbar = new Navbar();
        HBox profileRoot = new HBox(navbar.showNavbar(stage, id), element1);

    
        stage.getScene().setRoot(profileRoot);
    }
}
