import domain.ProductManager;
import gui.HomeScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ProductManager productManager = new ProductManager();
        // Set initial scene
        Scene scene = new Scene(new HomeScreen<>(productManager, "Product"));
        primaryStage.setScene(scene);

        // Set title and show app
        primaryStage.setTitle("Allergens");
        primaryStage.show();

        // Add stylesheets and fonts
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Roboto");
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Open+Sans");

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
