package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DashboardScene {

    private Stage primaryStage;

    public DashboardScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        primaryStage.setTitle("Dashboard");

        // Sidebar
        VBox sidebar = new VBox(20);
        sidebar.setPadding(new Insets(20));
        sidebar.setStyle("-fx-background-color: #2C2C54;");
        sidebar.setPrefWidth(250);

        // Sidebar content
        Label workbenchLabel = createSidebarLabel("Workbench");
        Label filtersLabel = createSidebarLabel("Filters");
        Label managementLabel = createSidebarLabel("Management");
        Label unlockLabel = createSidebarLabel("Unlock");
        Label mapLabel = createSidebarLabel("Map");
        Label searchLabel = createSidebarLabel("Search");
        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #E55039; -fx-text-fill: white;");
        logoutButton.setOnAction(e -> {
            new LoginScene(primaryStage).show();
            primaryStage.setResizable(false); // Make the login scene not resizable
            primaryStage.centerOnScreen();
        });

        VBox.setMargin(logoutButton, new Insets(400, 0, 0, 75));

        sidebar.getChildren().addAll(workbenchLabel, filtersLabel, managementLabel, unlockLabel, mapLabel, searchLabel, logoutButton);

        // Main content
        VBox mainContent = new VBox(20);
        mainContent.setPadding(new Insets(20));
        mainContent.setStyle("-fx-background-color: #f4f7fc;");

        Label welcomeLabel = new Label("Hello, There!");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label subtitleLabel = new Label("Welcome to the dashboard! Remember to stay productive.");
        subtitleLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #888888;");

        HBox statsBox = new HBox(20);

        // Example stats
        VBox stat1 = createStatBox("510", "Go On", "#6A89CC");
        VBox stat2 = createStatBox("210", "Intention", "#38ADA9");
        VBox stat3 = createStatBox("100", "No Intention", "#E55039");
        VBox stat4 = createStatBox("510", "Go On", "#4A69BD");
        VBox stat5 = createStatBox("1000", "Distribution", "#60A3BC");

        statsBox.getChildren().addAll(stat1, stat2, stat3, stat4, stat5);

        HBox mockupBox = new HBox(20);

        VBox airplaneBox = createMockupBox("AIR PLANE", "Rajawali Indonesia", "/images/plane.jpeg");
        VBox telephoneBox = createMockupBox("TELEPHONE", "Samsul S27 ProMax", "/images/phone.jpeg");
        VBox busBox = createMockupBox("BUS", "Rosalia Asri", "/images/bus.png");

        mockupBox.getChildren().addAll(airplaneBox, telephoneBox, busBox);

        VBox companyBox = new VBox(10);
        companyBox.setPadding(new Insets(10));
        companyBox.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10;");
        companyBox.setPrefSize(200, 200);

        Label companyTitle = new Label("Simple Dashboard UI Design");
        companyTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label companyDesc = new Label("This is a simple dashboard UI design created using JavaFX. The design is clean and minimalistic.");
        companyDesc.setWrapText(true);
        companyDesc.setStyle("-fx-font-size: 14px; -fx-text-fill: #888888;");

        Button unlockButton = new Button("Unlock");
        unlockButton.setStyle("-fx-background-color: #2C2C54; -fx-text-fill: white; -fx-background-radius: 5;");

        companyBox.getChildren().addAll(companyTitle, companyDesc, unlockButton);

        mainContent.getChildren().addAll(welcomeLabel, subtitleLabel, statsBox, mockupBox, companyBox);

        // Root layout
        HBox root = new HBox();
        root.getChildren().addAll(sidebar, mainContent);

        Scene dashboardScene = new Scene(root, 1200, 800);
        primaryStage.setScene(dashboardScene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private Label createSidebarLabel(String text) {
        Label label = new Label(text);
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-font-size: 18px;");
        return label;
    }

    private VBox createStatBox(String number, String description, String color) {
        VBox box = new VBox(10);
        box.setPadding(new Insets(20));
        box.setAlignment(Pos.CENTER);
        box.setStyle("-fx-background-color: " + color + "; -fx-background-radius: 10;");
        box.setPrefSize(150, 150);

        Label numberLabel = new Label(number);
        numberLabel.setTextFill(Color.WHITE);
        numberLabel.setStyle("-fx-font-size: 20px;");

        Label descriptionLabel = new Label(description);
        descriptionLabel.setTextFill(Color.WHITE);
        descriptionLabel.setStyle("-fx-font-size: 14px;");

        box.getChildren().addAll(numberLabel, descriptionLabel);
        return box;
    }

    private VBox createMockupBox(String title, String subtitle, String imagePath) {
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));
        box.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10;");
        box.setPrefSize(200, 100);

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label subtitleLabel = new Label(subtitle);
        subtitleLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #888888;");

        box.getChildren().addAll(imageView, titleLabel, subtitleLabel);
        return box;
    }
}