package dao;

import jakarta.persistence.EntityManager;
import model.Client;

import java.io.Serializable;

public class ClientDaoImpl implements ClientDao {

    @Override
    public Client save(EntityManager em, Client client) {
        em.persist(client);
        return client;
    }

    @Override
    public Client get(EntityManager em, Serializable id) {
        return em.find(Client.class, id);
    }

    @Override
    public Client update(EntityManager em, Client client) {
        return em.merge(client);
    }

    @Override
    public void delete(EntityManager em, Serializable id) {
        Client client = em.find(Client.class, id);
        if (client != null) {
            em.remove(client);
        }
    }
}