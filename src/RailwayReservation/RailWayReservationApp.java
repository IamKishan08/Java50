//package RailwayReservation;
//
//import java.util.*;
//
//public class RailWayReservationApp {
//
//    // Constants
//    private static final int TOTAL_BERTHS = 63;
//    private static final int RAC_BERTHS = 9;
//    private static final int WAITING_LIST_BERTHS = 10;
//
//    // Data structures
//    private List<Passenger> confirmedTickets = new ArrayList<>();
//    private List<Passenger> racTickets = new ArrayList<>();
//    private Queue<Passenger> waitingList = new LinkedList<>();
//
//    // Main method
//    public static void main(String[] args) {
//        RailWayReservationApp system = new RailWayReservationApp();
//        system.run();
//    }
//
//    // Method to run the system
//    public void run() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("\n1. Book Ticket");
//            System.out.println("2. Cancel Ticket");
//            System.out.println("3. Print Booked Tickets");
//            System.out.println("4. Print Available Tickets");
//            System.out.println("5. Exit");
//            System.out.print("Choose an option: ");
//            int option = scanner.nextInt();
//            scanner.nextLine();  // Consume newline
//
//            switch (option) {
//                case 1:
//                    bookTicket(scanner);
//                    break;
//                case 2:
//                    cancelTicket(scanner);
//                    break;
//                case 3:
//                    printBookedTickets();
//                    break;
//                case 4:
//                    printAvailableTickets();
//                    break;
//                case 5:
//                    System.out.println("Exiting...");
//                    scanner.close();
//                    return;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//
//    // Method to book a ticket
//    private void bookTicket(Scanner scanner) {
//        if (waitingList.size() >= WAITING_LIST_BERTHS) {
//            System.out.println("No tickets available.");
//            return;
//        }
//
//        System.out.print("Enter Name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter Age: ");
//        int age = scanner.nextInt();
//        scanner.nextLine();  // Consume newline
//        System.out.print("Enter Gender (M/F): ");
//        String gender = scanner.nextLine();
//        System.out.print("Enter Berth Preference (U, M, L, SU, SL): ");
//        String berthPreference = scanner.nextLine();
//
//        if (age < 5) {
//            System.out.println("Tickets cannot be allocated for children below age 5.");
//            return;
//        }
//
//        Passenger passenger = new Passenger(name, age, gender, berthPreference);
//
//        if (confirmedTickets.size() < TOTAL_BERTHS) {
//            allocateBerth(passenger);
//            confirmedTickets.add(passenger);
//        } else if (racTickets.size() < RAC_BERTHS) {
//            racTickets.add(passenger);
//            System.out.println("Allocated RAC berth.");
//        } else if (waitingList.size() < WAITING_LIST_BERTHS) {
//            waitingList.add(passenger);
//            System.out.println("Added to waiting list.");
//        } else {
//            System.out.println("No tickets available.");
//        }
//
//        manageTicketAllocation();
//    }
//
//    // Method to cancel a ticket
//    private void cancelTicket(Scanner scanner) {
//        System.out.print("Enter Name of Passenger to cancel: ");
//        String name = scanner.nextLine();
//
//        Passenger passenger = findPassenger(name);
//        if (passenger == null) {
//            System.out.println("Passenger not found.");
//            return;
//        }
//
//        if (confirmedTickets.remove(passenger)) {
//            System.out.println("Ticket cancelled.");
//            manageTicketAllocation();
//        } else if (racTickets.remove(passenger)) {
//            System.out.println("RAC ticket cancelled.");
//            manageTicketAllocation();
//        } else if (waitingList.remove(passenger)) {
//            System.out.println("Waiting list ticket removed.");
//        } else {
//            System.out.println("Ticket not found.");
//        }
//    }
//
//    // Method to print booked tickets
//    private void printBookedTickets() {
//        System.out.println("\nBooked Tickets:");
//        for (Passenger passenger : confirmedTickets) {
//            System.out.println(passenger);
//        }
//        System.out.println("Total booked tickets: " + confirmedTickets.size());
//    }
//
//    // Method to print available tickets
//    private void printAvailableTickets() {
//        System.out.println("\nAvailable Tickets:");
//        int availableBerths = TOTAL_BERTHS - confirmedTickets.size();
//        int availableRAC = RAC_BERTHS - racTickets.size();
//        int availableWaitingList = WAITING_LIST_BERTHS - waitingList.size();
//
//        System.out.println("Confirmed Berths Available: " + availableBerths);
//        System.out.println("RAC Berths Available: " + availableRAC);
//        System.out.println("Waiting List Slots Available: " + availableWaitingList);
//    }
//
//    // Helper method to find a passenger by name
//    private Passenger findPassenger(String name) {
//        for (Passenger passenger : confirmedTickets) {
//            if (passenger.getName().equalsIgnoreCase(name)) {
//                return passenger;
//            }
//        }
//        for (Passenger passenger : racTickets) {
//            if (passenger.getName().equalsIgnoreCase(name)) {
//                return passenger;
//            }
//        }
//        for (Passenger passenger : waitingList) {
//            if (passenger.getName().equalsIgnoreCase(name)) {
//                return passenger;
//            }
//        }
//        return null;
//    }
//
//    // Helper method to allocate berth
//    private void allocateBerth(Passenger passenger) {
//        // Simplified berth allocation logic
//        // In practice, you would need a more sophisticated algorithm
//        if (passenger.getAge() > 60 || (passenger.getGender().equalsIgnoreCase("F") && passenger.getAge() < 5)) {
//            System.out.println("Allocated Lower Berth.");
//        } else if (passenger.getBerthPreference().equalsIgnoreCase("SL")) {
//            System.out.println("Allocated Side Lower Berth.");
//        } else {
//            System.out.println("Allocated Berth as per preference.");
//        }
//    }
//
//    // Helper method to manage ticket allocation
//    private void manageTicketAllocation() {
//        if (!racTickets.isEmpty() && confirmedTickets.size() < TOTAL_BERTHS) {
//            Passenger passenger = racTickets.remove(0);
//            confirmedTickets.add(passenger);
//            System.out.println("RAC ticket confirmed.");
//        }
//        if (!waitingList.isEmpty() && racTickets.size() < RAC_BERTHS) {
//            Passenger passenger = waitingList.poll();
//            racTickets.add(passenger);
//            System.out.println("Waiting list ticket moved to RAC.");
//        }
//    }
//}
//
//// Passenger class to store passenger details
//class Passenger {
//    private String name;
//    private int age;
//    private String gender;
//    private String berthPreference;
//
//    public Passenger(String name, int age, String gender, String berthPreference) {
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.berthPreference = berthPreference;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public String getBerthPreference() {
//        return berthPreference;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("Name: %s, Age: %d, Gender: %s, Berth Preference: %s",
//                name, age, gender, berthPreference);
//    }
//}
