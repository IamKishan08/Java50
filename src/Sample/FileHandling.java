package Sample;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandling {
    private static final String FILE_PATH = "tickets.txt";

    public static void addRecord(Passenger passenger, int flightId) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String record = flightId + "," + passenger.getId() + "," + passenger.getBookedTickets() + "," + passenger.getCostPaid() + "," + passenger.getDetails();
            writer.write(record);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error while writing to the file " + e.getMessage());
        }
    }

    public static List<Passenger> getRecords(int flightId){
        List<Passenger> passengers = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){

            String line;
            while((line = reader.readLine()) != null){
                  String[] details = line.split(",");

                  int StoredFlightID = Integer.parseInt(details[0]);

                  if(StoredFlightID == flightId){
                      int passengerID = Integer.parseInt(details[1]);
                      int noOfTickets = Integer.parseInt(details[2]);
                      double price = Double.parseDouble(details[3]);
                      String passDe = details[4];
                      passengers.add(new Passenger(passDe,passengerID,noOfTickets,price));
                  }
            }

        }catch (IOException e){
            System.out.println("Error Reading Fle " + e.getMessage());
        }

        return passengers;
    }


    public static  void removeRecord(int flightId,int passengerId){
        File inputFile = new File(FILE_PATH);
        File tempFile = new File("temp.txt");

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null){
                String[] details = line.split(",");
                int storeFlightId = Integer.parseInt(details[0]);
                int paId = Integer.parseInt(details[1]);

                if(storeFlightId != flightId || paId != passengerId){
                    writer.write(line);
                    writer.newLine();
                }else {
                    found = true;
                }
            }

            if(!found){
                System.out.println("Record not found");
            }

        }catch (IOException e){
            System.out.println("Error reading File" + e.getMessage());
        }

        if(!inputFile.delete()){
            System.out.println("could not delete original file");
            return;
        }
        if (!tempFile.renameTo(inputFile)){
            System.out.println("rename error");
        }

    }


    public static Map<Integer,Flight> loadFlight(){
        Map<Integer, Flight> flightMap = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] details = line.split(",");
                int flightId = Integer.parseInt(details[0]);
                int passengerId = Integer.parseInt(details[1]);
                int noOfTickets = Integer.parseInt(details[2]);
                double price  = Double.parseDouble(details[3]);
                String pDetails = details[4];

                Flight flight = flightMap.computeIfAbsent(flightId, k -> new Flight());

                flight.getPassengers().add(new Passenger(pDetails,passengerId,noOfTickets,price));
                flight.setAvailableTickets(flight.getAvailableTickets() - noOfTickets);
                flight.setCurrentPrice(flight.getCurrentPrice() - 200 * noOfTickets);
            }


        }catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }



        return flightMap;
    }


}


