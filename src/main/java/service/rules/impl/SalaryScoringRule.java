package service.rules.impl;

import model.Client;
import model.Employment;
import service.rules.ScoringRule;

import java.util.List;

public class SalaryScoringRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        List<Employment> jobs = client.getEmployments();

        if (jobs.isEmpty()) {
            return -100;
        }

        int salary = jobs.get(0).getSalary();

        if (salary > 3500) {
            return 50;
        } else if (salary > 2500) {
            return 30;
        } else {
            return 10;
        }
    }
}