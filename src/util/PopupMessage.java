package util;

import javafx.scene.control.Alert;
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
     */
    public static void showConfirmationMessage(String title, String headerText, String contentText) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        // TODO - Confirmation buttons
        alert.showAndWait();
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
