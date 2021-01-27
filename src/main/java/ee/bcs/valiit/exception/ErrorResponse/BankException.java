package ee.bcs.valiit.exception.ErrorResponse;

public class BankException extends RuntimeException {
    public BankException(String message) {
        super(message);
    }
}
