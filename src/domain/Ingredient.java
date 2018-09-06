package domain;

import java.util.List;

public class Ingredient {

    private String name;
    private List<Allergen> allergens;

    public Ingredient(String name, List<Allergen> allergens) {
        this.name = name;
        this.allergens = allergens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Allergen> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<Allergen> allergens) {
        this.allergens = allergens;
    }

}
