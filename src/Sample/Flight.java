package Sample;

import java.util.ArrayList;
import java.util.List;

public class Flight {

    private static  int idCounter = 0;
    private int flightId;
    private  int availableTickets;
    private double currentPrice;
    private final List<Passenger> passengers;


    Flight(){
        flightId = ++idCounter;
        availableTickets = 50;
        currentPrice = 5000;
        passengers = new ArrayList<>();
    }
    Flight(int id, int availableTickets , double currentPrice , List<Passenger> passengers){
       this.flightId = id;
       this.availableTickets = availableTickets;
       this.currentPrice =currentPrice;
       this.passengers = passengers;
    }

    public int getFlightId() {
        return flightId;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    List<Passenger> getPassengers() {
        return passengers;
    }

    public  void flightSummary(){
        System.out.println("Flight Id :" + flightId + " No of  tickets Available :" + availableTickets + " Current Price: " +currentPrice);
    }


    public void print(){
        System.out.println("Flight Id " +flightId + "-->");
        for (Passenger passenger : passengers){
            System.out.println(passenger.getDetails());
        }
    }
}
