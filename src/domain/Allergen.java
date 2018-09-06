package domain;

import javax.persistence.*;

/**
 * The type Allergen.
 */
@Entity
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String name;

    public Allergen() {
    }

    /**
     * Instantiates a new Allergen.
     *
     * @param name the name
     */
    public Allergen(String name) {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
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

}
