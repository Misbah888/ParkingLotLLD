package ticket;

import pricing.PricingStrategy;
import java.time.Duration;
import java.time.LocalDateTime;

public class FeeCalculator {
    public double calculateFee(ParkingTicket ticket, PricingStrategy pricingStrategy){
        LocalDateTime entryTime=ticket.getEntryTime();
        LocalDateTime exitTime=LocalDateTime.now();

        long minutes= Duration.between(entryTime,exitTime).toMinutes();

        long hours = Math.max(1, (minutes + 59) / 60);

        return hours * pricingStrategy.getHourlyRate();
    }
}
