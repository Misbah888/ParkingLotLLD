package payment;

public class CashPayment implements PaymentStrategy{

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid Rs."+amount+"using Cash");
        return true;
    }
}
