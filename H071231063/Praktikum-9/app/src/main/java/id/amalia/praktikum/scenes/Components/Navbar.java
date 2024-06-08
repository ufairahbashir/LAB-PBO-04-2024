package id.amalia.praktikum.scenes.Components;

import id.amalia.praktikum.scenes.LoginScene;
import id.amalia.praktikum.scenes.User_scene.HomeScene;
import id.amalia.praktikum.scenes.User_scene.ProfileScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Navbar {
    public VBox getUserNavbar(Stage stage, int id) {
        /* ==> INSTANCE LAYOUT START <== */

        Image logoApp = new Image(getClass().getResourceAsStream("/images/Logo.png"));
        ImageView logoViewApp = new ImageView(logoApp);
        logoViewApp.setFitWidth(50);
        logoViewApp.setFitHeight(50);

        Image space = new Image(getClass().getResourceAsStream("/images/navbar-icon/Space.png"));
        ImageView spaceView = new ImageView(space);
        spaceView.setFitWidth(30);
        spaceView.setFitHeight(30);

        Button buttonHome = new Button();
        Image homeIcon = new Image(getClass().getResourceAsStream("/images/navbar-icon/HomeIcon.png"));
        ImageView homeIconView = new ImageView(homeIcon);
        homeIconView.setFitWidth(30);
        homeIconView.setFitHeight(30);
        buttonHome.setGraphic(homeIconView);
        buttonHome.getStyleClass().add("navbarbutton");
        
        Button buttonProfile = new Button();
        Image profileIcon = new Image(getClass().getResourceAsStream("/images/navbar-icon/ProfileIcon.png"));
        ImageView profileIconView = new ImageView(profileIcon);
        profileIconView.setFitWidth(30);
        profileIconView.setFitHeight(30);
        buttonProfile.setGraphic(profileIconView);
        buttonProfile.getStyleClass().add("navbarbutton");

        Button buttonLogout = new Button();
        Image logoutIcon = new Image(getClass().getResourceAsStream("/images/navbar-icon/LogoutIcon.png"));
        ImageView logoutIconView = new ImageView(logoutIcon);
        logoutIconView.setFitWidth(30);
        logoutIconView.setFitHeight(30);
        buttonLogout.setGraphic(logoutIconView);
        buttonLogout.getStyleClass().add("navbarbutton");

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        VBox navbar = new VBox(logoViewApp, spaceView, buttonHome, buttonProfile, spacer, buttonLogout);
        navbar.setPrefWidth(90);
        navbar.setPrefHeight(580);
        navbar.setAlignment(Pos.CENTER);
        navbar.setPadding(new Insets(10, 0, 10, 0));
        navbar.getStyleClass().add("navbar");
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        // Button Home
        buttonHome.setOnMouseEntered(e -> {
            Image homeIconHover = new Image(getClass().getResourceAsStream("/images/navbar-icon/HomeIconVerify.png"));
            homeIconView.setImage(homeIconHover);
        });

        buttonHome.setOnMouseExited(e -> {
            homeIconView.setImage(homeIcon);
        });

        buttonHome.setOnAction(e -> {
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show(id);
        });

        // Button Profile
        buttonProfile.setOnMouseEntered(e -> {
            Image profileIconHover = new Image(getClass().getResourceAsStream("/images/navbar-icon/ProfileIconVerify.png"));
            profileIconView.setImage(profileIconHover);
        });

        buttonProfile.setOnMouseExited(e -> {
            profileIconView.setImage(profileIcon);
        });

        buttonProfile.setOnAction(e -> {
            ProfileScene profileScene = new ProfileScene(stage);
            profileScene.show(id);
        });

        // Button Logout
        buttonLogout.setOnMouseEntered(e -> {
            Image logoutIconHover = new Image(getClass().getResourceAsStream("/images/navbar-icon/LogoutIconVerify.png"));
            logoutIconView.setImage(logoutIconHover);
        });

        buttonLogout.setOnMouseExited(e -> {
            logoutIconView.setImage(logoutIcon);
        });

        buttonLogout.setOnAction(e -> {
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
        });
        return navbar;
    }


}