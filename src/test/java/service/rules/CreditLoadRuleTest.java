package service.rules;

import model.Client;
import model.Employment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.rules.impl.CreditLoadRule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constants.*;

import java.util.List;

public class CreditLoadRuleTest {

    private static final double TEST_SALARY = 1000;

    private CreditLoadRule rule;
    private Client client;

    @BeforeEach
    public void setup() {

        rule = new CreditLoadRule();

        Employment emp = new Employment();
        emp.setSalary(TEST_SALARY);

        client = new Client();
        client.setEmployments(List.of(emp));
    }

    @Test
    void highCreditLoadPenaltyTest() {

        int amount = (int) ((HIGH_CREDIT_LOAD + 1) * TEST_SALARY);

        int result = rule.apply(client, amount);

        assertEquals(HIGH_CREDIT_LOAD_PENALTY, result);
    }

    @Test
    void mediumCreditLoadPenaltyTest() {

        int amount = (int) ((MEDIUM_CREDIT_LOAD + 1) * TEST_SALARY);

        int result = rule.apply(client, amount);

        assertEquals(MEDIUM_CREDIT_LOAD_PENALTY, result);
    }

    @Test
    void lowCreditLoadBonusTest() {

        int amount = (int) (MEDIUM_CREDIT_LOAD * TEST_SALARY);

        int result = rule.apply(client, amount);

        assertEquals(LOW_CREDIT_LOAD_BONUS, result);
    }
}
