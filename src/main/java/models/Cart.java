package models;

import java.util.ArrayList;

public class Cart {
    private ProductList products;


    public Cart() {
        this.products = new ProductList();
    }

    public Cart(ProductList products) {
        this.products = products;
    }


    public void addProduct(Product product) {
        this.products.add(product);
    }

    public ProductList getProducts() {
        return products;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
}
