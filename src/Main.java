import parkingLot.ParkingLot;
import parkingSpot.BikeSpot;
import parkingSpot.CarSpot;
import parkingSpot.ParkingSpot;
import payment.PaymentStrategy;
import payment.UpiPayment;
import ticket.ParkingTicket;
import vehicle.Bike;
import vehicle.Car;
import vehicle.Vehicle;

public class Main {
    public static void main() {

//        ParkingLot parkingLot = new ParkingLot();
//
//        parkingLot.addParkingSpot(new BikeSpot(101));
//        parkingLot.addParkingSpot(new BikeSpot(102));
//
//        parkingLot.addParkingSpot(new CarSpot(201));
//        parkingLot.addParkingSpot(new CarSpot(202));
//
//        Vehicle bike = new Bike("TS09AB1234");
//        Vehicle car = new Car("TS10CD5678");
//
//        // Vehicle entry
//        ParkingTicket bikeTicket = parkingLot.enterVehicle(bike);
//        ParkingTicket carTicket = parkingLot.enterVehicle(car);
//
//        System.out.println("Bike Ticket: " + bikeTicket.getTicketId());
//
//        System.out.println("Car Ticket: " + carTicket.getTicketId());
//
//        // Display available spots
//        System.out.println("\nAvailable spots:");
//        parkingLot.displayAvailableSpots();
//
//        // Vehicle exit
//        double bikeFee = parkingLot.exitVehicle("TS09AB1234");
//
//        System.out.println("\nBike parking fee: Rs." + bikeFee);
//
//        // Display available spots again
//        System.out.println("\nAvailable spots after bike exit:");
//        parkingLot.displayAvailableSpots();
//
//        double fee = parkingLot.exitVehicle("TS10CD5678");
//
//        PaymentStrategy payment = new UpiPayment();
//
//        boolean paymentStatus = parkingLot.processPayment(fee, payment);
//
//        System.out.println("Payment successful: " + paymentStatus);

        ParkingLot parkingLot = new ParkingLot();

        // Create parking spots
        parkingLot.addParkingSpot(new BikeSpot(101));
        parkingLot.addParkingSpot(new CarSpot(201));

        // Create vehicles
        Vehicle bike = new Bike("BIKE101");
        Vehicle car = new Car("CAR101");
        Vehicle bike2 = new Bike("BIKE102");

        // Test 1: Bike entry
        ParkingTicket ticket1 = parkingLot.enterVehicle(bike);
        System.out.println("Test 1: " + (ticket1 != null));

        // Test 2: Car entry
        ParkingTicket ticket2 = parkingLot.enterVehicle(car);
        System.out.println("Test 2: " + (ticket2 != null));

        // Test 3: Wrong spot compatibility
        ParkingSpot carSpot = new CarSpot(301);
        System.out.println("Test 3: " + !carSpot.parkVehicle(bike));

        // Test 4: Parking lot full for bikes
        System.out.println("Test 4: " +
                        (parkingLot.enterVehicle(bike2) == null));

        // Test 5: Duplicate vehicle entry
        System.out.println("Test 5: " +
                        (parkingLot.enterVehicle(bike) == null));

        // Test 6: Vehicle exit
        double fee = parkingLot.exitVehicle("BIKE101");
        System.out.println("Test 6: " + (fee >= 0));

        // Test 7: Spot available after exit
        System.out.println("Test 7: Available spots after exit:");
        parkingLot.displayAvailableSpots();

        // Test 8: Unknown vehicle exit
        System.out.println("Test 8: " +
                (parkingLot.exitVehicle("UNKNOWN") == -1));
    }
}