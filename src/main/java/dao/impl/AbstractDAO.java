package dao.impl;

import dao.DAO;
import jakarta.persistence.EntityManager;
import java.io.Serializable;

public abstract class AbstractDAO<T> implements DAO<T> {

    private final Class<T> entityClass;

    protected AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T save(EntityManager em, T entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public T get(EntityManager em, Serializable id) {
        return em.find(entityClass, id);
    }

    @Override
    public T update(EntityManager em, T entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(EntityManager em, Serializable id) {

        T entity = em.find(entityClass, id);

        if (entity != null) {
            em.remove(entity);
        }
    }
}
