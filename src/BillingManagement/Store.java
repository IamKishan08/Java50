package BillingManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    Map<Integer,Products> productsMap = new HashMap<>() ;

    private final List<Products> products1 = new ArrayList<>();

    FileHandling file = new FileHandling();
    public void addProducts(Products products){
        file.storeDetails(products);
    }

    public void getStockDetails(){

        List<Products> ans = file.getProducts();
        for (Products product: ans) {
            System.out.println("Product ID: " + product.getProductId() + " Product Name: " + product.getProductName() + " Product Price " + product.getProductPrice() + " Product Stock " + product.getStock());
        }
    }

}
