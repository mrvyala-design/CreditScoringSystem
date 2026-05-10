package service.rules.impl;

import model.Client;
import model.Employment;
import service.rules.ScoringRule;

public class ExperienceScoringRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        Employment job = client.getEmployments().get(0);

        int years = job.getExperienceYears();

        if (years < 1) {
            return -20;
        } else if (years <= 3) {
            return 10;
        } else {
            return 20;
        }
    }
}