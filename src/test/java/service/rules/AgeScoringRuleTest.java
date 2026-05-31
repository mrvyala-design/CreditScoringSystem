package service.rules;

import model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.rules.impl.AgeScoringRule;
import static util.Constants.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeScoringRuleTest {

    private AgeScoringRule rule;

    @BeforeEach
    void setup() {
        rule = new AgeScoringRule();
    }

    private Client createClient(int age) {
        Client client = new Client();
        client.setBirthDate(LocalDate.now().minusYears(age));
        return client;
    }

    @Test
    void youngPenaltyTest() {

        Client client = createClient(MIN_AGE - 1);

        int result = rule.apply(client, 0);

        assertEquals(AGE_YOUNG_PENALTY, result);
    }

    @Test

    void goodAgeBonusTest() {

        Client client = createClient(MIN_AGE + 5);

        int result = rule.apply(client, 0);

        assertEquals(AGE_GOOD_BONUS, result);
    }

    @Test
    void oldPenaltyTest() {

        Client client = createClient(MAX_GOOD_AGE + 1);

        int result = rule.apply(client, 0);

        assertEquals(AGE_OLD_PENALTY, result);
    }
}