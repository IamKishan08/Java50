package BankingApplication;

import java.util.HashMap;
import java.util.Map;

public class Account {

    static Map<Long,Customer> customerMap = new HashMap<>();


    public static void createAccount(String customerName, String accountType){
        Customer customer = new Customer(customerName,accountType);
        customerMap.put(customer.getAccountNumber(),customer);
        FileHandling.saveToFile(customer);
        System.out.println("Account created successFully");
        System.out.println("Customer ID: " + customer.getCustomerId());
        System.out.println("Account Number: " + customer.getAccountNumber());
        System.out.println("Account Type: " + customer.getAccountType());
    }

    static Customer login(long accountNumber){
        return customerMap.get(accountNumber);
    }


}
