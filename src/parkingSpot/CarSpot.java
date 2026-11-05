package parkingSpot;

import vehicle.Car;
import vehicle.Vehicle;

public class CarSpot extends ParkingSpot{
    public CarSpot(int spotNumber) {
        super(spotNumber);
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        return vehicle instanceof Car;
    }
}
