package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The type Jpa util.
 */
public class JPAUtil {
    private static final String PU_NAME = "AllergenAppPU";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU_NAME);

    /**
     * Gets entity manager factory.
     *
     * @return the entity manager factory
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    private JPAUtil() {
    }
}
