package ParkingManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class parkingFloor {
    private int floorNumber;
    private List<parkingSpot> spots;


    parkingFloor(int floorNumber,int spotCount){
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
        for (int i = 1; i <= spotCount ; i++) {
            spots.add(new parkingSpot(floorNumber + " - " + i));
        }
    }

    public parkingSpot getFreeSpot(){
        for (parkingSpot  spot : spots){
            if (spot.isFree()){
                return spot;
            }
        }
        return null;
    }

    public parkingSpot occupiedSpot(Vehicle vehicle){
        for (parkingSpot spot : spots){
            if (!spot.isFree() && spot.getVehicle().getVehicleNumber().equals(vehicle.getVehicleNumber())){
                return spot;
            }
        }
        return null;
    }

    public int getFloorNumber(){
        return floorNumber;
    }

    public int getFreeSpotCount(){
        int count = 0;
        for (parkingSpot spot : spots){
          if (spot.isFree()){
              count++;
          }
        }
        return count;
    }

    public void displayOccupiedSpots(){
        for(parkingSpot spot: spots){
            if(!spot.isFree()){
                System.out.println("Spot : " + spot.getSpotNumber() + " Vehicle Number : " + spot.getVehicle().getVehicleNumber() + " Vehicle Type : " + spot.getVehicle().getVehicleType());
            }
        }
    }
}
