package FilghtBookingSystem;

class Passenger {
    int passengerId;
    String passengerName;
    double ticketPrice;

    public Passenger(int passengerId,String passengerName , double ticketPrice){
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.ticketPrice = ticketPrice;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
