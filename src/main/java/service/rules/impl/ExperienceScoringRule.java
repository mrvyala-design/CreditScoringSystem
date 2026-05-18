package service.rules.impl;

import model.Client;
import model.Employment;
import service.rules.ScoringRule;

import static util.Constants.*;

public class ExperienceScoringRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        Employment job = client.getEmployments().get(0);

        int years = job.getExperienceYears();

        if (years < MIN_EXPERIENCE) {
            return LOW_EXPERIENCE_PENALTY;
        } else if (years <= GOOD_EXPERIENCE) {
            return MEDIUM_EXPERIENCE_BONUS;
        } else {
            return HIGH_EXPERIENCE_BONUS;
        }
    }
}