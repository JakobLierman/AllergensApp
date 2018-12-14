package gui;

import com.jfoenix.controls.JFXButton;
import domain.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.PopupMessage;

import javax.xml.registry.DeleteException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Home screen.
 */
public class HomeScreenContent extends AnchorPane implements Initializable {

    private Stage stage;
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
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnAlter;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private HBox crudButtons;

    /**
     * Instantiates a new Home screen.
     *
     * @param domainController the domain controller
     */
    public HomeScreenContent(final DomainController domainController) {
        this.domainController = domainController;
        productManager = domainController.getProductManager();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HomeScreenContent.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        // loader.setResources(ResourceBundle.getBundle("Bundle", new Locale("en")));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Add icons to allergens
        for (Allergen allergen : productManager.getAllergens()) {
            allergen.setIcon(allergen.getName());
        }

        // Add buttons to AnchorPane
        getChildren().add(0, new HomeScreenButtons(domainController));
        setTopAnchor(getChildren().get(0), 90.0);
        setLeftAnchor(getChildren().get(0), 0.0);
        setBottomAnchor(getChildren().get(0), 20.0);

        // Execute these methods when type changes
        domainController.getTypeObservable().subscribe(type -> {
            this.type = type;
            checkButtonStage();
            fillTable();
            setText();
        });

        // Bindings
        btnAlter.disableProperty().bind(tableItems.getSelectionModel().selectedItemProperty().isNull());
        //BooleanBinding booleanBinding = Bindings.equal(new SimpleStringProperty(type), "Allergen");
        //crudButtons.visibleProperty().bind(booleanBinding);
        //crudButtons.visibleProperty().bind(Bindings.createBooleanBinding(() -> !type.equalsIgnoreCase("Allergen"));
    }

    // Checks if crudButtons need to be enabled or disabled according to the type
    private void checkButtonStage() {
        btnAdd.setVisible(!type.equalsIgnoreCase("Allergen"));
        btnAlter.setVisible(!type.equalsIgnoreCase("Allergen"));
        btnDelete.setVisible(!type.equalsIgnoreCase("Allergen"));
    }

    // Fills list according to type
    private void fillTable() {
        ObservableList<Object> items = FXCollections.observableArrayList();
        switch (type) {
            case "Ingredient":
                items.addAll(productManager.getIngredients());
                // Column settings
                col1.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
                col2.setVisible(false);
                col3.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("allergen"));
                break;
            case "Allergen":
                items.addAll(productManager.getAllergens());
                // Column settings
                col1.setCellValueFactory(new PropertyValueFactory<Allergen, String>("name"));
                col2.setVisible(false);
                col3.setCellValueFactory(new PropertyValueFactory<Allergen, ImageView>("icon"));
                break;
            default:
                items.addAll(productManager.getProducts());
                // Column settings
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

        if (!type.equals("Allergen")) {
            btnAdd.setText(domainController.getText("add" + type));
            btnAlter.setText(domainController.getText("alter" + type));
            btnDelete.setText(domainController.getText("delete" + type));
        }

        col1.setText(domainController.getText("Name"));
        col2.setText(domainController.getText("Description"));

        switch (type) {
            case "Ingredient":
                col3.setText(domainController.getText("Allergen"));
                break;
            case "Allergen":
                col3.setText(domainController.getText("Icons"));
                break;
            default:
                col3.setText(domainController.getText("Allergens"));
                break;
        }

        tableItems.setPlaceholder(new Label(domainController.getText("noItems")));
    }

    /**
     * Opens a new screen in which the user can add an item.
     *
     * @param event the event
     */
    @FXML
    void handleAddItem(ActionEvent event) {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        if (type.equals("Product")) {
            newStage.setTitle(domainController.getText("addProduct"));
            newStage.setScene(new Scene(new DetailScreen(domainController, new Product())));
        } else {
            newStage.setTitle(domainController.getText("addIngredient"));
            newStage.setScene(new Scene(new DetailScreen(domainController, new Ingredient())));
        }
        newStage.showAndWait();
        // Refreshes the table
        fillTable();
    }

    /**
     * Opens a new screen in which the user can alter an item.
     *
     * @param event the event
     */
    @FXML
    void handleAlterItem(ActionEvent event) {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        if (type.equals("Product")) {
            newStage.setTitle(domainController.getText("alterProduct"));
            newStage.setScene(new Scene(new DetailScreen(domainController, tableItems.getSelectionModel().getSelectedItem())));
        } else {
            newStage.setTitle(domainController.getText("alterIngredient"));
            newStage.setScene(new Scene(new DetailScreen(domainController, tableItems.getSelectionModel().getSelectedItem())));
        }
        newStage.showAndWait();
        // Refreshes the table
        tableItems.refresh();
    }

    /**
     * Deletes the selected item, shows a popup.
     *
     * @param event the event
     */
    @FXML
    void handleDeleteItem(ActionEvent event) {
        String title;
        String headerText;
        String contentText;
        if (tableItems.getSelectionModel().isEmpty()) {
            title = domainController.getText("Oops");
            headerText = domainController.getText("Wrong");
            contentText = domainController.getText("nothingSelected");
            PopupMessage.showWarningMessage(title, headerText, contentText);
        } else {
            String yesText = domainController.getText("Yes");
            String noText = domainController.getText("No");
            headerText = domainController.getText("areYouSure");
            contentText = domainController.getText("noUndo");
            if (type.equals("Product")) {
                title = domainController.getText("deleteProduct");
                if (PopupMessage.showConfirmationMessage(title, headerText, contentText, yesText, noText)) {
                    productManager.removeProduct((Product) tableItems.getSelectionModel().getSelectedItem());
                }

            } else {
                try {
                    title = domainController.getText("deleteIngredient");
                    if (PopupMessage.showConfirmationMessage(title, headerText, contentText, yesText, noText)) {
                        productManager.removeIngredient((Ingredient) tableItems.getSelectionModel().getSelectedItem());
                    }
                } catch (DeleteException e) {
                    title = domainController.getText("Oops");
                    headerText = domainController.getText("Wrong");
                    contentText = domainController.getText("cannotDelete");
                    PopupMessage.showErrorMessage(title, headerText, contentText);
                }
            }
            // Refreshes the table
            fillTable();
        }
    }
}
