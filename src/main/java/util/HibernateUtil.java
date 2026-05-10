package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

    public static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("creditPU");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager em) {
        entityManagerFactory.close();
    }
}