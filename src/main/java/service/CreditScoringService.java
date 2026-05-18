package service;

import dto.CreditDecisionDTO;

public interface CreditScoringService {

    CreditDecisionDTO applyForCredit(Long clientId, int amount, int termMonths);
}