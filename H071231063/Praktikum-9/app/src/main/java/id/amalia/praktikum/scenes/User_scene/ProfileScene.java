package id.amalia.praktikum.scenes.User_scene;
import id.amalia.praktikum.controllers.UserController;
import id.amalia.praktikum.scenes.Components.Navbar;
import id.amalia.praktikum.models.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ProfileScene {
    private Stage stage;

    public ProfileScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int id) {
        // Get user data by id
        User user = UserController.getUserById(id);
        
        if (user == null) {
            // Handle the case when the user is not found
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("User Not Found");
            alert.setContentText("The user with the provided ID does not exist.");
            alert.showAndWait();
            return;
        }

        /* ==> INSTANCE LAYOUT START <== */
        Label labelTitle = new Label("Profil Anda");
        labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        labelTitle.getStyleClass().add("title");

        Label labelUsername = new Label("Username");
        labelUsername.getStyleClass().add("text");
        TextField textFieldUsername = new TextField(user.getUsername());
        textFieldUsername.getStyleClass().add("profileField");
        VBox vBoxUsername = new VBox(labelUsername, textFieldUsername);

        Label labelName = new Label("Nama");
        labelName.getStyleClass().add("text");
        TextField textFieldName = new TextField(user.getName());
        textFieldName.getStyleClass().add("profileField");
        VBox vBoxName = new VBox(labelName, textFieldName);

        Label labelAge = new Label("Umur");
        labelAge.getStyleClass().add("text");
        TextField textFieldAge = new TextField(String.valueOf(user.getAge()));
        textFieldAge.getStyleClass().add("profileField");
        VBox vBoxAge = new VBox(labelAge, textFieldAge);

        Label labelPhoneNumber = new Label("Nomor Telepon");
        labelPhoneNumber.getStyleClass().add("text");
        TextField textFieldPhoneNumber = new TextField(user.getPhoneNumber());
        textFieldPhoneNumber.getStyleClass().add("profileField");
        VBox vBoxPhoneNumber = new VBox(labelPhoneNumber, textFieldPhoneNumber);

        Label labelEmail = new Label("Email");
        labelEmail.getStyleClass().add("text");
        TextField textFieldEmail = new TextField(user.getEmail());
        textFieldEmail.setEditable(false);
        textFieldEmail.getStyleClass().add("profileField");
        VBox vBoxEmail = new VBox(labelEmail, textFieldEmail);        
        
        Button buttonUpdate = new Button("Perbarui Profil");
        buttonUpdate.setPrefWidth(200);
        buttonUpdate.getStyleClass().add("profileUpdateButton");

        VBox vBoxDetailProfile = new VBox(vBoxUsername, vBoxName, vBoxAge, vBoxPhoneNumber, vBoxEmail, buttonUpdate);
        vBoxDetailProfile.setSpacing(20);
        vBoxDetailProfile.setPadding(new Insets(30, 80, 0, 80)); 
        vBoxDetailProfile.setAlignment(Pos.CENTER);

        VBox vBoxMainContent = new VBox(labelTitle, vBoxDetailProfile);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setPrefWidth(500);
        vBoxMainContent.setSpacing(10);  
        vBoxMainContent.getStyleClass().add("scene");
        
        Image imagePraktikum = new Image(getClass().getResourceAsStream("/images/LB.png"));
        ImageView imageViewPraktikum = new ImageView(imagePraktikum);
        imageViewPraktikum.setPreserveRatio(true);
        imageViewPraktikum.setFitWidth(500);
        imageViewPraktikum.setFitHeight(580);

        VBox vBoxImagePraktikum = new VBox(imageViewPraktikum);
        vBoxImagePraktikum.setAlignment(Pos.CENTER);
        vBoxImagePraktikum.setBackground(new Background(new BackgroundFill(Color.web("#090f30"), null, null)));

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getUserNavbar(stage, id), vBoxMainContent, vBoxImagePraktikum);
        HBox root = new HBox(hBoxContent);
        stage.getScene().setRoot(root);
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        buttonUpdate.setOnAction(e -> {
            // Get values from text fields
            String username = textFieldUsername.getText();
            String name = textFieldName.getText();
            String phoneNumber = textFieldPhoneNumber.getText();
            int age = Integer.parseInt(textFieldAge.getText());

            // Update the user
            boolean isSuccessfulUpdateUser = UserController.updateUser(id, username, name, age, phoneNumber, user.getEmail());
            if (isSuccessfulUpdateUser) {
                HomeScene homeScene = new HomeScene(stage);
                homeScene.show(id);
            }
        });


        /* ==> BUTTON ACTION END <== */
        textFieldUsername.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                buttonUpdate.fire();
            }
        });

        textFieldName.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                buttonUpdate.fire();
            }
        });

        textFieldAge.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                buttonUpdate.fire();
            }
        });

        textFieldPhoneNumber.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                buttonUpdate.fire();
            }
        });
        /* ==> KEY ACTION END <== */
    }


    
    protected void show() {}
}
