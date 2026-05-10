package dao;

import jakarta.persistence.EntityManager;
import model.CreditApplication;
import util.HibernateUtil;

import java.io.Serializable;

public class CreditApplicationDaoImpl implements CreditApplicationDao {

    @Override
    public CreditApplication save(EntityManager em, CreditApplication application) {
        em.persist(application);
        return application;
    }

    @Override
    public CreditApplication get(EntityManager em, Serializable id) {
        return em.find(CreditApplication.class, id);
    }

    @Override
    public CreditApplication update(EntityManager em, CreditApplication application) {
        return em.merge(application);
    }

    @Override
    public void delete(EntityManager em, Serializable id) {
        CreditApplication app = em.find(CreditApplication.class, id);
        if (app != null) {
            em.remove(app);
        }
    }
}
