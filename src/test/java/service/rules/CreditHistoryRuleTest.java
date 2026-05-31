package service.rules;

import model.Client;
import model.CreditHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.rules.impl.CreditHistoryRule;
import static util.Constants.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditHistoryRuleTest {

    private CreditHistoryRule rule;

    @BeforeEach
    public void setup() {
        rule = new CreditHistoryRule();
    }

    private Client createClient(int overdueCount) {

        CreditHistory creditHistory = new CreditHistory();
        creditHistory.setOverdueCount(overdueCount);

        Client client = new Client();
        client.setCreditHistory(creditHistory);

        return client;
    }

    @Test
    void goodCreditHistoryBonusTest() {

        Client client = createClient(0);

        int result = rule.apply(client, 0);

        assertEquals(GOOD_CREDIT_HISTORY_BONUS, result);
    }

    @Test
    void badCreditHistoryPenaltyTest() {

        Client client = createClient(2);

        int result = rule.apply(client, 0);

        assertEquals(BAD_CREDIT_HISTORY_PENALTY, result);
    }

    @Test
    void noCreditHistoryPenaltyTest() {

        Client client = new Client();

        int result = rule.apply(client, 0);

        assertEquals(NO_CREDIT_HISTORY_PENALTY, result);
    }
}
