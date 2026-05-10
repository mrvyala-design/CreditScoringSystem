package service;

import model.Client;
import model.enums.ApplicationStatus;
import service.rules.ScoringRule;
import service.rules.impl.*;

import java.util.List;

public class ScoringCalculator {

    private final List<ScoringRule> rules = List.of(
            new AgeScoringRule(),
            new SalaryScoringRule(),
            new ExperienceScoringRule(),
            new CreditLoadRule(),
            new CreditHistoryRule(),
            new ActiveLoansRule()
    );

    public int calculateScore(Client client, int amount) {

        int score = 0;

        for (ScoringRule rule : rules) {
            score += rule.apply(client, amount);
        }

        return score;
    }

    public ApplicationStatus calculateDecision(int score) {

        if (score >= 70) {
            return ApplicationStatus.APPROVED;
        } else if (score >= 40) {
            return ApplicationStatus.MANUAL_REVIEW;
        } else {
            return ApplicationStatus.REJECTED;
        }
    }
}
