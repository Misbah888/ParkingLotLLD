package pricing;

public class BikePricingStrategy implements PricingStrategy{

    @Override
    public double getHourlyRate() {
        return 20;
    }
}
