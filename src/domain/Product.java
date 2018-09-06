package domain;

import java.util.HashSet;
import java.util.Set;

public class Product {

    private String name;
    private String description;
    private Set<Ingredient> ingredients;

    public Product(String name, Set<Ingredient> ingredients) {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
        if (ingredients.isEmpty())
            throw new NullPointerException("A product must contain ingredients.");
        this.ingredients = ingredients;
    }

    public String getName() {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    protected void setIngredients(Set<Ingredient> ingredients) {
        if (ingredients.isEmpty())
            throw new NullPointerException("A product must contain ingredients.");
        this.ingredients = ingredients;
    }

    // Gets all allergens from all ingredients in product
    public Set<Allergen> getAllergens() {
        Set<Allergen> allergens = new HashSet<>();
        this.ingredients.forEach(ingredient -> allergens.addAll(ingredient.getAllergens()));
        return allergens;
    }
}
