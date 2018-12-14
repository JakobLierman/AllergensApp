package repository;

import domain.Ingredient;

import javax.persistence.EntityNotFoundException;

/**
 * The interface Ingredient dao.
 */
public interface IIngredientDao extends IGenericDao<Ingredient> {
    /**
     * Gets ingredient by name.
     *
     * @param name the name of the ingredient
     * @return the ingredient by name
     * @throws EntityNotFoundException the entity not found exception
     */
    Ingredient getIngredientByName(String name) throws EntityNotFoundException;
}
