package domain;

/**
 * The type Allergen.
 */
public class Allergen {

    private String name;

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
