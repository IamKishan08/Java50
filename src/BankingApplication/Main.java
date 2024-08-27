package BankingApplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandling.loadFromFile();

        boolean run = true;

        while (run) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter your Name to Create Account: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter account type (saving, current, credit): ");
                    String accountType = scanner.nextLine();
                    Account.createAccount(name,accountType);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    long accountNumber = scanner.nextLong();
                    Customer customer = Account.login(accountNumber);
                    if (customer != null) {
                        boolean loggedIn = true;
                        while (loggedIn) {
                            System.out.println("\nAccount Menu:");
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. View Balance");
                            System.out.println("4. Logout");
                            System.out.print("Enter your choice: ");

                            int accountChoice = scanner.nextInt();
                            scanner.nextLine(); // consume newline

                            switch (accountChoice) {
                                case 1:
                                    System.out.print("Enter amount to deposit: ");
                                    double depositAmount = scanner.nextDouble();
                                    scanner.nextLine(); // consume newline
                                    customer.deposit(depositAmount);
                                    System.out.println("Deposited " + depositAmount);
                                    break;

                                case 2:
                                    System.out.print("Enter amount to withdraw: ");
                                    double withdrawAmount = scanner.nextDouble();
                                    scanner.nextLine(); // consume newline
                                    if (customer.withdraw(withdrawAmount)) {
                                        System.out.println("Withdrawn " + withdrawAmount);
                                    } else {
                                        System.out.println("Insufficient balance");
                                    }
                                    break;

                                case 3:
                                    System.out.println("Current balance: " + customer.getBalance());
                                    break;

                                case 4:
                                    loggedIn = false;
                                    System.out.println("Logged out successfully");
                                    break;

                                default:
                                    System.out.println("Invalid choice");
                            }
                        }
                    } else {
                        System.out.println("Invalid account number");
                    }
                    break;

                case 3:
                    System.out.println("Exiting system");
                    scanner.close();
                    run = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        FileHandling.saveAllToFiles();

    }
}
 // CUST7284   825267