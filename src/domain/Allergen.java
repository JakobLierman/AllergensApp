package domain;

import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

/**
 * The type Allergen.
 */
@Entity
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false)
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

    @Override
    public String toString() {
        return this.name;

    /**
     * Name property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }
}
