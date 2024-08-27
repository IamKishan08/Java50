package BankingApplication;

import java.io.*;

public class FileHandling {

    private static final String FILE_PATH = "customers.txt";

    public static void saveToFile(Customer customer){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,true))) {
            writer.write(customer.toString());
            writer.newLine();
        }catch (IOException e){
            System.out.println("Error Saving File" + e.getMessage());
        }
    }

    public static void loadFromFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while((line = reader.readLine()) != null){
                Customer customer = Customer.fromFileString(line);
                Account.customerMap.put(customer.getAccountNumber(), customer);
            }
        }catch (IOException e){
            System.out.println("Error loading File" + e.getMessage());
        }
    }

    public static void saveAllToFiles(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
            for(Customer customer : Account.customerMap.values()){
                writer.write(customer.toString());
                writer.newLine();
            }

        }catch (IOException e){
            System.out.println("Error " + e.getMessage());
        }
    }
}
