import domain.DomainController;
import gui.HomeScreenContent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class StartUp extends Application {

    private static ResourceBundle resourceBundle;

    @Override
    public void start(Stage primaryStage) {
        // DomainController creation
        DomainController domainController = new DomainController(resourceBundle);

        // Set initial scene
        Scene scene = new Scene(new HomeScreenContent(domainController));
        primaryStage.setScene(scene);

        // Set title and show app
        primaryStage.setTitle(domainController.getText("Title"));
        primaryStage.show();

        // Sets initial type
        domainController.setType("Product");

        // Add stylesheets and fonts
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Roboto");
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Open+Sans");

        // Close app
        primaryStage.setOnCloseRequest(e -> {
            domainController.closePersistency();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        // Set language
        if (args.length == 0)
            resourceBundle = ResourceBundle.getBundle("Bundle");
        else
            resourceBundle = ResourceBundle.getBundle("Bundle", new Locale(args[0]));

        // Start GUI
        Application.launch(StartUp.class, args);
    }

}
