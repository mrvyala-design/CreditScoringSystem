package service.rules.impl;

import model.Client;
import model.Employment;
import service.rules.ScoringRule;

import static util.Constants.*;

public class CreditLoadRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        Employment job = client.getEmployments().get(0);

        int salary = job.getSalary();

        int ratio = amount / salary;

        if (ratio > HIGH_CREDIT_LOAD) {
            return HIGH_CREDIT_LOAD_PENALTY;
        } else if (ratio > MEDIUM_CREDIT_LOAD) {
            return MEDIUM_CREDIT_LOAD_PENALTY;
        } else {
            return LOW_CREDIT_LOAD_BONUS;
        }
    }
}
