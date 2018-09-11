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

/**
 * The type Home screen.
 */
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

    /**
     * Instantiates a new Home screen.
     *
     * @param domainController the domain controller
     * @param type             the type (e.g. "Product")
     */
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
        productManager = domainController.getProductManager();
        this.type = type;

        if (domainController.getLanguage().equals("en"))
            toggleEnglish.setSelected(true);
        else
            toggleDutch.setSelected(true);

        checkButtonStage();
        fillList();
        setText();
    }

    // Checks if buttons need to be enabled or disabled according to the type
    private void checkButtonStage() {
        btnAdd.setVisible(!type.equalsIgnoreCase("Allergen"));
        btnAlter.setVisible(!type.equalsIgnoreCase("Allergen"));
        btnDelete.setVisible(!type.equalsIgnoreCase("Allergen"));
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
        txtTitle.setText(domainController.getText(type + "s"));
        btnAdd.setText(domainController.getText("add" + type));
        btnAlter.setText(domainController.getText("alter" + type));
        btnDelete.setText(domainController.getText("delete" + type));

        switch (type) {
            case "Ingredient":
                btnItem2.setText(domainController.getText("Products"));
                btnItem3.setText(domainController.getText("Allergens"));
                break;
            case "Allergen":
                btnItem2.setText(domainController.getText("Products"));
                btnItem3.setText(domainController.getText("Ingredients"));
                break;
            default:
                btnItem2.setText(domainController.getText("Ingredients"));
                btnItem3.setText(domainController.getText("Allergens"));
                break;
        }
    }

    /**
     * Changes language on toggle change.
     *
     * @param event the event
     */
    @FXML
    void handleLanguageChange(ActionEvent event) {
        if (toggleEnglish.isSelected())
            domainController.changeLanguage("en");
        else
            domainController.changeLanguage("nl");
        setText();
    }

    /**
     * Opens a new screen in which the user can add an item.
     *
     * @param event the event
     */
    @FXML
    void handleAddItem(ActionEvent event) {
        switch (this.type) {
            case "Ingredient":
                // TODO - Implement add ingredient
                break;
            case "Allergen":
                // TODO - Implement add allergen
                break;
            default:
                // TODO - Implement add product
                break;
        }
    }

    /**
     * Opens a new screen in which the user can alter an item.
     *
     * @param event the event
     */
    @FXML
    void handleAlterItem(ActionEvent event) {
        switch (this.type) {
            case "Ingredient":
                // TODO - Implement alter ingredient
                break;
            case "Allergen":
                // TODO - Implement alter allergen
                break;
            default:
                // TODO - Implement alter product
                break;
        }
    }

    /**
     * Deletes the selected item, shows a popup.
     *
     * @param event the event
     */
    @FXML
    void handleDeleteItem(ActionEvent event) {
        switch (type) {
            case "Ingredient":
                // TODO - Implement delete ingredient
                break;
            case "Allergen":
                // TODO - Implement delete allergen
                break;
            default:
                // TODO - Implement delete product
                break;
        }
    }

    /**
     * Changes items to the desired type.
     *
     * @param event the event
     */
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

    /**
     * Changes items to the desired type.
     *
     * @param event the event
     */
    @FXML
    void handleItem3(ActionEvent event) {
        if (type.equalsIgnoreCase("Allergen")) {
            type = "Ingredient";
            checkButtonStage();
            fillList();
            setText();
        } else {
            type = "Allergen";
            checkButtonStage();
            fillList();
            setText();
        }
    }
}
