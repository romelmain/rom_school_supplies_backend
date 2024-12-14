package com.rom.school_supplies.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    public Optional<Cart> getCartById(Integer cartId) {
        Long lCartId = Long.valueOf(cartId);
        return cartRepository.findById(lCartId);
    }

    public Optional<Cart> getCartByUserId(Integer userId) {
        Cart cart = new Cart();
        Optional<Cart> oCart;
        try {
            cart = cartRepository.validateCart(userId);
            if (cart != null) {
                oCart = Optional.of(cart);
            } else {
                oCart = Optional.empty();
            }
        } catch (Exception e) {
            oCart = Optional.empty();
        }
        return oCart;
    }

}
