package repository;

import domain.Product;

import javax.persistence.EntityNotFoundException;

/**
 * The interface Product dao.
 */
public interface IProductDao extends IGenericDao<Product> {
    /**
     * Gets product by name.
     *
     * @param name the name of the product
     * @return the product by name
     * @throws EntityNotFoundException the entity not found exception
     */
    Product getProductByName(String name) throws EntityNotFoundException;
}
