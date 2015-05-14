package hello.models;


import javax.persistence.*;

@Table(name="cart")
@Entity
public class Cart {

    @Id
    private int id;

    @OneToOne
    @JoinColumn(name="lineItemId", referencedColumnName = "lineItemId")
    private CartLineItem cartLineItem;

    public Cart() {
        this.products = new ProductList();
    }

    @Transient
    private ProductList products;

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
