package service;

import model.Client;
import model.CreditHistory;
import model.Employment;

import java.time.LocalDate;
import java.util.List;

public class ScoringCalculator {

    public int calculateScore(Client client, int amount) {

        int score = 0;

        //Возраст
        int age = LocalDate.now().getYear() - client.getBirthDate().getYear();

        if (age < 21) {
            score -= 20;
        } else if (age <= 60) {
            score += 10;
        } else {
            score -= 10;
        }

        //Работа
        List<Employment> jobs = client.getEmployments();

        if (jobs != null && !jobs.isEmpty()) {

            Employment job = jobs.get(0);

            int salary = job.getSalary();
            int experienceYears = job.getExperienceYears();

            //зарплата
            if (salary > 3500) {
                score += 50;
            } else if (salary > 2500) {
                score += 30;
            } else {
                score += 10;
            }

            //стаж
            if (experienceYears < 1) {
                score -= 20;
            } else if (experienceYears <= 3) {
                score += 10;
            } else {
                score += 20;
            }

            //кредитная нагрузка
            int ratio = amount / salary;

            if (ratio > 10) {
                score -= 30;
            } else if (ratio > 5) {
                score -= 10;
            } else {
                score += 10;
            }
        } else {
            score -= 100;
        }

        //Кредитная история
        CreditHistory history = client.getCreditHistory();

        if (history != null) {

            if (history.getOverdueCount() == 0) {
                score += 30;
            } else {
                score -= 20;
            }

            int activeLoans = history.getActiveLoans();

            if (activeLoans > 3) {
                score -= 30;
            } else if (activeLoans > 0) {
                score -= 10;
            } else {
                score += 10;
            }
        }

        return score;
    }

    public String calculateDecision(int score) {

        if (score >= 70) {
            return "APPROVED";
        } else if (score >= 40) {
            return "MANUAL_REVIEW";
        } else {
            return "REJECTED";
        }
    }
}
