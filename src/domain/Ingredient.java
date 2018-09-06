package domain;

import java.util.Set;

/**
 * The type Ingredient.
 */
public class Ingredient {

    private String name;
    private Set<Allergen> allergens;

    /**
     * Instantiates a new Ingredient.
     *
     * @param name      the name
     * @param allergens the allergens
     */
    public Ingredient(String name, Set<Allergen> allergens) {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
        this.allergens = allergens;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
    }

    /**
     * Gets allergens.
     *
     * @return the allergens
     */
    public Set<Allergen> getAllergens() {
        return allergens;
    }

    /**
     * Sets allergens.
     *
     * @param allergens the allergens
     */
    public void setAllergens(Set<Allergen> allergens) {
        this.allergens = allergens;
    }

    /**
     * Has allergens boolean.
     *
     * @return the boolean
     */
    public boolean HasAllergens() {
        return this.allergens.isEmpty();
    }

}
