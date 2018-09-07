package repository;

import domain.Ingredient;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

public class IngredientDao extends GenericDao<Ingredient> implements IIngredientDao {
    public IngredientDao() {
        super(Ingredient.class);
    }

    @Override
    public Ingredient getIngredientByName(String name) throws EntityNotFoundException {
        try {
            return em.createNamedQuery("Ingredient.findByName", Ingredient.class)
                    .setParameter("ingredientName", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new EntityNotFoundException();
        }
    }
}
