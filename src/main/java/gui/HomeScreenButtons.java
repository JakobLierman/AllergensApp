package gui;

import com.jfoenix.controls.JFXButton;
import domain.DomainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import util.PopupMessage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Home screen buttons.
 */
public class HomeScreenButtons extends AnchorPane implements Initializable {

    private Stage stage;
    private final DomainController domainController;
    private String type;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXButton btnItem1;
    @FXML
    private JFXButton btnItem2;
    @FXML
    private JFXButton btnItem3;
    //    @FXML
//    private JFXRadioButton toggleEnglish;
//    @FXML
//    private ToggleGroup languageGroup;
//    @FXML
//    private JFXRadioButton toggleDutch;
    @FXML
    private JFXButton btnExport;

    /**
     * Instantiates new Home screen buttons.
     *
     * @param domainController the domain controller
     */
    public HomeScreenButtons(final DomainController domainController) {
        this.domainController = domainController;
        domainController.getTypeObservable().subscribe(type -> this.type = type);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HomeScreenButtons.fxml"));
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
//        // Select correct language
//        if (domainController.getLanguage().equals("en"))
//            toggleEnglish.setSelected(true);
//        else
//            toggleDutch.setSelected(true);

        setText();
    }

    // Sets all text items according to type
    private void setText() {
        btnItem1.setText(domainController.getText("Products"));
        btnItem2.setText(domainController.getText("Ingredients"));
        btnItem3.setText(domainController.getText("Allergens"));
        btnExport.setText(domainController.getText("Export"));
    }

    /**
     * Handle export.
     * Opens a {@link DirectoryChooser} to let you choose where you'd like to save the file.
     *
     * @param event the event
     */
    @FXML
    void handleExport(ActionEvent event) {
        stage = (Stage) getScene().getWindow();

        DirectoryChooser chooser = new DirectoryChooser();
        File file = chooser.showDialog(stage);

        if (file != null) {
            String destination = file.getAbsolutePath();
            domainController.export(destination); // TODO - Try-catch

            // Popup export complete
            String text = domainController.getText("exportComplete");
            PopupMessage.showInformationMessage(text, "", text);
        }
    }

    /**
     * Handle item 1.
     * Usually goes to Products.
     *
     * @param event the event
     */
    @FXML
    void handleItem1(ActionEvent event) {
        domainController.setType("Product");
    }

    /**
     * Handle item 2.
     * Usually goes to Ingredients.
     *
     * @param event the event
     */
    @FXML
    void handleItem2(ActionEvent event) {
        domainController.setType("Ingredient");
    }

    /**
     * Handle item 3.
     * Usually goes to Allergens.
     *
     * @param event the event
     */
    @FXML
    void handleItem3(ActionEvent event) {
        domainController.setType("Allergen");
    }

//    /**
//     * Changes language on toggle change.
//     *
//     * @param event the event
//     */
//    @FXML
//    void handleLanguageChange(ActionEvent event) {
//        if (toggleEnglish.isSelected())
//            domainController.changeLanguage("en");
//        else
//            domainController.changeLanguage("nl");
//        setText();
//    }
}
