package vendorMachine.exception;

public class RowIsEmptyException extends RuntimeException {
    public RowIsEmptyException() {
        super("The row is empty!");
    }
}
