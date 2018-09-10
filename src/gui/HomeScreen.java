package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import domain.DomainController;
import domain.ProductManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class HomeScreen extends AnchorPane {

    private final DomainController domainController;
    private final ProductManager productManager;
    private String type;
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
    @FXML
    private JFXRadioButton toggleEnglish;
    @FXML
    private JFXRadioButton toggleDutch;
    @FXML
    private ToggleGroup languageGroup;

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
        this.type = type;

        checkButtonStage();
        fillList();
        setText();
    }

    // Checks if buttons need to be enabled or disabled according to the type
    private void checkButtonStage() {
        btnAdd.setDisable(this.type.equalsIgnoreCase("Allergen"));
        btnAlter.setDisable(this.type.equalsIgnoreCase("Allergen"));
        btnDelete.setDisable(this.type.equalsIgnoreCase("Allergen"));
    }

    // Fills list according to type
    private void fillList() {
        ObservableList<Object> list = FXCollections.observableArrayList();
        switch (this.type) {
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
    private void setText() {
        txtTitle.setText(domainController.getText(this.type + "s"));
        btnAdd.setText(domainController.getText("add" + this.type));
        btnAlter.setText(domainController.getText("alter" + this.type));
        btnDelete.setText(domainController.getText("delete" + this.type));
        switch (this.type) {
            case "Ingredient":
                // TODO - Text
                btnItem2.setText(domainController.getText("Products"));
                btnItem3.setText(domainController.getText("Allergens"));
                break;
            case "Allergen":
                // TODO - Text
                btnItem2.setText(domainController.getText("Products"));
                btnItem3.setText(domainController.getText("Ingredients"));
                break;
            default:
                // TODO - Text
                btnItem2.setText(domainController.getText("Ingredients"));
                btnItem3.setText(domainController.getText("Allergens"));
                break;
        }
    }

    // Changes language on toggle change
    @FXML
    void handleLanguageChange(ActionEvent event) {
        if (toggleEnglish.isSelected())
            domainController.changeLanguage("en");
        else
            domainController.changeLanguage("nl");
        setText();
    }

    @FXML
    void handleAddItem(ActionEvent event) {
        switch (this.type) {
            case "Ingredient":
                // TODO - Implement
                break;
            case "Allergen":
                // TODO - Implement
                break;
            default:
                // TODO - Implement
                break;
        }
    }

    @FXML
    void handleAlterItem(ActionEvent event) {
        switch (this.type) {
            case "Ingredient":
                // TODO - Implement
                break;
            case "Allergen":
                // TODO - Implement
                break;
            default:
                // TODO - Implement
                break;
        }
    }

    @FXML
    void handleDeleteItem(ActionEvent event) {
        switch (this.type) {
            case "Ingredient":
                // TODO - Implement
                break;
            case "Allergen":
                // TODO - Implement
                break;
            default:
                // TODO - Implement
                break;
        }
    }

    @FXML
    void handleItem2(ActionEvent event) {
        if (this.type.equalsIgnoreCase("Product")) {
            this.type = "Ingredient";
            checkButtonStage();
            fillList();
            setText();
        } else {
            this.type = "Product";
            checkButtonStage();
            fillList();
            setText();
        }
    }

    @FXML
    void handleItem3(ActionEvent event) {
        if (this.type.equalsIgnoreCase("Allergen")) {
            this.type = "Ingredient";
            checkButtonStage();
            fillList();
            setText();
        } else {
            this.type = "Allergen";
            checkButtonStage();
            fillList();
            setText();
        }
    }
}
