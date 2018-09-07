package repository;

import java.util.List;

/**
 * The interface Generic dao.
 *
 * @param <T> the type parameter
 */
public interface IGenericDao<T> {

    /**
     * Finds all objects.
     *
     * @return list with all objects
     */
    List<T> findAll();

    /**
     * Gets object.
     *
     * @param <U> the type parameter
     * @param id  the id
     * @return the object
     */
    <U> T get(U id);

    /**
     * Updates object.
     *
     * @param object  the object
     * @param oldName the old name
     * @return the object
     */
    T update(T object, String oldName);

    /**
     * Deletes object.
     *
     * @param object the object
     */
    void delete(T object);

    /**
     * Inserts object.
     *
     * @param object the object
     */
    void insert(T object);

    /**
     * Return if object exists.
     *
     * @param <U> the type parameter
     * @param id  the id
     * @return the boolean
     */
    <U> boolean exists(U id);
}