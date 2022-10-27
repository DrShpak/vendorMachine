package vendorMachine.payment;

public class Card implements Payment {
    @Override
    public boolean doPayment() {
        /*
        there may be different validation for balance, wallet availability, and so on.
        interaction with external interfaces, payment APIs, etc.
        For simplicity, the logic is omitted.
         */
        return true;
    }
}
