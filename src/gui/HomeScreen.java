package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import domain.DomainController;
import domain.ProductManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class HomeScreen<T> extends AnchorPane {

    private final DomainController domainController;
    private final ProductManager productManager;
    private String type;
    @FXML
    private Text txtTitle;
    @FXML
    private JFXListView<T> lvItemList;
    @FXML
    private JFXButton btnItem3;
    @FXML
    private JFXButton btnItem2;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnAlter;
    @FXML
    private JFXButton btnDelete;

    public HomeScreen(final DomainController domainController, String type) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void handleAddItem(ActionEvent event) {
        // TODO - Implement
    }

    @FXML
    void handleAlterItem(ActionEvent event) {
        // TODO - Implement
    }

    @FXML
    void handleDeleteItem(ActionEvent event) {
        // TODO - Implement
    }

    @FXML
    void handleItem2(ActionEvent event) {
        // TODO - Implement
    }

    @FXML
    void handleItem3(ActionEvent event) {
        // TODO - Implement
    }
}
