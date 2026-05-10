package service.rules.impl;

import model.Client;
import model.CreditHistory;
import service.rules.ScoringRule;

public class ActiveLoansRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        CreditHistory creditHistory = client.getCreditHistory();

        if (creditHistory == null) {
            return 0;
        }

        int activeLoans = creditHistory.getActiveLoans();

        if (activeLoans > 3) {
            return -30;
        } else if (activeLoans > 0) {
            return -10;
        } else {
            return 10;
        }
    }
}
