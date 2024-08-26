package FilghtBookingSystem;

public class Flight {
    int flightId;
    int availableSeats;
    double currentPrice ;

    public Flight(int flightId){
        this.flightId = flightId;
        this.availableSeats = 50;
        this.currentPrice = 5000;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
}
