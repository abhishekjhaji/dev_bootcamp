package service;

import org.junit.Test;
import static org.junit.Assert.*;
import models.Cart;
import models.Product;



public class CartServiceTest {

    @Test
    public void testAddToCartCreatesCartIfNotPresent(){
        CartService cartService = new CartService();
        Product sampleProduct = new Product("sample",25d);
        Cart cart = cartService.addToCart(sampleProduct, null);
        assertTrue(cart.getProducts().contains(sampleProduct));
    }

    @Test
    public void testAddToCartReturnsUpdatedCartIfPresent(){
        CartService cartService = new CartService();
        Product product1 = new Product("product one",25d);
        Cart cart = cartService.addToCart(product1, null);
        Product product2 = new Product("product two",34.01);
        cart = cartService.addToCart(product2, cart);
        assertTrue(cart.getProducts().contains(product1) && cart.getProducts().contains(product2));
    }

}
