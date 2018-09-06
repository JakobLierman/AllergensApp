package domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Set;

/**
 * The type Product manager.
 */
public class ProductManager {

    /**
     * Instantiates a new Product manager.
     */
    public ProductManager() {
    }

    /**
     * Create product.
     *
     * @param name        the name
     * @param description the description (can be null)
     * @param ingredients the ingredients
     */
    public void createProduct(String name, String description, Set<Ingredient> ingredients) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Duplicate product.
     *
     * @param product the product
     */
    public void duplicateProduct(Product product) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Remove product.
     *
     * @param product the product
     */
    public void removeProduct(Product product) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Alter product.
     *
     * @param oldName     the old name
     * @param newName     the new name
     * @param ingredients the ingredients
     */
    public void alterProduct(String oldName, String newName, Set<Ingredient> ingredients) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Gets product by name.
     *
     * @param name the name
     * @return the product by name
     */
    public Product getProductByName(String name) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Create ingredient.
     *
     * @param name      the name
     * @param allergens the allergens
     */
    public void createIngredient(String name, Set<Allergen> allergens) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Duplicate ingredient.
     *
     * @param ingredient the ingredient
     */
    public void duplicateIngredient(Ingredient ingredient) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Remove ingredient.
     *
     * @param ingredient the ingredient
     */
    public void removeIngredient(Ingredient ingredient) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Alter ingredient.
     *
     * @param oldName   the old name
     * @param newName   the new name
     * @param allergens the allergens
     */
    public void alterIngredient(String oldName, String newName, Set<Allergen> allergens) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Gets ingredient by name.
     *
     * @param name the name
     * @return the ingredient by name
     */
    public Product getIngredientByName(String name) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Create allergen.
     *
     * @param name the name
     */
    public void createAllergen(String name) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Duplicate allergen.
     *
     * @param allergen the allergen
     */
    public void duplicateAllergen(Allergen allergen) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Remove allergen.
     *
     * @param allergen the allergen
     */
    public void removeAllergen(Allergen allergen) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Alter allergen.
     *
     * @param oldName the old name
     * @param newName the new name (if not changed, use the same as oldName)
     */
    public void alterAllergen(String oldName, String newName) {
        // TODO - Implementation
        throw new NotImplementedException();
    }

    /**
     * Gets allergen by name.
     *
     * @param name the name
     * @return the allergen by name
     */
    public Product getAllergenByName(String name) {
        // TODO - Implementation
        throw new NotImplementedException();
    }


}
