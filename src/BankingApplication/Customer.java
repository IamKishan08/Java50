package BankingApplication;

import java.util.Random;

public class Customer {
    private String customerId;
    private long accountNumber;
    private String customerName;
    private String accountType;
    private double  balance;

    Customer(String customerName,String accountType){
        this.customerId = generateCustomerID();
        this.accountNumber = generateAccountNumber();
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = 500.00;
    }

    private long generateAccountNumber() {
        return new Random().nextInt(1000000);
    }


    private String generateCustomerID() {
        return "CUST" + new Random().nextInt(10000);
    }

    public String getCustomerId() {
        return customerId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }

    public String toString(){
        return accountNumber + "," + customerId + "," + customerName + "," + accountType + "," + balance;
    }

    public static Customer fromFileString(String line){
        String[] parts = line.split(",");
        Customer customer = new Customer(parts[2],parts[3]);
        customer.accountNumber = Long.parseLong(parts[0]);
        customer.customerId = parts[1];
        customer.balance = Double.parseDouble(parts[4]);
        return customer;
    }

}
