package repository;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class GenericDao<T> implements IGenericDao {
    private static final EntityManagerFactory emf = util.JPAUtil.getEntityManagerFactory();
    static final EntityManager em = emf.createEntityManager();
    private final Class<T> type;

    public GenericDao(Class<T> type) {
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
    public List findAll() {
        //TODO - Implementation
        throw new NotImplementedException();
    }

    @Override
    public Object update(Object object, String oldName) {
        //TODO - Implementation
        throw new NotImplementedException();
    }

    @Override
    public void delete(Object object) {
        //TODO - Implementation
        throw new NotImplementedException();
    }

    @Override
    public void insert(Object object) {
        //TODO - Implementation
        throw new NotImplementedException();
    }

    @Override
    public boolean exists(Object id) {
        //TODO - Implementation
        throw new NotImplementedException();
    }

    @Override
    public Object get(Object id) {
        //TODO - Implementation
        throw new NotImplementedException();
    }
}
