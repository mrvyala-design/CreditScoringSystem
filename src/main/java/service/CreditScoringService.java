package service;

import dto.CreditDecisionDTO;
import model.CreditApplication;

public interface CreditScoringService {

    CreditDecisionDTO applyForCredit(Long clientId, int amount, int termMonths);
}