package tugas.Component;

import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tugas.Controller.accountController;
import tugas.Models.Account;
import tugas.Scene.HomeScene;
import tugas.Scene.LoginScene;
import tugas.Scene.ProfileScene;
import tugas.Utils.imageSet;

public class Navbar {
    private static final int widthLogo = 20;
    private static final int heightLogo = 20;
    public static int getWidthlogo() {
        return widthLogo;
    }
    public static int getHeightlogo() {
        return heightLogo;
    }
    public HBox showNavbar(Stage stage, int id) throws SQLException{
        Account account = accountController.showUserProfile(id);
        //ELEMENT 1 : all button

        ImageView homeLogo = imageSet.setImages("/images/menu/home.png", getWidthlogo(), getHeightlogo());
        Button homeButton = new Button("Home");
        // homeButton.setOnAction(e -> DatabaseConfig.uploadPhoto());
        homeButton.setId("buttonMenu");
        homeButton.setGraphic(homeLogo);

        ImageView searchLogo = imageSet.setImages("/images/menu/search.png", getWidthlogo(), getHeightlogo());
        Button searchButton = new Button("Search");
        searchButton.setId("buttonMenu");
        searchButton.setGraphic(searchLogo);
        searchButton.setOnMouseClicked(null);

        ImageView exploreLogo = imageSet.setImages("/images/menu/explore.png", getWidthlogo(), getHeightlogo());
        Button exploreButton = new Button("Explore");
        exploreButton.setId("buttonMenu");
        exploreButton.setGraphic(exploreLogo);

        ImageView reelsLogo = imageSet.setImages("/images/menu/reels.png", getWidthlogo(), getHeightlogo());
        Button reelsButton = new Button("Reels");
        reelsButton.setId("buttonMenu");
        reelsButton.setGraphic(reelsLogo);

        ImageView messagesLogo = imageSet.setImages("/images/menu/messages.png", getWidthlogo(), getHeightlogo());
        Button messagesButton = new Button("Messsages");
        messagesButton.setId("buttonMenu");
        messagesButton.setGraphic(messagesLogo);

        ImageView notificationsLogo = imageSet.setImages("/images/menu/notifications.png", getWidthlogo(), getHeightlogo());
        Button notificationsButton = new Button("Notifications");
        notificationsButton.setId("buttonMenu");
        notificationsButton.setGraphic(notificationsLogo);

        ImageView createLogo = imageSet.setImages("/images/menu/create.png", getWidthlogo(), getHeightlogo());
        Button createButton = new Button("Create");
        createButton.setId("buttonMenu");
        // createButton.setGraphic(DatabaseConfig.showPhotoFromDatabase());
        createButton.setGraphic(createLogo);

        // ImageView profileLogo = account.getPhotoFile();
        ImageView profileLogo = imageSet.setImages(account.getPhotoFile(), getWidthlogo(), getHeightlogo());
        Button profileButton = new Button("Profile");
        profileButton.setId("buttonMenu");
        profileButton.setGraphic(profileLogo);

        ImageView appName = imageSet.setImages("/images/logoName.png", 150, 75);
        Button back = new Button();
        back.setId("upload");
        back.setGraphic(appName);


        VBox element1 = new VBox(5, back, homeButton, searchButton, exploreButton, reelsButton, messagesButton, notificationsButton, createButton, profileButton);
        // element1.setId("res");
        // element1.getStyleClass().add("res");
        element1.setPadding(new Insets(0, 0, 0,10));



        //ELEMENT2
        Label navbarLabel = new Label();
        navbarLabel.setId("navbarLabel");
        VBox element2 = new VBox(navbarLabel);


        StackPane navbarCombine = new StackPane(element2, element1);
        HBox navbar = new HBox(navbarCombine);


        back.setOnAction(e->{
            new LoginScene(stage).show();
        });


        homeButton.setOnAction(e->{
            try {
                new HomeScene(stage).show(id);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        
        profileButton.setOnAction(e->{
            try {
                new ProfileScene(stage).show(id);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });
        return navbar;
    }
}
