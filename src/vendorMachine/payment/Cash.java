package vendorMachine.payment;

public class Cash implements Payment {
    @Override
    public boolean doPayment() {
        /*
        there may be different validation for balance, wallet availability, and so on.
        interaction with some classes like User use of methods User.getCash() and etc.
        For simplicity, the logic is omitted.
         */
        return true;
    }
}
