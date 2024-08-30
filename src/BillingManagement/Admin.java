package BillingManagement;

import java.util.Scanner;

public class Admin {

    private String adminId ;
    private int password ;

    Admin(String adminId, int password){
        this.adminId = adminId;
        this.password = password;
    }


    public boolean Adminlogin(String adminI,int password1){
        if(adminId.equals(adminI) && password == password1){
                return true;
        }
        return false;
    }
    static Store store = new Store();
    public  void updateStock(Scanner scanner){
        System.out.println("Updating Stock ");
        System.out.println("Enter Product Id: ");
        int productId = scanner.nextInt();
        System.out.println("Enter Product Name:");
        String productName = scanner.next();
        System.out.println("Enter Product Price: ");
        double productPrice = scanner.nextDouble();
        System.out.println("Number of Items / Quantity: ");
        int stockItems = scanner.nextInt();

        Products products = new Products(productId,productName,productPrice,stockItems);


       // System.out.println(products.getProductId());
        store.addProducts(products);

        System.out.println("Product Added");
    }


}
