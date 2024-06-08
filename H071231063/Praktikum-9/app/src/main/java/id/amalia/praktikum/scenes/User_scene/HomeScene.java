package id.amalia.praktikum.scenes.User_scene;
import id.amalia.praktikum.controllers.UserController;
import id.amalia.praktikum.models.User;
import id.amalia.praktikum.scenes.Components.Navbar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomeScene {
    private Stage stage;

    public HomeScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int id) {
    
        User user = UserController.getUserById(id);

        /* ==> INSTANCE LAYOUT START <== */
        Label labelTitle = new Label("Beranda");
        labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        labelTitle.getStyleClass().add("title");
        Label labelWelcome = new Label("Selamat Datang di Tugas Praktikum");
        labelWelcome.setFont(Font.font("Sytem", FontWeight.BOLD, 28));
        labelWelcome.getStyleClass().add("text");
        Label labelName = new Label(user.getName());
        labelName.setFont(Font.font("Sytem", 22));
        labelName.getStyleClass().add("text");
        VBox vBoxWelcome = new VBox(labelWelcome, labelName);
        vBoxWelcome.setAlignment(Pos.CENTER);
        vBoxWelcome.setPadding(new Insets(145, 0, 0, 0));
        vBoxWelcome.setSpacing(5);

        VBox vBoxMainContent = new VBox(labelTitle, vBoxWelcome);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(850);
        vBoxMainContent.getStyleClass().add("scene");

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getUserNavbar(stage, id), vBoxMainContent);

        HBox root = new HBox(hBoxContent);
        stage.getScene().setRoot(root);
        /* ==> INSTANCE LAYOUT END <== */
        
    }
    protected void show() {}
}
