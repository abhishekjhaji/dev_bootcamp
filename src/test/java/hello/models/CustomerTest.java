package hello.models;

import hello.Application;
import hello.factories.EmailNotificationStrategyFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import hello.repositaries.CustomerRepository;
import hello.service.NotificationService;
import hello.strategies.EmailNotificationStrategy;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */


@SpringApplicationConfiguration(classes = Application.class)

public class CustomerTest {

    @Test
    @Ignore
    public void testCreateCustomerWithValidData(){
        Customer customer = new Customer(1,"manish@katoch.com");
        customer.saveIt();
        //Customer savedCustomer = Customer.getById(1);
        //Assert.assertEquals(customer,savedCustomer);
    }

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
