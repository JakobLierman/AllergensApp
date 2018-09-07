package domain;

import java.util.ResourceBundle;

public class DomainController {
    private final ProductManager productManager;
    private final ResourceBundle resourceBundle;

    public DomainController(final ProductManager productManager, final ResourceBundle resourceBundle) {
        this.productManager = productManager;
        this.resourceBundle = resourceBundle;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
}
