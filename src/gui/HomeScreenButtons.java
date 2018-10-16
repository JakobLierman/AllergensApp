package gui;

import com.jfoenix.controls.JFXButton;
import domain.DomainController;
import domain.Product;
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
import java.util.List;
import java.util.ResourceBundle;

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

    public HomeScreenButtons(final DomainController domainController) {
        this.domainController = domainController;
        domainController.getTypeObservable().subscribe(type -> this.type = type);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreenButtons.fxml"));
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

    @FXML
    void handleExport(ActionEvent event) {
        // TODO - Implement handleExport
        stage = (Stage) getScene().getWindow();

        DirectoryChooser chooser = new DirectoryChooser();
        File file = chooser.showDialog(stage);

        // Get items
        List<Product> items;


        if (file == null) {
            String title = domainController.getText("Oops");
            String headerText = domainController.getText("SelectFolder");
            String contentText = domainController.getText("NoFolderSelected");
            PopupMessage.showErrorMessage(title, headerText, contentText);
        } else {
            String destination = file.getAbsolutePath();
            //domainController.export(items, destination);
        }
    }

    @FXML
    void handleItem1(ActionEvent event) {
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
