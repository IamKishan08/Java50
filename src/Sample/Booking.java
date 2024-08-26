package Sample;

import java.util.List;

public class Booking {

    public void book(Flight currentFlight,int passengerId,int noOfTickets){
            String passengerDetails = "Passenger Id: " + passengerId + " Number of Tickets: " + noOfTickets + " Total cost: " + currentFlight.getCurrentPrice() * noOfTickets;
            addPassengers(passengerDetails,passengerId,noOfTickets,currentFlight);
            FileHandling.addRecord(new Passenger(passengerDetails,passengerId,noOfTickets,currentFlight.getCurrentPrice() * noOfTickets), currentFlight.getFlightId());
            currentFlight.flightSummary();
    }

    public static void addPassengers(String details, int passengerId, int noOfTickets, Flight currentFlight){
        double totalCost = currentFlight.getCurrentPrice() * noOfTickets;
        currentFlight.getPassengers().add(new Passenger(details,passengerId,noOfTickets,totalCost));

        double price = currentFlight.getCurrentPrice() + 200 * noOfTickets;
        currentFlight.setCurrentPrice(price);

        int availableTickets = currentFlight.getAvailableTickets() - noOfTickets;

        currentFlight.setAvailableTickets(availableTickets);

        System.out.println("Booked SuccessFully");


    }






    public void print(Flight f){
          f.print();
    }

    public void cancel(Flight currentFlight, int id) {



     Passenger passengerCancel = null;

      for(Passenger p : currentFlight.getPassengers()){
          if(p.getId() == id){
              passengerCancel = p;
              break;
          }
      }

      if(passengerCancel == null){
          System.out.println("Passenger Id Not Found");
          return;
      }

      int ticketTOCancel = passengerCancel.getBookedTickets();
      double refund = passengerCancel.getCostPaid();

      currentFlight.setAvailableTickets(currentFlight.getAvailableTickets()+ ticketTOCancel);
      currentFlight.setCurrentPrice(currentFlight.getCurrentPrice() - 200 * ticketTOCancel);

      currentFlight.getPassengers().remove(passengerCancel);

        FileHandling.removeRecord(currentFlight.getFlightId(), id);

        List<Passenger> passengers = FileHandling.getRecords(currentFlight.getFlightId());

        currentFlight.getPassengers().clear();

        currentFlight.getPassengers().addAll(passengers);

        System.out.println( );
        System.out.println("Ticket cancelled and refunded" + refund);

        currentFlight.flightSummary();

    }
}
