package models;

import factories.EmailNotificationStrategyFactory;
import org.junit.Assert;
import org.junit.Test;

import repositaries.CustomerRepository;
import service.NotificationService;
import strategies.EmailNotificationStrategy;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */
public class CustomerTest {

    @Test(expected = Exception.class)
    public void testCustomerCannotCheckoutEmptyCart() throws Exception{
        Customer customer = CustomerRepository.findById(2);
        Cart emptyCart = new Cart();
        customer.addCart(emptyCart);
        EmailNotificationStrategy strategy = EmailNotificationStrategyFactory.getStrategy();
        NotificationService notifier = new NotificationService(strategy);
        customer.checkout(notifier);
    }

    @Test
    public void testCustomerCanCheckoutNonEmptyCart(){
        Customer customer = CustomerRepository.findById(2);
        ProductList productList = new ProductList();
        productList.add(new Product("Product A",24.03));
        productList.add(new Product("Product B", 46.90));
        Cart cart = new Cart(productList);
        customer.addCart(cart);
        EmailNotificationStrategy strategy = EmailNotificationStrategyFactory.getStrategy();
        NotificationService notifier = new NotificationService(strategy);
        try {
            Assert.assertTrue(customer.checkout(notifier));
        }
        catch(Exception exception){
            Assert.fail();
        }
    }

    @Test
    public void testOnCheckoutNotificationEmailIsSent(){
        Customer customer = CustomerRepository.findById(2);
        ProductList productList = new ProductList();
        productList.add(new Product("Product A",24.03));
        productList.add(new Product("Product B", 46.90));
        Cart cart = new Cart(productList);
        customer.addCart(cart);
        EmailNotificationStrategy strategy = EmailNotificationStrategyFactory.getStrategy();
        NotificationService notifier = new NotificationService(strategy);
        try {
            customer.checkout(notifier);
            Assert.assertTrue(notifier.isNotificationSent());
        }
        catch(Exception exception){
            Assert.fail();
        }
    }
}
