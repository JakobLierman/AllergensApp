package domain;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import repository.GenericDao;

import java.util.ResourceBundle;

/**
 * The type Domain controller.
 */
public class DomainController {
    private final ProductManager productManager;
    private ResourceBundle resourceBundle;
    private PDFCreator pdf;
    private Subject<String> typeObservable = PublishSubject.create();
    private String companyName = "Bakkerij Lierman"; // TODO - Use can choose company name

    /**
     * Instantiates a new Domain controller.
     *
     * @param resourceBundle the initial resource bundle
     */
    public DomainController(final ResourceBundle resourceBundle) {
        productManager = new ProductManager();
        this.resourceBundle = resourceBundle;
        pdf = new PDFCreator();
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

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        typeObservable.onNext(type);
    }

    /**
     * Gets type observable.
     *
     * @return the type observable
     */
    public Subject<String> getTypeObservable() {
        return typeObservable;
    }

    /**
     * Gets company name.
     *
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets company name.
     *
     * @param companyName the company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Export items to pdf in directory.
     *
     * @param directory the directory
     */
    public void export(String directory) {
        // TODO - Implement
        System.out.println("Exporting to " + directory);
    }

    /**
     * Close persistency.
     */
    public void closePersistency() {
        GenericDao.closePersistency();
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
