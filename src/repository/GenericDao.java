package repository;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

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
    public List<T> findAll() {
        //TODO - Implementation
        throw new NotImplementedException();
    }

    @Override
    public <U> T get(U id) {
        //TODO - Implementation
        throw new NotImplementedException();
    }

    @Override
    public T update(T object, String oldName) {
        //TODO - Implementation
        throw new NotImplementedException();
    }

    @Override
    public void delete(T object) {
        //TODO - Implementation
        throw new NotImplementedException();
    }

    @Override
    public void insert(T object) {
        //TODO - Implementation
        throw new NotImplementedException();
    }

    @Override
    public <U> boolean exists(U id) {
        //TODO - Implementation
        throw new NotImplementedException();
    }
}
