package service;

import model.CreditApplication;

public interface CreditScoringService {

    CreditApplication applyForCredit(Long clientId, int amount, int termMonths);
}