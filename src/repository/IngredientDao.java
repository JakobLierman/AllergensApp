package repository;

import domain.Ingredient;

import javax.naming.NameAlreadyBoundException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void insert(Ingredient ingredient) throws NameAlreadyBoundException {
        for (String name : getNames())
            if (name.equalsIgnoreCase(ingredient.getName()))
                // TODO - Translate
                throw new NameAlreadyBoundException("An ingredient with the name '" + ingredient.getName() + "' already exists");
        em.persist(ingredient);
    }

    @Override
    public Ingredient update(Ingredient ingredient, String oldName) throws NameAlreadyBoundException {
        int nameCounter = 0;
        for (String name : getNames())
            if (name.equalsIgnoreCase(ingredient.getName())) {
                nameCounter++;
                if (nameCounter > 1)
                    // TODO - Translate
                    throw new NameAlreadyBoundException("An ingredient with the name '" + ingredient.getName() + "' already exists");
            }
        return em.merge(ingredient);
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Ingredient i : findAll()) {
            names.add(i.getName());
        }
        return names;
    }
}
