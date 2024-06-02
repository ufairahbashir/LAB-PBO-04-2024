package Main;
import javafx.application.Application;
import javafx.stage.Stage;
import scenes.LoginScene;
import utils.DbInit;

public class DashboardApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        new LoginScene(primaryStage).show();
    }
    
    public static void main(String[] args) {
        DbInit.initializeDatabase();
        launch(args);
    }
}