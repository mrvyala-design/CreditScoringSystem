package service.rules.impl;

import model.Client;
import model.Employment;
import service.rules.ScoringRule;

public class CreditLoadRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        Employment job = client.getEmployments().get(0);

        int salary = job.getSalary();

        int ratio = amount / salary;

        if (ratio > 10) {
            return -30;
        } else if (ratio > 5) {
            return -10;
        } else {
            return 10;
        }
    }
}
