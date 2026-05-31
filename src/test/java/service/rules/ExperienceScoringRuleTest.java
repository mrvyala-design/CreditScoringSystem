package service.rules;

import model.Client;
import model.Employment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.rules.impl.ExperienceScoringRule;
import static util.Constants.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExperienceScoringRuleTest {

    private ExperienceScoringRule rule;

    @BeforeEach
    void setUp() {
        rule = new ExperienceScoringRule();
    }

    private Client createClient(int experienceYears) {

        Employment emp = new Employment();
        emp.setExperienceYears(experienceYears);

        Client client = new Client();
        client.setEmployments(List.of(emp));

        return client;
    }

    @Test
    void lowExperiencePenaltyTest() {

        Client client = createClient(0);

        int result = rule.apply(client, 0);

        assertEquals(LOW_EXPERIENCE_PENALTY, result);
    }

    @Test
    void mediumExperienceBonusTest() {

        Client client = createClient(GOOD_EXPERIENCE - 1);

        int result = rule.apply(client, 0);

        assertEquals(MEDIUM_EXPERIENCE_BONUS, result);
    }

    @Test
    void mediumExperienceBonusIfEqualsGoodExperienceTest() {

        Client client = createClient(GOOD_EXPERIENCE);

        int result = rule.apply(client, 0);

        assertEquals(MEDIUM_EXPERIENCE_BONUS, result);
    }

    @Test
    void highExperienceBonusTest() {

        Client client = createClient(GOOD_EXPERIENCE + 1);

        int result = rule.apply(client, 0);

        assertEquals(HIGH_EXPERIENCE_BONUS, result);
    }
}