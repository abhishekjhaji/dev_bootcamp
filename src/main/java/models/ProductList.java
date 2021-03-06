package models;


import java.util.HashMap;
import java.util.Set;

public class ProductList {
    HashMap<Product,Integer> products = new HashMap<Product,Integer>();

    public boolean contains(Product product) {
        return products.containsKey(product);
    }

    public void add(Product product) {
        if(products.containsKey(product)){
            products.put(product,products.get(product)+1);
        }
        else{
            products.put(product,1);
        }

    }

    public int getQuantity(Product product) {
        return products.get(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductList that = (ProductList) o;

        return products.equals(that.products);

    }

    @Override
    public int hashCode() {
        return products.hashCode();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }



    public Double totalValue() {
        double total = 0d;
        Set<Product> productSet = products.keySet();
        for(Product product: productSet){
            total += products.get(product) * product.getPrice();
        }
        return total;
    }
}
