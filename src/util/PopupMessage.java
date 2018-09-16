package util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

/**
 * The type Popup message.
 */
public class PopupMessage {

    private static Alert alert;

    /**
     * Show confirmation message.
     *
     * @param title       the title
     * @param headerText  the header text
     * @param contentText the content text
     * @param yesText     the yes text
     * @param noText      the no text
     * @return true if yes is selected
     */
    public static boolean showConfirmationMessage(String title, String headerText, String contentText, String yesText, String noText) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UTILITY);

        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.getButtonTypes().clear();
        ButtonType yes = new ButtonType(yesText, ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType(noText, ButtonBar.ButtonData.NO);
        alert.getButtonTypes().add(yes);
        alert.getButtonTypes().add(no);

        alert.showAndWait();

        return alert.getResult().equals(yes);
    }

    /**
     * Show error message.
     *
     * @param title       the title
     * @param headerText  the header text
     * @param contentText the content text
     */
    public static void showErrorMessage(String title, String headerText, String contentText) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);

        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

    /**
     * Show warning message.
     *
     * @param title       the title
     * @param headerText  the header text
     * @param contentText the content text
     */
    public static void showWarningMessage(String title, String headerText, String contentText) {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.initStyle(StageStyle.UTILITY);

        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

    /**
     * Show information message.
     *
     * @param title       the title
     * @param headerText  the header text
     * @param contentText the content text
     */
    public static void showInformationMessage(String title, String headerText, String contentText) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);

        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

}
