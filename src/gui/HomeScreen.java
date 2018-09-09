package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import domain.DomainController;
import domain.ProductManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class HomeScreen extends AnchorPane {

    private final DomainController domainController;
    private final ProductManager productManager;
    @FXML
    private Text txtTitle;
    @FXML
    private JFXListView<Object> lvItemList;
    @FXML
    private JFXButton btnItem2;
    @FXML
    private JFXButton btnItem3;
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

        this.domainController = domainController;
        this.productManager = domainController.getProductManager();

        fillList(type);
        setText(type);
    }

    // Fills list according to type
    private void fillList(String type) {
        ObservableList<Object> list = FXCollections.observableArrayList();
        switch (type) {
            case "Ingredient":
                list.addAll(productManager.getIngredients());
                break;
            case "Allergen":
                list.addAll(productManager.getAllergens());
                break;
            default:
                list.addAll(productManager.getProducts());
        }
        lvItemList.setItems(list);
    }

    // Sets all text items according to type
    private void setText(String type) {
        switch (type) {
            case "Ingredient":
                // TODO - Text
                break;
            case "Allergen":
                // TODO - Text
                break;
            default:
                // TODO - Text
                break;
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
        if (this.type.equals("Product")) {
            this.type = "Ingredient";
            fillList();
            setText();
        } else {
            this.type = "Product";
            fillList();
            setText();
        }
    }

    @FXML
    void handleItem3(ActionEvent event) {
        if (this.type.equals("Allergen")) {
            this.type = "Ingredient";
            fillList();
            setText();
        } else {
            this.type = "Allergen";
            fillList();
            setText();
        }
    }
}
