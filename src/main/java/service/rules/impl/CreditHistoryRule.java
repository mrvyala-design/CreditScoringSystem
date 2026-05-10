package service.rules.impl;

import model.Client;
import model.CreditHistory;
import service.rules.ScoringRule;

public class CreditHistoryRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        CreditHistory creditHistory = client.getCreditHistory();

        if (creditHistory == null) {
            return 0;
        }

        if (creditHistory.getOverdueCount() == 0) {
            return 30;
        } else {
            return -20;
        }
    }
}
