package exceptions;

public class InvalidCreditTermException extends RuntimeException {
    public InvalidCreditTermException(int termMonths) {
        super("Invalid credit term: " + termMonths);
    }
}
