package vendorMachine.machine;

import vendorMachine.exception.PaymentErrorException;
import vendorMachine.exception.RowIsEmptyException;
import vendorMachine.exception.RowNameNotFoundException;
import vendorMachine.machine.row.Product;
import vendorMachine.machine.row.Row;
import vendorMachine.payment.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class ClassicVendorMachine extends AbstractVendorMachine implements RandomStringGenerator {
    private final List<Row> rows;

    public ClassicVendorMachine(String model, int numberOfRows, int rowCapacity) {
        super(model);
        this.rows = new ArrayList<>();
        var randomPrice = new Random();

        //create new rows and fill it
        for (int i = 0; i < numberOfRows; i++) {
            rows.add(new Row(i + "", randomPrice.nextInt(100),
                    new Product(generateName()), rowCapacity));
        }
    }

    /**
     *
     * @param rowName name/code of the row
     * @param payment payment method
     * @return purchased product in case of successful operation
     * @throws RowNameNotFoundException incorrect row name
     * @throws RowIsEmptyException no products in this row
     * @throws PaymentErrorException some issues with payment
     */
    @Override
    public Product buy(String rowName, Payment payment) throws RowNameNotFoundException, RowIsEmptyException, PaymentErrorException {
        if (rows.stream().noneMatch(row -> row.getName().equals(rowName))) {
            throw  new RowNameNotFoundException();
        } else {
            var currRow = rows.stream()
                    .filter(row -> row.getName().equals(rowName))
                    .findFirst().get();
            var product =  currRow.next();
            if (product != null) {
                if (doPayment(payment))
                    return product;
                else
                    throw new PaymentErrorException();
            }
            else
                throw new RowIsEmptyException();
        }
    }

    public void fillRow(String name) {
        getRow(name).ifPresent(Row::fillRow);
    }

    public List<String> getNamesOfAllRows() {
        return rows.stream().map(Row::getName).collect(Collectors.toList());
    }

    public List<String> getInfoAboutProducts() {
        return rows.stream()
                .map(Row::toString)
                .collect(Collectors.toList());
    }

    public int getRestProductInRow(String name) throws RowNameNotFoundException {
        var row = getRow(name).orElse(null);
        if (row != null) {
            return row.getRestProducts();
        } else {
            throw new RowNameNotFoundException();
        }
    }

    private Optional<Row> getRow(String name) {
        return rows.stream().filter(row -> row.getName().equals(name)).findFirst();
    }

    private boolean doPayment(Payment payment) {
        return payment.doPayment();
    }
}