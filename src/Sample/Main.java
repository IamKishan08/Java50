package Sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // added two flight like this we can add train and bus
        List<Flight> flight = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            flight.add(new Flight());
        }

        Map<Integer,Flight> flights= FileHandling.loadFlight();



        Scanner s = new Scanner(System.in);
        int passengerId = 1; // auto increment
        boolean loop = true;

        while(loop){

            System.out.println("1.Book 2.Cancel 3.View Ticket 4.Exit");
            System.out.println("Enter your Choice: ");
            int choice = s.nextInt();

            switch (choice){
                case 1:{
                    System.out.println("Enter Flight Id");
                    int fid = s.nextInt();

                    if(fid<=0 || fid > flight.size()){
                        System.out.println("Invalid Flight Id ");
                        break;
                    }
                    Flight currentFlight = flight.get(fid-1);
                    System.out.println();
                    currentFlight.flightSummary();
                    System.out.println("Enter Number of Tickets");
                    int noOfTickets = s.nextInt();

                    // check ticket availability
                    if(noOfTickets > currentFlight.getAvailableTickets()){
                        System.out.println("Not Enough Ticket");
                    }
                    Booking book = new Booking();

                    book.book(currentFlight,passengerId,noOfTickets);

                    passengerId++;
                    break;
                }
                case 2:{
                    System.out.println("Cancel Flight Ticket: Enter Flight Id and Passenger Id");

                    int fid = s.nextInt();

                    if(fid <= 0 || fid> flight.size()){
                        System.out.println("Enter valid Flight Id");
                    }

                    Flight currentFlight = flight.get(fid-1);

                    int id = s.nextInt();

                    Booking book = new Booking();

                    book.cancel(currentFlight,id);

                    break;

                }
                case 3:{
                    if(flight.isEmpty()){
                        System.out.println("No flight Ticket Available");
                    }else{
                    for(Flight f : flights.values()){
                        Booking booking = new Booking();
                        booking.print(f);

                    }
                    }

                }
                break;
                case 4:{
                    System.out.println("Exiting Application");
                    s.close();
                    loop = false;
                    break;
                }
                default:{
                    System.out.println("Invalid choice try again \n");
                }
            }
        }

    }
}
