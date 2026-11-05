package parkingSpot;

import vehicle.Vehicle;

public abstract class ParkingSpot {
    private int spotNumber;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.parkedVehicle=null;
    }
    public abstract boolean canFit(Vehicle vehicle);

    public boolean isAvailable(){
        return parkedVehicle==null;
    }

     public boolean parkVehicle(Vehicle vehicle){
        if(!isAvailable()){
            return false;
        }
        if(!canFit(vehicle)){
            return false;
        }
        parkedVehicle=vehicle;
        return true;
     }

     public Vehicle removeVehicle(){
        Vehicle vehicle=parkedVehicle;
        parkedVehicle=null;
        return vehicle;
     }

     public int getSpotNumber(){
        return spotNumber;
     }

     public Vehicle getParkedVehicle(){
        return parkedVehicle;
    }

}
