package service.rules.impl;

import model.Client;
import model.CreditHistory;
import service.rules.ScoringRule;

import static util.Constants.*;

public class ActiveLoansRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        CreditHistory creditHistory = client.getCreditHistory();

        if (creditHistory == null) {
            return NO_CREDIT_HISTORY_PENALTY;
        }

        int activeLoans = creditHistory.getActiveLoans();

        if (activeLoans > MANY_ACTIVE_LOANS) {
            return MANY_ACTIVE_LOANS_PENALTY;
        } else if (activeLoans > 0) {
            return ACTIVE_LOANS_PENALTY;
        } else {
            return NO_ACTIVE_LOANS_BONUS;
        }
    }
}