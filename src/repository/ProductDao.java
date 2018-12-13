package repository;

import domain.Product;

import javax.naming.NameAlreadyBoundException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void insert(Product product) throws NameAlreadyBoundException {
        for (String name : getNames())
            if (name.equalsIgnoreCase(product.getName()))
                // TODO - Translate
                throw new NameAlreadyBoundException("A product with the name '" + product.getName() + "' already exists");
        em.persist(product);
    }

    @Override
    public Product update(Product product, String oldName) throws NameAlreadyBoundException {
        int nameCounter = 0;
        for (String name : getNames())
            if (name.equalsIgnoreCase(product.getName())) {
                nameCounter++;
                if (nameCounter > 1)
                    // TODO - Translate
                    throw new NameAlreadyBoundException("A product with the name '" + product.getName() + "' already exists");
            }
        return em.merge(product);
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Product p : findAll()) {
            names.add(p.getName());
        }
        return names;
    }
}
