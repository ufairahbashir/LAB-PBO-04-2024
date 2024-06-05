package tugas.Scene;

import java.sql.SQLException;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tugas.Component.Navbar;
import tugas.Utils.imageSet;

public class HomeScene {
    private Stage stage;

    public HomeScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int id) throws SQLException{
        Navbar navbar = new Navbar();
        ImageView image = imageSet.setImages("/images/homeScene.png", 470, 480);
        HBox homeRoot = new HBox(navbar.showNavbar(stage, id), image);

    
        stage.getScene().setRoot(homeRoot);
    }
}