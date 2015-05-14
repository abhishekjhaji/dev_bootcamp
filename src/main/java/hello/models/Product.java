package hello.models;


public class Product {
    private String name;
    private Double price;

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return name.equals(product.name) && price.equals(product.price);

    }

    @Override
    public int hashCode() {
        return name.hashCode() & price.hashCode();
    }

    public Double getPrice() {
        return price;
    }
}
