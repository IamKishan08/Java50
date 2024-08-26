package RailwayReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Reservation reservation = new Reservation();

        boolean loop = true;

        while (loop){

            System.out.println("\nWelcome to Railway Reservation System:");

            System.out.println(" 1.Book Ticket \n 2.Cancel Ticket \n 3.View Ticket \n 4.Available Seats \n 5.Exit");

            System.out.println("Enter your Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:{
                    reservation.bookTicket(sc);
                    break;
                }
                case 2:{
                    reservation.cancelTicket(sc);
                    break;
                }
                case 3:{
                    reservation.viewTicket(sc);
                    break;

                }
                case 4:{
                    reservation.availableTicket();
                    break;

                }
                case 5:{
                    System.out.println("Exiting Application");
                    sc.close();
                    loop = false;
                    break;
                }
                default:{
                    System.out.println("Invalid Choice. Try Again.....");
                }
            }
        }

    }
}
