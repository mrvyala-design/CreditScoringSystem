package service.rules;

import model.Client;
import model.Employment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.rules.impl.SalaryScoringRule;
import static util.Constants.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryScoringRuleTest {

    private SalaryScoringRule rule;

    @BeforeEach
    public void setup() {
        rule = new SalaryScoringRule();
    }

    private Client createClient(double salary) {
        Employment emp = new Employment();
        emp.setSalary(salary);

        Client client = new Client();
        client.setEmployments(List.of(emp));

        return client;
    }

    @Test
    void highSalaryBonusTest() {

        Client client = createClient(HIGH_SALARY + 1);

        int result = rule.apply(client,0);

        assertEquals(HIGH_SALARY_BONUS, result);
    }

    @Test
    void mediumSalaryBonusTest() {

        Client client = createClient(MEDIUM_SALARY + 1);

        int result = rule.apply(client,0);

        assertEquals(MEDIUM_SALARY_BONUS, result);
    }

    @Test
    void lowSalaryBonusTest() {

        Client client = createClient(MEDIUM_SALARY - 1);

        int result = rule.apply(client,0);

        assertEquals(LOW_SALARY_BONUS, result);
    }

    @Test
    void noJobPenaltyTest() {
        Client client = new Client();

        client.setEmployments(List.of());

        int result = rule.apply(client,0);

        assertEquals(NO_JOB_PENALTY, result);
    }

    @Test
    void jobPenaltyTestIfJobsIsNull() {
        Client client = new Client();

        client.setEmployments(null);

        int result = rule.apply(client,0);

        assertEquals(NO_JOB_PENALTY, result);
    }
}