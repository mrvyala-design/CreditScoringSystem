package service;

import dao.ClientDao;
import dao.ClientDaoImpl;
import dao.CreditApplicationDao;
import dao.CreditApplicationDaoImpl;
import jakarta.persistence.EntityManager;
import model.Client;
import model.CreditApplication;
import model.enums.ApplicationStatus;
import util.HibernateUtil;

public class CreditScoringServiceImpl implements CreditScoringService {

    private final ClientDao clientDao = new ClientDaoImpl();
    private final CreditApplicationDao applicationDao = new CreditApplicationDaoImpl();
    private final ScoringCalculator calculator = new ScoringCalculator();

    @Override
    public CreditApplication applyForCredit(Long clientId, int amount, int termMonths) {

        EntityManager entityManager = HibernateUtil.getEntityManager();


        try {
            entityManager.getTransaction().begin();

            Client client = clientDao.get(entityManager, clientId);

            if (client == null) {
                throw new RuntimeException("Client not found with id: " + clientId);
            }

            int score = calculator.calculateScore(client, amount);

            ApplicationStatus decision = calculator.calculateDecision(score);

            CreditApplication application = CreditApplication.builder()
                    .client(client)
                    .amount(amount)
                    .termMonths(termMonths)
                    .status(decision)
                    .build();

            applicationDao.save(entityManager, application);

            entityManager.getTransaction().commit();

            return application;

        } finally {
            entityManager.close();
        }
    }
}
