package domain;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import repository.GenericDao;

import java.io.IOException;
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
     * @throws IOException the io exception
     */
    public void export(String directory) throws IOException {
        // Create pdf
        pdf.create(getText("Export"), companyName);

        /*
        // Description page
        StringBuilder allergensString = new StringBuilder();
        for (Allergen allergen : productManager.getAllergens()) {
            allergensString.append(allergen.toString());
            allergensString.append(": ");
            // TODO - add image
            allergensString.append(System.lineSeparator());
        }
        addPdfPage(allergensString.toString());
        // Add empty page (for double-sided printing)
        addPdfPage("");
        */

        // Add product with ingredients with allergens
        StringBuilder contentStringBuilder = new StringBuilder();
        contentStringBuilder.append(getText("Products"));
        contentStringBuilder.append(System.lineSeparator());
        contentStringBuilder.append("------------------------------");
        productManager.getProducts().forEach(product -> {
            contentStringBuilder.append(System.lineSeparator());
            contentStringBuilder.append(System.lineSeparator());
            contentStringBuilder.append(product.toString());
            contentStringBuilder.append(System.lineSeparator());
            contentStringBuilder.append(getText("Description")).append(": ");
            contentStringBuilder.append(product.getDescription());
            contentStringBuilder.append(System.lineSeparator());
            contentStringBuilder.append(getText("Allergens")).append(": ");
            String prefix = "";
            for (Allergen allergen : product.getAllergens()) {
                contentStringBuilder.append(prefix);
                contentStringBuilder.append(allergen.toString());
                prefix = ", ";
            }
        });
        addPdfPage(contentStringBuilder.toString());

        // Save pdf
        pdf.save(directory, getText("Allergens") + " " + companyName);
    }

    private void addPdfPage(String content) throws IOException {
        String lines[] = content.split(System.lineSeparator());
        final int linesPerPage = 40;

        int numOfPages = (int) Math.ceil((double) lines.length / linesPerPage);
        String[][] output = new String[numOfPages][];

        for (int i = 0; i < numOfPages; ++i) {
            int start = i * linesPerPage;
            int length = Math.min(lines.length - start, linesPerPage);

            String[] temp = new String[length];
            System.arraycopy(lines, start, temp, 0, length);
            output[i] = temp;
        }

        for (String[] linesInPage : output) {
            pdf.addPage(linesInPage);
        }
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
