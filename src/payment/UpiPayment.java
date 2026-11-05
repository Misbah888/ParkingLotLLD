package payment;

public class UpiPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid Rs." + amount + " using UPI");
        return true;
    }
}