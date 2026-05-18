package service.rules.impl;

import model.Client;
import model.CreditHistory;
import service.rules.ScoringRule;
import static util.Constants.*;

public class CreditHistoryRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        CreditHistory creditHistory = client.getCreditHistory();

        if (creditHistory == null) {
            return NO_CREDIT_HISTORY_PENALTY;
        }

        if (creditHistory.getOverdueCount() == 0) {
            return GOOD_CREDIT_HISTORY_BONUS;
        } else {
            return BAD_CREDIT_HISTORY_PENALTY;
        }
    }
}
