import vendorMachine.machine.ClassicVendorMachine;
import vendorMachine.payment.Cash;

public class Main {
    public static void main(String[] args) {

        ClassicVendorMachine machine = new ClassicVendorMachine("machine 1.0", 4, 4);
        System.out.println(machine.getInfoAboutProducts());
        System.out.println(machine.getRestProductInRow("3"));
        System.out.println(machine.buy("1", new Cash()));
        System.out.println(machine.buy("1", new Cash()));

        System.out.println(machine.getRestProductInRow("1"));

        machine.fillRow("1");
        System.out.println(machine.getRestProductInRow("1"));
    }
}