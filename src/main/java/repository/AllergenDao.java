package repository;

import domain.Allergen;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

public class AllergenDao extends GenericDao<Allergen> implements IAllergenDao {
    public AllergenDao() {
        super(Allergen.class);
    }

    @Override
    public Allergen getAllergenByName(String name) throws EntityNotFoundException {
        try {
            return em.createNamedQuery("Allergen.findByName", Allergen.class)
                    .setParameter("allergenName", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new EntityNotFoundException();
        }
    }
}
