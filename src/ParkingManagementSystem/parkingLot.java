package ParkingManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class parkingLot {

    private String name;
    private List<parkingFloor> floorList;
    private List<Ticket> parkedVehicle = new ArrayList<>();



    parkingLot(String name,int noOfFloors,int noOfSpots){
        this.name = name;
        floorList = new ArrayList<>();

        for (int i = 1; i <= noOfFloors ; i++) {
            floorList.add(new parkingFloor(i,noOfSpots));
        }
    }

    public parkingSpot parkVehicle(Vehicle vehicle){
        for(parkingFloor floor: floorList){
            parkingSpot spot = floor.getFreeSpot();
            if(spot != null){
                spot.parkVehicle(vehicle);
                Ticket ticket = new Ticket(vehicle,spot);
                parkedVehicle.add(ticket);
                return spot;
            }
        }
        System.out.println("Parking Spot is Full");
        return null;
    }

    public Ticket unPark(Vehicle vehicle){
        for (parkingFloor floor : floorList){
            parkingSpot spot = floor.occupiedSpot(vehicle);
            if(spot != null){
                spot.unParkVehicle();
                return new Ticket(vehicle,spot);
            }
        }
        System.out.println("Vehicle Not found");
        return null;
    }

    public void displayAvailability(){
        for (parkingFloor floor : floorList){
            System.out.println("Floor : " + floor.getFloorNumber() + " No.of.Free.Spots :" + floor.getFreeSpotCount());
        }
    }

    public void displayOccupiedSpots(){
        for(parkingFloor floor : floorList){
            floor.displayOccupiedSpots();
        }
    }




}
