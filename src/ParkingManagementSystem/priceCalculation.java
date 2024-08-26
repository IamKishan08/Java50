package ParkingManagementSystem;

public class priceCalculation {
    private static final int RATE_PER_HOUR = 10;


    public static int calculatePrice(Ticket ticket){
        long durationMinutes = ticket.calculateTime();
        int hour = (int)Math.ceil(durationMinutes/60);
        return RATE_PER_HOUR * hour;
    }

}
