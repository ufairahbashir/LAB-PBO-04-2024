package tugas.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import tugas.Utils.PasswordHasher;
// import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.ByteArrayInputStream;
// import org.mindrot.jbcrypt.BCrypt;
// import org.mindrot.jbcrypt.BCrypt;
// import org.mindrot.jbcrypt.BCrypt;




public class DatabaseConfig {
    private static final String DB_URL = "jdbc:sqlite:data.db";
    private static final int ACCOUNT_ID = 1; // Ganti dengan ID akun yang diinginkan


    public static void uploadPhoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Photo");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg");
        fileChooser.getExtensionFilters().add(extFilter);

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                savePhotoToDatabase(selectedFile);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void savePhotoToDatabase(File photoFile) throws IOException, SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "CREATE TABLE IF NOT EXISTS photos (id INTEGER PRIMARY KEY AUTOINCREMENT, account_id INTEGER, photo_data BLOB, FOREIGN KEY (account_id) REFERENCES account(id))";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

            sql = "INSERT INTO photos (account_id, photo_data) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ACCOUNT_ID);

            FileInputStream fis = new FileInputStream(photoFile);
            stmt.setBinaryStream(2, fis, (int) photoFile.length());

            stmt.executeUpdate();
            System.out.println("Photo uploaded successfully!");
        }
    }

    public static ImageView showPhotoFromDatabase() throws SQLException {
        ImageView imageView = new ImageView();
    
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "SELECT photo_data FROM photos WHERE account_id = ? ORDER BY id DESC LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ACCOUNT_ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                byte[] imageData = rs.getBytes("photo_data");
                ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                Image image = new Image(bis);
                imageView.setImage(image);
            }
        }
        return imageView;
    }
}