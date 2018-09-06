package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeScreen extends AnchorPane {

    public HomeScreen() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
