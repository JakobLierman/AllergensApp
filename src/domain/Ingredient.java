package domain;

import javax.persistence.*;

/**
 * The type Ingredient.
 */
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @javax.persistence.ManyToOne(optional = false)
    private Allergen allergen;

    public Ingredient() {
    }

    /**
     * Instantiates a new Ingredient.
     *
     * @param name     the name
     * @param allergen the allergen
     */
    public Ingredient(String name, Allergen allergen) {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
        this.allergen = allergen;
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
     * Gets allergen.
     *
     * @return the allergen
     */
    public Allergen getAllergen() {
        return allergen;
    }

    /**
     * Sets allergen.
     *
     * @param allergen the allergen
     */
    public void setAllergen(Allergen allergen) {
        this.allergen = allergen;
    }

    /**
     * Has allergen boolean.
     *
     * @return the boolean
     */
    public boolean HasAllergen() {
        return this.allergen == null;
    }

}
