package domain;

import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Product.
 */
@Entity
@NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :productName")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    private String description;
    @ManyToMany
    @JoinTable(
            name = "Product_Ingredient",
            joinColumns = {
                    @JoinColumn(name = "Productid", nullable = false, referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "Ingredientid", nullable = false, referencedColumnName = "id")}
    )
    private Set<Ingredient> ingredients;

    /**
     * Instantiates a new Product.
     */
    public Product() {
    }

    /**
     * Instantiates a new Product.
     *
     * @param name        the name
     * @param ingredients the ingredients
     */
    public Product(String name, Set<Ingredient> ingredients) {
        if (name.isEmpty())
            // TODO - Language
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
        if (ingredients.isEmpty())
            // TODO - Language
            throw new NullPointerException("A product must contain ingredients.");
        this.ingredients = ingredients;
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
    protected void setName(String name) {
        if (name.isEmpty())
            // TODO - Language
            throw new NullPointerException("Name can't be empty.");
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
        ingredients.forEach(ingredient -> {
            if (ingredient.hasAllergen())
                allergens.add(ingredient.getAllergen());
        });
        return allergens;
    }

    /**
     * Name property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    /**
     * Description property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty descriptionProperty() {
        return new SimpleStringProperty(description);
    }

    /**
     * Allergens property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty allergensProperty() {
        StringBuilder stringBuilder = new StringBuilder();
        getAllergens().forEach(allergen -> {
            stringBuilder.append(allergen.getName()).append(", ");
        });
        if (stringBuilder.length() > 0)
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return new SimpleStringProperty(stringBuilder.toString());
    }
}
