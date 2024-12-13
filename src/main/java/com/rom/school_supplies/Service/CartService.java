package com.rom.school_supplies.Service;

import org.springframework.stereotype.Service;

import com.rom.school_supplies.Entity.Cart;
import com.rom.school_supplies.Repository.CartRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Integer validateCart(Integer userId) {
        Integer cartId = 0;
        Cart cart = new Cart();
        cart = cartRepository.validateCart(userId);
        if (cart != null && cart.getId() > 0) {
            cartId = cart.getId();
        }
        return cartId;
    }

}
