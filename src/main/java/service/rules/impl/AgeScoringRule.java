package service.rules.impl;

import model.Client;
import service.rules.ScoringRule;

import java.time.LocalDate;

public class AgeScoringRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        int age = LocalDate.now().getYear() - client.getBirthDate().getYear();

        if (age < 21) {
            return -20;
        } else if (age <= 60) {
            return 10;
        } else {
            return -10;
        }
    }
}
