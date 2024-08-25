package FilghtBookingSystem;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        BookingSystem book = new BookingSystem();

        boolean  loop = true;

        System.out.println("Welcome to Flight Booking Application");
        while (loop){
            System.out.println("\n1. Book Flight");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Print Flight Details");
            System.out.println("4. View Booked Ticket");
            System.out.println("5. Exit");
            System.out.print("Enter your Choice : ");

            int count = s.nextInt();

            switch (count){
                case 1:
                    System.out.println("Flight Ticket Booking");
                    try{
                    System.out.println("Enter Passenger Name: ");
                    String name = s.next();
                    System.out.println("Enter Passenger Id: ");
                    int id = s.nextInt();
                    System.out.println("Enter No of Ticket: ");
                    int noOfTicket = s.nextInt();
                    book.bookTicket(id,name,noOfTicket);
                    }
                    catch (Exception e){
                        System.out.println("Something Went Wrong");
                    }
                    break;
                case 2:
                    System.out.println("Cancel Booking");
                    break;
                case 3:
                    System.out.println("View Flight Details");
                    break;
                case 4:
                    System.out.println("View Booked Ticket");
                    book.viewPassengerList();
                    break;
                case 5:
                    System.out.println("Exiting Application");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid Choice Please Try again");
            }
        }

    }
}
