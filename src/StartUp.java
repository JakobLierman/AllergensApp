import gui.HomeScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Set initial scene
        Scene scene = new Scene(new HomeScreen());
        primaryStage.setScene(scene);

        // Set title and show app
        primaryStage.setTitle("Allergens");
        primaryStage.show();

        // Close app
        primaryStage.setOnCloseRequest(e -> {
            System.out.println("Closed");
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        Application.launch(StartUp.class, args);
    }

}
