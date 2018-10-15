package domain;

import io.reactivex.Observable;

import java.util.List;
import java.util.ResourceBundle;

/**
 * The type Domain controller.
 */
public class DomainController {
    private final ProductManager productManager;
    private ResourceBundle resourceBundle;
    private PDFCreator pdf;
    private String type;

    /**
     * Instantiates a new Domain controller.
     *
     * @param resourceBundle the initial resource bundle
     */
    public DomainController(final ResourceBundle resourceBundle) {
        productManager = new ProductManager();
        this.resourceBundle = resourceBundle;
        pdf = new PDFCreator();
        // Sets initial type
        type = "Product";
    }

    /**
     * Gets product manager.
     *
     * @return the product manager
     */
    public ProductManager getProductManager() {
        return productManager;
    }

    /**
     * Gets text from the resource bundle in the correct language.
     *
     * @param textToGet the text to get
     * @return the text
     */
    public String getText(String textToGet) {
        return resourceBundle.getString(textToGet);
    }

    public void setType(String type) {
        this.type = type;
    }

    public Observable<String> getType() {
        return Observable.just(type);
    }

    public void export(List<Product> items, String directory) {
        // TODO - Implement
    }

//     /**
//      * Changes the resource bundle to the desired language.
//      *
//      * @param language the language symbols (e.g. "en")
//      */
//     public void changeLanguage(String language) {
//         resourceBundle = ResourceBundle.getBundle("Bundle", new Locale(language));
//     }

//    /**
//     * Gets language.
//     *
//     * @return the language
//     */
//    public String getLanguage() {
//        return resourceBundle.getLocale().getLanguage();
//    }
}
