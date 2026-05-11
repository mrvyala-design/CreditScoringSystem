package service;

import converter.CreditDecisionConverter;
import dao.ClientDAO;
import dao.impl.ClientDAOImpl;
import dao.CreditApplicationDAO;
import dao.impl.CreditApplicationDAOImpl;
import dto.CreditDecisionDTO;
import jakarta.persistence.EntityManager;
import model.Client;
import model.CreditApplication;
import model.enums.ApplicationStatus;
import util.HibernateUtil;

public class CreditScoringServiceImpl implements CreditScoringService {

    private final ClientDAO clientDao = new ClientDAOImpl();
    private final CreditApplicationDAO applicationDao = new CreditApplicationDAOImpl();
    private final ScoringCalculator calculator = new ScoringCalculator();
    private final CreditDecisionConverter converter = new CreditDecisionConverter();

    @Override
    public CreditDecisionDTO applyForCredit(Long clientId, int amount, int termMonths) {

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

            return converter.toDTO(application, score);

        } finally {
            entityManager.close();
        }
    }
}
