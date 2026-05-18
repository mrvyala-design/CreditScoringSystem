package service.rules.impl;

import model.Client;
import service.rules.ScoringRule;
import static util.Constants.*;

import java.time.LocalDate;

public class AgeScoringRule implements ScoringRule {

    @Override
    public int apply(Client client, int amount) {

        int age = LocalDate.now().getYear() - client.getBirthDate().getYear();

        if (age < MIN_AGE) {
            return AGE_YOUNG_PENALTY;
        } else if (age <= MAX_GOOD_AGE) {
            return AGE_GOOD_BONUS;
        } else {
            return AGE_OLD_PENALTY;
        }
    }
}