package BillingManagement;

import java.util.*;

public class Cart {

    private Products products;
    private int quantity;

    private int productId;

    private int productCost;

    static FileHandling fileHandling = new FileHandling();
    static List<Products> productsDe = fileHandling.getProducts();

    Map<Integer, Products> cart = new HashMap<>();



    public Cart(int productId, int quantity){
         this.quantity = quantity;
         this.productId = productId;
    }

    public static void Customer(Scanner sc){
        System.out.println("Welcome to Stores Customer");

        System.out.println("Enter No of Products: ");
        int noOfProducts = sc.nextInt();

        List<Cart> cart = new ArrayList<>();

        for (int i = 1; i <=noOfProducts ; i++) {
            System.out.println("Enter Product Id :");
            int proId = sc.nextInt();
            boolean check  = getProductId(proId);
            if(check == false){
                System.out.println("Invalid Product Id");
                break;
            }
            System.out.println("Quantity :");
            int quantity = sc.nextInt();
            Cart cart1 = new Cart(proId,quantity);
            cart.add(cart1);
            System.out.println("Added to Cart");
        }
        double TotalCartValue = priceCalculations(cart);
        System.out.println("Total Cart Price :" +TotalCartValue);
    }
    public static double priceCalculations(List<Cart> cart){
        double TotalCost = 0;
        for (Cart carts : cart){
            int proId = carts.productId;
            int quantity = carts.quantity;
            double proPrice = getProdutPrice(proId);
            double TotalCosts = proPrice * quantity;
            TotalCost += TotalCosts;
            setQuantiy1(proId,quantity);
        }

     return TotalCost;
    }
    public static void setQuantiy1(int proId, int stock){
        for (Products pro: productsDe) {
            if (pro.getProductId() == proId){
                 pro.setStock(pro.getStock()-stock);
            }
        }
    }

    public static boolean getProductId(int id){
        for (Products pro: productsDe) {
            if(pro.getProductId() == id){
                return true;
            }
        }
        return false;
    }



    public static double getProdutPrice(int id){
        for (Products pro: productsDe) {
            if(pro.getProductId() == id){
                return pro.getProductPrice();
            }
        }
        return 0;
    }







}
