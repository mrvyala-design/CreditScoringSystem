package dao.impl;

import dao.ClientDAO;
import model.Client;

public class ClientDAOImpl extends AbstractDAO<Client> implements ClientDAO {

    public ClientDAOImpl() {
        super(Client.class);
    }
}