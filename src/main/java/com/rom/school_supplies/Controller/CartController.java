package com.rom.school_supplies.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rom.school_supplies.Entity.Cart;
import com.rom.school_supplies.Entity.CartDto;
import com.rom.school_supplies.Entity.ProductCart;
import com.rom.school_supplies.Entity.ProductPrice;
import com.rom.school_supplies.Entity.ProductPriceDto;
import com.rom.school_supplies.Entity.StatusCart;
import com.rom.school_supplies.Entity.User;
import com.rom.school_supplies.Service.CartService;
import com.rom.school_supplies.Service.ProductCartService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final ProductCartService productCartService;

    /*
     * @GetMapping()
     * public ResponseEntity<?> findAll() {
     * try {
     * // TODO Implement Your Logic To Get Data From Service Layer Or Directly From
     * // Repository Layer
     * return new ResponseEntity<>("GetAll Results", HttpStatus.OK);
     * } catch (Exception e) {
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     * 
     * @GetMapping("/{id}")
     * public ResponseEntity<?> find(@PathVariable Integer id) {
     * try {
     * // TODO Implement Your Logic To Get Data From Service Layer Or Directly From
     * // Repository Layer
     * return new ResponseEntity<>("GetOne Result", HttpStatus.OK);
     * } catch (Exception e) {
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     * 
     */
    @CrossOrigin(origins = "http://localhost:5500")
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CartDto cartdto) {
        try {
            // 1.- Status
            StatusCart statusCart = new StatusCart();
            statusCart.setId(cartdto.getStatusCart().getId());
            // 2.- User
            User user = new User();
            user.setId(cartdto.getUser().getId());
            // 3.- Cart
            Cart cart = new Cart();
            cart.setFecha(cartdto.getDate());
            cart.setStatusCart(statusCart);
            cart.setUser(user);
            Cart newCart = cartService.createCart(cart);
            // 4.- ProductCart
            ProductPriceDto productPriceDto = cartdto.getProductPrice();
            ProductCart productCart = new ProductCart();
            productCart.setCart(newCart);
            ProductPrice productPrice = new ProductPrice();
            productPrice.setId(productPriceDto.getId());
            productCart.setProductPrice(productPrice);
            productCartService.createProductCart(productCart);

            return new ResponseEntity<>(newCart, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
     * @PutMapping()
     * public ResponseEntity<?> update(@RequestBody Dto dto) {
     * try {
     * // TODO Implement Your Logic To Update Data And Return Result Through
     * // ResponseEntity
     * return new ResponseEntity<>("Update Result", HttpStatus.OK);
     * } catch (Exception e) {
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     * 
     * @DeleteMapping("/{id}")
     * public ResponseEntity<?> delete(@PathVariable Integer id) {
     * try {
     * // TODO Implement Your Logic To Destroy Data And Return Result Through
     * // ResponseEntity
     * return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
     * } catch (Exception e) {
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */
}
