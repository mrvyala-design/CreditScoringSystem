package service.rules;

import model.Client;
import model.CreditHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.rules.impl.ActiveLoansRule;
import static util.Constants.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActiveLoansRuleTest {

    private ActiveLoansRule rule;

    @BeforeEach
    void setup() {
        rule = new ActiveLoansRule();
    }

    private Client createClient(int loans) {

        CreditHistory creditHistory = new CreditHistory();
        creditHistory.setActiveLoans(loans);

        Client client = new Client();
        client.setCreditHistory(creditHistory);

        return client;
    }

    @Test
    void noLoansBonusTest() {

        Client client = createClient(0);

        int result = rule.apply(client, 0);

        assertEquals(NO_ACTIVE_LOANS_BONUS, result);
    }

    @Test
    void someLoansPenaltyTest() {

        Client client = createClient(MANY_ACTIVE_LOANS - 1);

        int result = rule.apply(client, 0);

        assertEquals(ACTIVE_LOANS_PENALTY, result);
    }

    @Test
    void manyLoansPenaltyTest() {

        Client client = createClient(MANY_ACTIVE_LOANS + 1);

        int result = rule.apply(client, 0);

        assertEquals(MANY_ACTIVE_LOANS_PENALTY, result);
    }

    @Test
    void noCreditHistoryPenaltyTest() {

        Client client = new Client();

        int result = rule.apply(client, 0);

        assertEquals(NO_CREDIT_HISTORY_PENALTY, result);
    }
}