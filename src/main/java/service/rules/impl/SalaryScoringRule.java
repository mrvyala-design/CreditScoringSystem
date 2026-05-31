package service.rules.impl;

import model.Client;
import model.Employment;
import service.rules.ScoringRule;

import static util.Constants.*;

import java.util.List;

public class SalaryScoringRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        List<Employment> jobs = client.getEmployments();

        if (jobs == null || jobs.isEmpty()) {
            return NO_JOB_PENALTY;
        }

        double salary = jobs.get(0).getSalary();

        if (salary > HIGH_SALARY) {
            return HIGH_SALARY_BONUS;
        } else if (salary > MEDIUM_SALARY) {
            return MEDIUM_SALARY_BONUS;
        } else {
            return LOW_SALARY_BONUS;
        }
    }
}