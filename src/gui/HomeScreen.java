package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import domain.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
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
    private TableView tableItems;
    @FXML
    private TableColumn col1;
    @FXML
    private TableColumn col2;
    @FXML
    private TableColumn col3;
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
        fillTable();
        setText();
    }

    // Checks if buttons need to be enabled or disabled according to the type
    private void checkButtonStage() {
        btnAdd.setVisible(!type.equalsIgnoreCase("Allergen"));
        btnAlter.setVisible(!type.equalsIgnoreCase("Allergen"));
        btnDelete.setVisible(!type.equalsIgnoreCase("Allergen"));
    }

    // Fills list according to type
    private void fillTable() {
        ObservableList<Object> items = FXCollections.observableArrayList();
        col2.setVisible(false);
        switch (type) {
            case "Ingredient":
                items.addAll(productManager.getIngredients());

                col1.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
                col3.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("allergen"));
                break;
            case "Allergen":
                items.addAll(productManager.getAllergens());

                col1.setCellValueFactory(new PropertyValueFactory<Allergen, String>("name"));
                col3.setCellValueFactory(new PropertyValueFactory<Allergen, BufferedImage>("icon"));
                break;
            default:
                items.addAll(productManager.getProducts());

                col1.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
                col2.setVisible(true);
                col2.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));
                col3.setCellValueFactory(new PropertyValueFactory<Product, String>("allergens"));
                break;
        }
        tableItems.setItems(items);
    }

    // Sets all text items according to type
    private void setText() {
        txtTitle.setText(domainController.getText(type + "s"));
        btnAdd.setText(domainController.getText("add" + type));
        btnAlter.setText(domainController.getText("alter" + type));
        btnDelete.setText(domainController.getText("delete" + type));

        col1.setText(domainController.getText("Name"));
        col2.setText(domainController.getText("Description"));

        switch (type) {
            case "Ingredient":
                btnItem2.setText(domainController.getText("Products"));
                btnItem3.setText(domainController.getText("Allergens"));

                col3.setText(domainController.getText("Allergen"));
                break;
            case "Allergen":
                btnItem2.setText(domainController.getText("Products"));
                btnItem3.setText(domainController.getText("Ingredients"));

                col3.setText(domainController.getText("Icon"));
                break;
            default:
                btnItem2.setText(domainController.getText("Ingredients"));
                btnItem3.setText(domainController.getText("Allergens"));

                col3.setText(domainController.getText("Allergens"));
                break;
        }
        tableItems.setPlaceholder(new Label(domainController.getText("noItems")));
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
        if (type.equalsIgnoreCase("Product")) {
            type = "Ingredient";
            checkButtonStage();
            fillTable();
            setText();
        } else {
            type = "Product";
            checkButtonStage();
            fillTable();
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
            fillTable();
            setText();
        } else {
            type = "Allergen";
            checkButtonStage();
            fillTable();
            setText();
        }
    }
}
