package domain;

import java.util.ResourceBundle;

public class DomainController {
    private final ProductManager productManager;
    private final ResourceBundle resourceBundle;

    public DomainController(final ResourceBundle resourceBundle) {
        this.productManager = new ProductManager();
        this.resourceBundle = resourceBundle;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
}
