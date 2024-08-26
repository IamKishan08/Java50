package ParkingManagementSystem;

public class parkingSpot {
    private String spotNumber;
    private Vehicle vehicle;

    public parkingSpot(String spotNumber){
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void unParkVehicle(){
        this.vehicle =null;
    }

    public boolean isFree(){
        return vehicle == null;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
