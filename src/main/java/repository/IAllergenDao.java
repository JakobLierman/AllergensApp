package repository;

import domain.Allergen;

import javax.persistence.EntityNotFoundException;

/**
 * The interface Allergen dao.
 */
public interface IAllergenDao extends IGenericDao<Allergen> {
    /**
     * Gets allergen by name.
     *
     * @param name the name of the allergen
     * @return the allergen by name
     * @throws EntityNotFoundException the entity not found exception
     */
    Allergen getAllergenByName(String name) throws EntityNotFoundException;
}
