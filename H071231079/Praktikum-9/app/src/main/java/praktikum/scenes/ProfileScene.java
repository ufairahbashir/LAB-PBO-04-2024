package praktikum.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import praktikum.controller.UserController;
import praktikum.models.User;
import praktikum.utils.UIUtil;

public class ProfileScene {
    private Stage stage;

    public ProfileScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int id) {
        AnchorPane root = new AnchorPane();
        root.getStyleClass().add("root2");

        Region rectangleHome = UIUtil.createRoundedRectangle(621, 412, 99, 55);
        rectangleHome.getStyleClass().add("rounded-rectangle");
        root.getChildren().add(rectangleHome);

        // Top bar
        Label labelTitleHome = UIUtil.createLabel("PROFILE", 28, 18);
        labelTitleHome.getStyleClass().add("label-title-home");

        Label labelTitleName = UIUtil.createLabel("Peejar", 664, 18);
        labelTitleName.getStyleClass().add("label-title-home");

        ImageView imageViewSmallLogo = UIUtil.createImageView("/images/logoPeejar.png", 21, 21, 638, 18);
        imageViewSmallLogo.getStyleClass().add("image-skillup");

        Button buttonHome = UIUtil.createButtonWithImage("/images/Home_fill2.png", 15, 45, 50, 50);
        buttonHome.setOnAction(e -> {
            HomeTest homeTest = new HomeTest(stage);
            homeTest.show(id);
        });

        Button buttonProfile = UIUtil.createButtonWithImage("/images/User_fill3.png", 18, 405, 45, 45);

        // Mendapatkan data pengguna berdasarkan ID
        User user = UserController.getUserById(id);
        
        if (user == null) {
            System.out.println("User tidak ditemukan");
            return;
        }

        /* ==> INSTANCE LAYOUT START <== */
        Label labelEmail = UIUtil.createLabel("Email", 164, 100);
        labelEmail.getStyleClass().add("label-email");

        TextField textFieldEmail = UIUtil.createTextField(user.getEmail(), 164, 120);
        textFieldEmail.setEditable(false);
        textFieldEmail.getStyleClass().add("text-field-admin");

        Label labelName = UIUtil.createLabel("Nama", 164, 160);
        labelName.getStyleClass().add("label-email");

        TextField textFieldName = UIUtil.createTextField(user.getName(), 164, 180);
        textFieldName.getStyleClass().add("text-field-admin");

        Label labelPhoneNumber = UIUtil.createLabel("Nomor Telepon", 164, 220);
        labelPhoneNumber.getStyleClass().add("label-email");

        TextField textFieldPhoneNumber = UIUtil.createTextField(user.getPhoneNumber(), 164, 240);
        textFieldPhoneNumber.getStyleClass().add("text-field-admin");

        Label labelAge = UIUtil.createLabel("Umur", 164, 280);
        labelAge.getStyleClass().add("label-email");

        TextField textFieldAge = UIUtil.createTextField(String.valueOf(user.getAge()), 164, 300);
        textFieldAge.getStyleClass().add("text-field-admin");

        Button buttonUpdate = UIUtil.createButton("Perbarui", 333, 390);
        buttonUpdate.getStyleClass().add("button-register");
        buttonUpdate.setOnAction(e -> {
            // Ambil nilai input dari text field
            String updatedName = textFieldName.getText().trim();
            String updatedPhoneNumber = textFieldPhoneNumber.getText().trim();
            String updatedAgeText = textFieldAge.getText().trim();
        
            // Ambil nilai saat ini dari user (pastikan user adalah objek yang ada dan memiliki nilai yang benar)
            String currentName = user.getName();
            String currentPhoneNumber = user.getPhoneNumber();
            int currentAge = user.getAge();
        
            boolean isUpdated = false;
        
            // Periksa perubahan nama
            if (!updatedName.isEmpty() && !updatedName.equals(currentName)) {
                user.setName(updatedName);
                isUpdated = true;
            }
        
            // Periksa perubahan nomor telepon
            if (!updatedPhoneNumber.isEmpty() && !updatedPhoneNumber.equals(currentPhoneNumber)) {
                user.setPhoneNumber(updatedPhoneNumber);
                isUpdated = true;
            }
        
            // Periksa perubahan umur
            if (!updatedAgeText.isEmpty()) {
                try {
                    int updatedAge = Integer.parseInt(updatedAgeText);
                    if (updatedAge != currentAge) {
                        user.setAge(updatedAge);
                        isUpdated = true;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid age input.");
                    return;
                }
            }
        
            if (isUpdated) {
                boolean updateSuccess = UserController.updateUser(user.getId(), user.getName(), user.getPhoneNumber(), user.getAge());
                if (updateSuccess) {
                    System.out.println("Profile updated successfully!");
                } else {
                    System.out.println("Failed to update profile.");
                }
            } else {
                System.out.println("No changes to update.");
            }
        });

        root.getChildren().addAll(labelTitleHome, labelTitleName, textFieldEmail, labelEmail, textFieldName, labelName,
                textFieldPhoneNumber, labelPhoneNumber, textFieldAge, labelAge, buttonUpdate, imageViewSmallLogo,
                buttonHome, buttonProfile);
        /* ==> INSTANCE LAYOUT END <== */

        Scene scene = new Scene(root, 740, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
    }
}
