package vehicle;

public abstract class Vehicle {
    private String registrationNumber;
    public Vehicle(String registrationNumber){
        this.registrationNumber=registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
