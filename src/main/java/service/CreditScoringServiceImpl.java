package service;

import converter.CreditDecisionConverter;
import dao.ClientDAO;
import dao.impl.ClientDAOImpl;
import dao.CreditApplicationDAO;
import dao.impl.CreditApplicationDAOImpl;
import dto.CreditDecisionDTO;
import exceptions.ClientNotFoundException;
import exceptions.InvalidCreditAmountException;
import exceptions.InvalidCreditTermException;
import exceptions.ScoringCalculationException;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import model.Client;
import model.CreditApplication;
import model.enums.ApplicationStatus;
import util.HibernateUtil;

@Slf4j
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

            if (amount <= 0) {
                throw new InvalidCreditAmountException(amount);
            }

            if (termMonths <= 0) {
                throw new InvalidCreditTermException(termMonths);
            }

            log.info("Searching client with id {}", clientId);

            Client client = clientDao.get(entityManager, clientId);

            if (client == null) {
                throw new ClientNotFoundException(clientId);
            }

            int score;
            try {
                score = calculator.calculateScore(client, amount);
                log.info("Calculated score {} for client {}", score, clientId);
            } catch (Exception e) {
                throw new ScoringCalculationException("Scoring calculation failed");
            }

            ApplicationStatus decision = calculator.calculateDecision(score);

            CreditApplication application = CreditApplication.builder()
                    .client(client)
                    .amount(amount)
                    .termMonths(termMonths)
                    .status(decision)
                    .build();

            applicationDao.save(entityManager, application);

            entityManager.getTransaction().commit();

            log.info("Application saved successfully. Decision = {}", decision);

            return converter.toDTO(application, score);

        } finally {
            entityManager.close();

        }
    }
}
