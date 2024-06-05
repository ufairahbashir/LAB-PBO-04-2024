package tugas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import tugas.Scene.HomeScene;
import tugas.Scene.LoginScene;

public class App extends Application {
    final private static int width = 640;
    final private static int height = 480;
    public static int getWidth() {return width;}
    public static int getHeight() {return height;}

    public static void setShow(StackPane root) {
        LinearGradient gradient = new LinearGradient(
                0, 0, 0, 1,
                true, CycleMethod.NO_CYCLE,
                new Stop(0.0, Color.rgb(191, 90, 242)), // Warna ungu tua
                new Stop(0.2, Color.rgb(212, 80, 212)), // Warna ungu
                new Stop(0.4, Color.rgb(236, 64, 164)), // Warna merah muda tua
                new Stop(0.6, Color.rgb(255, 82, 82)), // Warna merah
                new Stop(0.8, Color.rgb(255, 140, 0)), // Warna oranye
                new Stop(1.0, Color.rgb(255, 204, 0)) // Warna kuning
        );
    
        root.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    Image icon = new Image(getClass().getResourceAsStream("/images/AppLogo.png"));
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane mainRoot = new StackPane();
        setShow(mainRoot);

        
        Scene scene = new Scene(mainRoot, width, height);
        scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
        

        primaryStage.setTitle("Instagram");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.show();
        // new HomeScene(primaryStage).show(1);
        new LoginScene(primaryStage).show();
        // new RegisScene(primaryStage).show();
        // new Testscene(primaryStage).show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
