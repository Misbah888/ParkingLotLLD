package parkingSpot;

import vehicle.Bike;
import vehicle.Vehicle;

public class BikeSpot extends ParkingSpot{
    public BikeSpot(int spotNumber){
        super(spotNumber);
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        return vehicle instanceof Bike;
    }

}
