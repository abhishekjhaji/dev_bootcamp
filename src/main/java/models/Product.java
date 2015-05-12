package models;


public class Product {
    String name;
    public Product(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return name.equals(product.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
