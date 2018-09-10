package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import domain.DomainController;
import domain.Product;
import domain.ProductManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Detail screen.
 */
public class DetailScreen extends AnchorPane {

    private Stage stage;
    private final DomainController domainController;
    private final ProductManager productManager;
    private Object item;
    @FXML
    private Text txtTitle;
    @FXML
    private JFXTextField tfName;
    @FXML
    private JFXListView<Object> lvSelectableItems;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private Text txtSelectMultiple;

    /**
     * Instantiates a new Detail screen.
     *
     * @param domainController the domain controller
     * @param item             the item (can be an empty new item)
     */
    public DetailScreen(final DomainController domainController, Object item) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailScreen.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        this.domainController = domainController;
        this.productManager = domainController.getProductManager();
        this.item = item;

        fillList();
        setText();
    }

    // Fills list according to type
    private void fillList() {
        if (item instanceof Product) {
            // TODO - Implement
        } else {
            // TODO - Implement
        }
    }

    // Sets all text items according to type
    // Also fills fields if given item isn't new
    private void setText() {
        if (item instanceof Product) {
            // TODO - Implement
            // Fills fields
        } else {
            // TODO - Implement
            // Fills fields
        }
    }

    /**
     * Cancels all changes and closes window.
     *
     * @param event the event
     */
    @FXML
    void handleCancel(ActionEvent event) {
        stage = (Stage) this.getScene().getWindow();
        stage.close();
    }

    /**
     * Saves item and closes window.
     *
     * @param event the event
     */
    @FXML
    void handleSave(ActionEvent event) {
        if (item instanceof Product) {
            // TODO - Implement
        } else {
            // TODO - Implement
        }

        // Catch exceptions!
    }

}
