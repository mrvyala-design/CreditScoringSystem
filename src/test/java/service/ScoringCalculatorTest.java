package service;

import model.Client;
import model.CreditHistory;
import model.Employment;
import model.enums.ApplicationStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static util.Constants.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoringCalculatorTest {

    private ScoringCalculator scoringCalculator;

    @BeforeEach
    public void setup() {
        scoringCalculator = new ScoringCalculator();
    }

    private Client createClient(int age,
                                double salary,
                                int experienceYears,
                                int activeLoans,
                                int overdueCount) {

        Client client = new Client();
        client.setBirthDate(LocalDate.now().minusYears(age));

        Employment employment = new Employment();
        employment.setSalary(salary);
        employment.setExperienceYears(experienceYears);

        client.setEmployments(List.of(employment));

        CreditHistory creditHistory = new CreditHistory();
        creditHistory.setActiveLoans(activeLoans);
        creditHistory.setOverdueCount(overdueCount);

        client.setCreditHistory(creditHistory);

        return client;
    }

    @Test
    void idealClientScoreTest() {

        Client client = createClient(35,8000,5,0,0);

        int score = scoringCalculator.calculateScore(client, 10000);

        assertEquals(130, score);
    }

    @Test
    void badClientScoreTest() {

        Client client = createClient(18,1000,0,5,5);

        int score = scoringCalculator.calculateScore(client, 15000);

        assertEquals(-110, score);
    }

    @Test
    void approvedDecisionTest() {

        ApplicationStatus decision = scoringCalculator.calculateDecision(APPROVED_SCORE + 1);

        assertEquals(ApplicationStatus.APPROVED, decision);
    }

    @Test
    void manualReviewDecisionTest() {

        ApplicationStatus decision = scoringCalculator.calculateDecision(MANUAL_REVIEW_SCORE + 1);

        assertEquals(ApplicationStatus.MANUAL_REVIEW, decision);
    }

    @Test
    void rejectedDecisionTest() {

        ApplicationStatus decision = scoringCalculator.calculateDecision(MANUAL_REVIEW_SCORE - 1);

        assertEquals(ApplicationStatus.REJECTED, decision);
    }
}
