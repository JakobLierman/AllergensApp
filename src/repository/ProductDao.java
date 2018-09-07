package repository;

import domain.Product;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

public class ProductDao extends GenericDao<Product> implements IProductDao {
    public ProductDao() {
        super(Product.class);
    }

    @Override
    public Product getProductByName(String name) throws EntityNotFoundException {
        try {
            return em.createNamedQuery("Product.findByName", Product.class)
                    .setParameter("productName", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new EntityNotFoundException();
        }
    }
}
