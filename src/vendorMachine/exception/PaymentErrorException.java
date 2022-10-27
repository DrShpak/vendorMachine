package vendorMachine.exception;

public class PaymentErrorException extends RuntimeException {
    public PaymentErrorException() {
        super("Payment error!");
    }
}
