package RailwayReservation;

public class Ticket {
    Passenger passenger;
    String status; // confirmed , RAC , WL
    String berthType ;  // L , M, U, RAC , WL
    int seatNumber ;

    Ticket(Passenger passenger, String status , String berthType, int seatNumber){
         this.passenger = passenger;
         this.status = status;
         this.berthType = berthType;
         this.seatNumber = seatNumber;
    }
}
