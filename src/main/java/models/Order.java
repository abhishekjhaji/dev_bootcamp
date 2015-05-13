package models;
import java.util.Observable;
import java.util.HashMap;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */
public class Order extends Observable{
    private Customer customer;
    private ProductList products;
    private Double orderValue;

    public Order(Customer customer) throws Exception {
        if(customer.hasEmptyCart()){
            throw new Exception("No order for empty cart of user");
        }
        this.customer = customer;
    }

    public boolean generate() {
        this.products = customer.getProductsFromCart();
        if(products == null){
            return false;
        }
        this.orderValue = products.totalValue();
        setChanged();
        this.notifyObservers(this);
        return true;
    }


}
