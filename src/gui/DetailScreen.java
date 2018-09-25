package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import domain.*;
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
    private Text txtTableTitle;
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
        productManager = domainController.getProductManager();
        this.item = item;

        fillList();
        setText();
        fillFields(this.item);
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
    private void setText() {
        btnSave.setText(domainController.getText("Save"));
        btnCancel.setText(domainController.getText("Cancel"));
        txtSelectMultiple.setText(domainController.getText("selectMultiple"));
        if (item instanceof Product) {
            txtTitle.setText(domainController.getText("addProduct"));
            tfName.setPromptText(domainController.getText("nameOf") + " " + domainController.getText("Product").toLowerCase());
            txtTableTitle.setText(domainController.getText("Ingredients"));
        } else {
            txtTitle.setText(domainController.getText("addIngredient"));
            tfName.setPromptText(domainController.getText("nameOf") + " " + domainController.getText("Ingredient").toLowerCase());
            txtTableTitle.setText(domainController.getText("Allergens"));
        }
    }

    // Fills fields if given item isn't new
    private void fillFields(Object item) {
        // TODO - Implement
    }

    /**
     * Cancels all changes and closes window.
     *
     * @param event the event
     */
    @FXML
    void handleCancel(ActionEvent event) {
        stage = (Stage) getScene().getWindow();
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
