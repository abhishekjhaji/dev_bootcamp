package models;


import service.NotificationService;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */
public class Customer {

    private int id;
    private String emailAddress;
    private Cart cart;

    public Customer(int id, String emailAddress) {
        this.id = id;
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void addCart(Cart cart) {
        this.cart = cart;
    }

    public boolean checkout(NotificationService notifier) throws Exception {

        if(this.cart.isEmpty()) {
            throw new Exception("Cart cannot be empty on checkout.");
        }
        Order order = new Order(this);
        order.addObserver(notifier);
        return order.generate();
    }

    public ProductList getProductsFromCart() {
        return cart.getProducts();
    }

    public boolean hasEmptyCart() {
        return cart.isEmpty();
    }
}
