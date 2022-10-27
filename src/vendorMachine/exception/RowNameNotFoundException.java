package vendorMachine.exception;

public class RowNameNotFoundException extends RuntimeException {
    public RowNameNotFoundException() {
        super("Wrong row name!");
    }
}
