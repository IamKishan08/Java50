package FilghtBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    List<Passenger> passengers = new ArrayList<>();
    Flight flight = new Flight(1);


    public void bookTicket(int passengerId,String passengerName,int noOfTicket){

        if(noOfTicket<= flight.getAvailableSeats()){
            Passenger passenger = new Passenger(passengerId,passengerName, flight.getCurrentPrice());
            passengers.add(passenger);
            flight.availableSeats -= noOfTicket;
            flight.currentPrice += 200 * noOfTicket;
            System.out.println("Flight Ticket Booked SuccessFully");
        }else {
            System.out.println("Flight Ticket Not Booked");
        }
    }

    public void viewPassengerList(){
        if(passengers.isEmpty()){
            System.out.println("No passengers Found");
        }else {
            System.out.println("Passenger List");
            for (Passenger passenger : passengers){
                System.out.println(passenger.getPassengerId() +" "+ passenger.getPassengerName() +" "+ passenger.getTicketPrice());
            }
        }
    }
}
