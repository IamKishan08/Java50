package BillingManagement;

public class Products {
    private int productId;
    private  String productName;
    private double productPrice;
    private int quantity;
    private int stock;

    public Products(int productId, String productName, double productPrice, int stock){
        this.productId= productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock1) {
        this.stock = stock1;
    }

    public String toString1(){
        return productId + "," + productName + "," + productPrice + "," + stock;
    }


}
