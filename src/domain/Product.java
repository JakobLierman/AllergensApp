package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Product.
 */
public class Product {

    private String name;
    private String description;
    private Set<Ingredient> ingredients;

    /**
     * Instantiates a new Product.
     *
     * @param name        the name
     * @param ingredients the ingredients
     */
    public Product(String name, Set<Ingredient> ingredients) {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
        if (ingredients.isEmpty())
            throw new NullPointerException("A product must contain ingredients.");
        this.ingredients = ingredients;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    protected void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    protected void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets ingredients.
     *
     * @return the ingredients
     */
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Sets ingredients.
     *
     * @param ingredients the ingredients
     */
    protected void setIngredients(Set<Ingredient> ingredients) {
        if (ingredients.isEmpty())
            throw new NullPointerException("A product must contain ingredients.");
        this.ingredients = ingredients;
    }

    /**
     * Gets all allergens from all ingredients in product.
     *
     * @return the allergens
     */
    public Set<Allergen> getAllergens() {
        Set<Allergen> allergens = new HashSet<>();
        this.ingredients.forEach(ingredient -> allergens.addAll(ingredient.getAllergens()));
        return allergens;
    }
}
