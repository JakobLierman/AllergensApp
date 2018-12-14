package repository;

import javax.naming.NameAlreadyBoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Collection;

public class GenericDao<T> implements IGenericDao<T> {
    private static final EntityManagerFactory emf = util.JPAUtil.getEntityManagerFactory();
    static final EntityManager em = emf.createEntityManager();
    private final Class<T> type;

    GenericDao(Class<T> type) {
        this.type = type;
    }

    public static void startTransaction() {
        em.getTransaction().begin();
    }

    public static void commitTransaction() {
        em.getTransaction().commit();
    }

    public static void rollbackTransaction() {
        em.getTransaction().rollback();
    }

    public static void closePersistency() {
        em.close();
        emf.close();
    }

    @Override
    public Collection<T> findAll() {
        return em.createQuery("select entity from " + type.getName() + " entity", type).getResultList();
    }

    @Override
    public <U> T get(U id) {
        return em.find(type, id);
    }

    @Override
    public T update(T object, String oldName) throws NameAlreadyBoundException {
        return em.merge(object);
    }

    @Override
    public void delete(T object) {
        em.remove(em.merge(object));
    }

    @Override
    public void insert(T object) throws NameAlreadyBoundException {
        em.persist(object);
    }

    @Override
    public <U> boolean exists(U id) {
        T entity = em.find(type, id);
        return entity != null;
    }
}
