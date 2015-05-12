package models;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by abhishekkumarjha on 12/05/15.
 */
public class CartTest {


    @Test
    public void testIfQuantityIncreaseOnAddingSameProduct() throws Exception {
        Cart cart = new Cart();
        Product product = new Product("Sample");
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals(2,cart.getProducts().getQuantity(product));
    }
    @Test
    public void testIfQuantityIsOneOnAddingNewProduct() throws Exception {
        Cart cart = new Cart();
        Product product = new Product("Sample");
        cart.addProduct(product);
        assertEquals(1, cart.getProducts().getQuantity(product));
    }

    @Test
    public void testIfCartDisplaysProductList(){
        ProductList products = new ProductList();
        products.add(new Product("Sample"));
        Cart cart = new Cart(products);
        assertEquals(products, cart.getProducts());
    }
}