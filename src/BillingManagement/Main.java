package BillingManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        Admin admin = new Admin("admin",12345);
        boolean loop = true;
        while (loop){
            System.out.println("Welcome to Super Market");
            System.out.println("1.Customer 2.Admin 3.Exit");
            System.out.println("Login as: ");
            int user = sc.nextInt();
            switch (user){
                case 1:{
                    Cart.Customer(sc);
                    break;
                }
                case 2:{
                    System.out.println("Enter admin User Name : ");
                    String name = sc.next();
                    System.out.println("Enter Admin Password : ");
                    int password = sc.nextInt();
                    boolean adminLogin = admin.Adminlogin(name,password);
                   // System.out.println(adminLogin);
                    if(!adminLogin){
                        System.out.println("Incorrect Credential");
                        break;
                    }
                    while (adminLogin) {
                        System.out.println("Welcome to Admin DashBoard");
                        System.out.println("\n 1.Update Stock 2.View Available Stock 3.View Sales 4.logout");
                        int choice = sc.nextInt();
                        switch (choice) {
                            case 1: {
                                admin.updateStock(sc);
                                break;
                            }
                            case 2: {
                                store.getStockDetails();
                                break;
                            }
                            case 3: {

                            }
                            case 4: {
                                System.out.println("Logging out...");
                                adminLogin = false;
                            }
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.println("Exiting System");
                    loop = false;
                    break;
                }
                default:{
                    System.out.println("Incorrect Choice");
                }
            }
        }

    }
}