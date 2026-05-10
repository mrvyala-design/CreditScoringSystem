package dao.impl;

import dao.CreditApplicationDAO;
import model.CreditApplication;

public class CreditApplicationDAOImpl extends AbstractDAO<CreditApplication> implements CreditApplicationDAO {

    public CreditApplicationDAOImpl() {
        super(CreditApplication.class);
    }
}