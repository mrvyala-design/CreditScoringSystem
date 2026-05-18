package util;

public final class Constants {

    private Constants() {
    }

    public static final int APPROVED_SCORE = 70;
    public static final int MANUAL_REVIEW_SCORE = 40;

    public static final int MIN_AGE = 21;
    public static final int MAX_GOOD_AGE = 60;

    public static final int AGE_YOUNG_PENALTY = -20;
    public static final int AGE_GOOD_BONUS = 10;
    public static final int AGE_OLD_PENALTY = -10;

    public static final int HIGH_SALARY = 3500;
    public static final int MEDIUM_SALARY = 2500;

    public static final int HIGH_SALARY_BONUS = 50;
    public static final int MEDIUM_SALARY_BONUS = 30;
    public static final int LOW_SALARY_BONUS = 10;

    public static final int MIN_EXPERIENCE = 1;
    public static final int GOOD_EXPERIENCE = 3;

    public static final int LOW_EXPERIENCE_PENALTY = -20;
    public static final int MEDIUM_EXPERIENCE_BONUS = 10;
    public static final int HIGH_EXPERIENCE_BONUS = 20;

    public static final int HIGH_CREDIT_LOAD = 10;
    public static final int MEDIUM_CREDIT_LOAD = 5;

    public static final int HIGH_CREDIT_LOAD_PENALTY = -30;
    public static final int MEDIUM_CREDIT_LOAD_PENALTY = -10;
    public static final int LOW_CREDIT_LOAD_BONUS = 10;

    public static final int GOOD_CREDIT_HISTORY_BONUS = 30;
    public static final int BAD_CREDIT_HISTORY_PENALTY = -20;
    public static final int NO_CREDIT_HISTORY_PENALTY = -5;

    public static final int MANY_ACTIVE_LOANS = 3;

    public static final int MANY_ACTIVE_LOANS_PENALTY = -30;
    public static final int ACTIVE_LOANS_PENALTY = -10;
    public static final int NO_ACTIVE_LOANS_BONUS = 10;

    public static final int NO_JOB_PENALTY = -100;
}
