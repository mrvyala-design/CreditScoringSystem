package service.rules;

import model.Client;

public interface ScoringRule {

    int apply(Client client, int amount);
}