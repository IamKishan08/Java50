package RailwayReservation;

import java.util.*;

public class Train {

    static int availableLowerBerth = 1;
    static int availableMiddleBerth = 1;
    static int availableUpperBerth = 1;
    static int availableRac = 1;
    static int availableWaitingList = 1;


    static Queue<Ticket> racList =  new LinkedList<>();
    static Queue<Ticket> waitingList = new LinkedList<>();
    static List<Ticket> confirmedTicket = new ArrayList<>();


    static List<Integer> lowerBerthPosition = new ArrayList<>();
    static List<Integer> middleBerthPosition = new ArrayList<>();
    static List<Integer> upperBerthPosition = new ArrayList<>();
    static List<Integer> racPosition = new ArrayList<>();
    static List<Integer> waitingListPosition = new ArrayList<>();

    static {
        for (int i = 1; i <= availableLowerBerth; i++) {
            lowerBerthPosition.add(i);
        }
        for (int i = 1; i <= availableMiddleBerth; i++) {
            middleBerthPosition.add(i);
        }
        for (int i = 1; i <= availableUpperBerth; i++) {
            upperBerthPosition.add(i);
        }
        for (int i = 1; i <= availableRac; i++) {
            racPosition.add(i);
        }
        for (int i = 1; i <= availableWaitingList; i++) {
             waitingListPosition.add(i);
        }
    }


    static Map<Integer,Ticket> passengerMap = new HashMap<>();

}
