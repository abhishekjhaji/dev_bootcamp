package hello.models;


import hello.service.NotificationService;

import javax.persistence.*;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */

@Table(name="customer")
@Entity
public class Customer extends BaseModel<Customer> {

    public final static BaseModel.Repo<Customer> REPO = new BaseModel.Repo<Customer>(Customer.class);

    @Id
    private int id;
    private String emailAddress;

    @OneToOne
    @JoinColumn(name="cartId", referencedColumnName = "id")
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

//    public void save(Customer customer) {
//        //CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        saveIt();
//    }
}
