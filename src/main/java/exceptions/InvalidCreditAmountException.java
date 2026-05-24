package exceptions;

public class InvalidCreditAmountException extends RuntimeException {
    public InvalidCreditAmountException(int amount) {
        super("Invalid credit amount: " + amount);
    }
}