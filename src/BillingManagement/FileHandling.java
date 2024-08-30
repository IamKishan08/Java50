package BillingManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {
    private static final String FILE_PATH = "stores.txt";

    public void storeDetails(Products products){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,true))) {

            writer.write(products.toString1());
            writer.newLine();

        }catch (IOException e){
            System.out.println("Error");
        }
    }

    public List<Products> getProducts(){
       try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
           String line ;
           List<Products> answer= new ArrayList<>();
           while ((line= reader.readLine()) != null){
               String[] ma = line.split(",");
               int id = Integer.parseInt(ma[0]);
               String name = ma[1];
               double price =Double.parseDouble(ma[2]);
               int stock = Integer.parseInt(ma[3]);
               Products products = new Products(id,name,price,stock);
               answer.add(products);
           }
           return answer;
       }catch (IOException e){
           System.out.println("Error");
       }
       return null;
    }

}
