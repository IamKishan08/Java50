package ParkingManagementSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {
    private  Vehicle vehicle;
    private parkingSpot parkingSpots;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    Ticket(Vehicle vehicle, parkingSpot spot){
        this.vehicle = vehicle;
        this.parkingSpots = spot;
        this.entryTime = LocalDateTime.now();
    }

    public void closeTicket(){
        this.exitTime = LocalDateTime.now();
    }

    public long calculateTime(){
        return  java.time.Duration.between(entryTime,exitTime).toMinutes();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public parkingSpot getParkingSpots() {
        return parkingSpots;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }
}
