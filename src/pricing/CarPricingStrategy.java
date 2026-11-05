package pricing;

public class CarPricingStrategy implements PricingStrategy{
    @Override
    public double getHourlyRate() {
        return 40;
    }
}
