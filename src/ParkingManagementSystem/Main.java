package ParkingManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        parkingLot lot = new parkingLot("MyParking", 3, 3);

        Scanner s = new Scanner(System.in);

        boolean loop = true;

        while (loop) {
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Unpark Vehicle");
            System.out.println("3. Display Available Spots");
            System.out.println("4. Display Occupied Spots");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {

                case 1:{
                    System.out.println("Enter Vehicle Number: ");
                    String vehicleNo = s.nextLine();
                    System.out.println("Enter Vehicle Type:");
                    String type = s.nextLine();
                    Vehicle vehicle = new Vehicle(vehicleNo,type);
                    parkingSpot spot = lot.parkVehicle(vehicle);
                    if(spot != null){
                        System.out.println("Vehicle parked at spot " + spot.getSpotNumber());
                    }
                    break;
                }
                case 2:{
                    System.out.println("Enter Vehicle Number : ");
                    String vehicleNo = s.nextLine();
                    Vehicle vehicle = new Vehicle(vehicleNo,"2");
                    Ticket ticket = lot.unPark(vehicle);
                    if(ticket!= null){
                        ticket.closeTicket();
                        int fee = priceCalculation.calculatePrice(ticket);
                        System.out.println("Parking Fee : " +fee + " units" );
                    }
                    break;
                }
                case 3:{
                    lot.displayAvailability();
                    break;
                }
                case 4:{
                    lot.displayOccupiedSpots();
                    break;
                }
                case 5:{
                    System.out.println("Exiting System");
                    s.close();
                    loop = false;

                    break;
                } default:{
                    System.out.println("Invalid Choice");
                }

            }

        }
    }

}
