package hello.service;


import hello.models.Cart;
import hello.models.Product;

public class CartService {
    public Cart addToCart(Product product, Cart cart) {
        if(cart == null){
            cart = new Cart();
        }
        cart.addProduct(product);
        return cart;
    }
}
