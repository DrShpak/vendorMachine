package vendorMachine.machine;

import vendorMachine.machine.row.Product;
import vendorMachine.payment.Payment;

public abstract class AbstractVendorMachine {
    private final String model;

    public AbstractVendorMachine(String model) {
        this.model = model;
    }

    public abstract Product buy(String rowName, Payment payment);
}
