package service;


import models.Cart;
import models.Product;

public class CartService {
    public Cart addToCart(Product product, Cart cart) {
        if(cart == null){
            cart = new Cart();
        }
        cart.addProduct(product);
        return cart;
    }
}
