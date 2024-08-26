package RailwayReservation;

import java.util.Scanner;

public class Reservation {


// Ticket Booking
    public void bookTicket(Scanner sc) {

        System.out.println("-------------------");
        System.out.print("No of Tickets you want to Book : " );
        int noOfTickets = sc.nextInt();
        System.out.println("-------------------");

        if(Train.availableWaitingList == 0){
            System.out.println("No tickets Available");
            return;
        }

        for (int i = 0; i < noOfTickets; i++) {

            System.out.println("Enter Passenger Details :" + (i+1));

            System.out.println("Enter Passenger Name : ");
            String passengerName = sc.next();

            System.out.println("Enter Passenger Age : ");
            int age = sc.nextInt();

            System.out.println("Enter Gender (M/F) : ");
            char gender = sc.next().charAt(0);
            sc.nextLine();

            System.out.println("Enter Berth Preference (U/M/L) : ");
            String berthPreference = sc.next();

            Passenger passenger = new Passenger(passengerName,berthPreference,age,gender);

            //checkBerthPreference
            if(berthPreference.equalsIgnoreCase("L") && Train.availableLowerBerth > 0){
                confirmTicket(passenger,"L",Train.lowerBerthPosition.remove(0));
                Train.availableLowerBerth--;
            }else if(berthPreference.equalsIgnoreCase("M") && Train.availableMiddleBerth > 0){
                confirmTicket(passenger,"M",Train.middleBerthPosition.remove(0));
                Train.availableMiddleBerth--;
            }else if(berthPreference.equalsIgnoreCase("U") && Train.availableUpperBerth > 0){
                confirmTicket(passenger,"U",Train.upperBerthPosition.remove(0));
                Train.availableUpperBerth--;
            } else if ( Train.availableLowerBerth > 0){
                confirmTicket(passenger,"L",Train.lowerBerthPosition.remove(0));
                Train.availableLowerBerth--;
            }else if ( Train.availableMiddleBerth > 0){
                confirmTicket(passenger,"M",Train.middleBerthPosition.remove(0));
                Train.availableMiddleBerth--;
            }else if ( Train.availableUpperBerth > 0){
                confirmTicket(passenger,"U",Train.upperBerthPosition.remove(0));
                Train.availableUpperBerth--;
            }else if(Train.availableRac > 0 ){
               racTicket(passenger);
            } else if (Train.availableWaitingList>0) {
                waitingList(passenger);
            } else {
                System.out.println("No Tickets Available");
            }

        }


    }

    private void confirmTicket(Passenger passenger, String berthType, int seatNumber) {
        Ticket ticket = new Ticket(passenger,"Confirmed",berthType,seatNumber);
        Train.passengerMap.put(passenger.passengerId,ticket);
        Train.confirmedTicket.add(ticket);
        System.out.println("Ticket Booking Confirmed. Passenger Id :" + ticket.passenger.passengerId);
    }

    private void racTicket(Passenger passenger) {
        Ticket ticket = new Ticket(passenger,"RAC","RAC",Train.racPosition.remove(0));
        Train.passengerMap.put(passenger.passengerId ,ticket);
        Train.racList.add(ticket);
        Train.availableRac--;
        System.out.println("Added to RAC. RAC no :" +ticket.seatNumber);
    }

    private void waitingList(Passenger passenger) {
        Ticket ticket = new Ticket(passenger, "WL" ,"Wl",Train.waitingListPosition.remove(0));
        Train.passengerMap.put(passenger.passengerId,ticket);
        Train.waitingList.add(ticket);
        Train.availableWaitingList--;
        System.out.println("Added to Waiting List No : " +ticket.seatNumber);
    }


    public void cancelTicket(Scanner sc) {

        System.out.println("Enter Passenger Id to Cancel: ");
        int passId = sc.nextInt();

        if(!Train.passengerMap.containsKey(passId)){
            System.out.println("Invalid Passenger Id");
            return;
        }

        Ticket ticket = Train.passengerMap.remove(passId);
        Train.confirmedTicket.remove(ticket);

        System.out.println("Ticket Cancelled SuccessFully for passenger id" + passId);


        if(ticket.status.equals("Confirmed")){
            handleCancellation(ticket);
        } else if (ticket.status.equals("RAC")) {
            Train.racList.remove(ticket);
            Train.availableRac++;
            Train.racPosition.add(ticket.seatNumber);
        }else if(ticket.status.equals("WL")){
            Train.waitingList.remove(ticket);
            Train.availableWaitingList++;
            Train.waitingListPosition.add(ticket.seatNumber);
        }


    }

    private void handleCancellation(Ticket ticket) {
        if(!Train.racList.isEmpty()){
            Ticket racTicket = Train.racList.poll();
            Train.racPosition.add(racTicket.seatNumber);
            Train.availableRac++;
            confirmTicket(racTicket.passenger, ticket.berthType, ticket.seatNumber);
        } else{
            if (ticket.berthType.equals("L")){
                Train.availableLowerBerth++;
                Train.lowerBerthPosition.add(ticket.seatNumber);
            }else if (ticket.berthType.equals("M")){
                Train.availableMiddleBerth++;
                Train.middleBerthPosition.add(ticket.seatNumber);
            }else if (ticket.berthType.equals("U")) {
                Train.availableUpperBerth++;
                Train.upperBerthPosition.add(ticket.seatNumber);
            }
        }

        if(!Train.waitingList.isEmpty()){
            Ticket waitingTicket = Train.waitingList.poll();
            Train.availableWaitingList++;
            Train.waitingListPosition.add(waitingTicket.seatNumber);
            racTicket(waitingTicket.passenger);
        }
    }

    public void viewTicket(Scanner sc) {
        System.out.println("Enter Passenger ID to view the Ticket");
        int n = sc.nextInt();

        if(!Train.passengerMap.containsKey(n)){
            System.out.println("Invalid Passenger Id");
            return;
        }

        Ticket ticket = Train.passengerMap.get(n);
        System.out.println("Passenger ID : " + ticket.passenger.passengerId);
        System.out.println("Name : " + ticket.passenger.passengerName);
        System.out.println("Age: " +ticket.passenger.age);
        System.out.println("Gender: " + ticket.passenger.gender);
        System.out.println("Status : " + ticket.status );
        System.out.println("Allocated Berth : " +ticket.berthType);
        System.out.println("Seat Number : " + ticket.seatNumber);

    }

    public void availableTicket() {

        System.out.println("Total Available Seats Berth vice: ");

        System.out.println("Lower Berth :" + Train.availableLowerBerth);
        System.out.println("Middle Berth :" + Train.availableMiddleBerth);
        System.out.println("Upper Berth :" + Train.availableUpperBerth);
        System.out.println("Rac ticket :" + Train.availableRac);
        System.out.println("Waiting List :" + Train.availableWaitingList);

    }


}
