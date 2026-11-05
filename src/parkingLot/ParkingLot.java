package parkingLot;

import parkingSpot.ParkingSpot;
import payment.PaymentStrategy;
import pricing.BikePricingStrategy;
import pricing.CarPricingStrategy;
import pricing.PricingStrategy;
import vehicle.Bike;
import vehicle.Vehicle;
import ticket.ParkingTicket;
import ticket.FeeCalculator;
import java.util.*;

public class ParkingLot {

    private List<ParkingSpot> parkingSpots;
    private Map<String, ParkingTicket> activeTickets;
    private FeeCalculator feeCalculator;

    public ParkingLot() {
        parkingSpots = new ArrayList<>();
        activeTickets = new HashMap<>();
        feeCalculator = new FeeCalculator();
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public boolean processPayment(double amount, PaymentStrategy paymentStrategy){
        return paymentStrategy.pay(amount);
    }

    // Vehicle entry
    public ParkingTicket enterVehicle(Vehicle vehicle) {

        String registrationNumber = vehicle.getRegistrationNumber();
        if (activeTickets.containsKey(registrationNumber)) {
            return null;
        }

        for (ParkingSpot spot : parkingSpots) {

            if (spot.isAvailable() && spot.canFit(vehicle)) {
                spot.parkVehicle(vehicle);
                String ticketId = UUID.randomUUID().toString();
                ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, spot);
                activeTickets.put(registrationNumber, ticket);

                return ticket;
            }
        }
        return null;
    }

    // Vehicle exit
    public double exitVehicle(String registrationNumber) {

        ParkingTicket ticket = activeTickets.get(registrationNumber);
        if (ticket == null) {
            return -1;
        }

        Vehicle vehicle=ticket.getVehicle();
        PricingStrategy pricingStrategy;
        if(vehicle instanceof Bike){
            pricingStrategy=new BikePricingStrategy();
        }else {
            pricingStrategy=new CarPricingStrategy();
        }

        double fee=feeCalculator.calculateFee(ticket,pricingStrategy);
        ParkingSpot spot = ticket.getParkingSpot();
        spot.removeVehicle();
        activeTickets.remove(registrationNumber);
        return fee;
    }

    public void displayAvailableSpots() {

        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable()) {
                System.out.println("Available Spot: "  + spot.getSpotNumber());
            }
        }
    }
}