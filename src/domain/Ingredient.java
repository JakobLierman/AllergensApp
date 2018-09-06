package domain;

import java.util.Set;

public class Ingredient {

    private String name;
    private Set<Allergen> allergens;

    public Ingredient(String name, Set<Allergen> allergens) {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
        this.allergens = allergens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
    }

    public Set<Allergen> getAllergens() {
        return allergens;
    }

    public void setAllergens(Set<Allergen> allergens) {
        this.allergens = allergens;
    }

    public boolean HasAllergens() {
        return this.allergens.isEmpty();
    }

}
