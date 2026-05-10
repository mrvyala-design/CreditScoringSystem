package dao;

import jakarta.persistence.EntityManager;

import java.io.Serializable;

public interface DAO<T> {

    T save(EntityManager em, T t);

    T get(EntityManager em, Serializable id);

    T update(EntityManager em, T t);

    void delete(EntityManager em, Serializable id);
}