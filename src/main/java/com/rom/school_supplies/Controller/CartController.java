package com.rom.school_supplies.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rom.school_supplies.Entity.Cart;
import com.rom.school_supplies.Entity.CartDto;
import com.rom.school_supplies.Entity.ProductCart;
import com.rom.school_supplies.Entity.ProductCartDto;
import com.rom.school_supplies.Entity.ProductDto;
import com.rom.school_supplies.Entity.ProductPrice;
import com.rom.school_supplies.Entity.ProductPriceDto;
import com.rom.school_supplies.Entity.StatusCart;
import com.rom.school_supplies.Entity.StatusDto;
import com.rom.school_supplies.Entity.User;
import com.rom.school_supplies.Entity.UserDto;
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
    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        try {
            // TODO Implement Your Logic To Get Data From Service Layer Or Directly From
            // Repository Layer
            List<ProductCart> listProductCart = productCartService.getActiveCart(id);
            CartDto cartDto = new CartDto();
            List<ProductPriceDto> listProductPriceDto = new ArrayList<ProductPriceDto>();

            StatusDto statusDto = new StatusDto();
            UserDto userDto = new UserDto();

            statusDto.setId(listProductCart.get(0).getCart().getStatusCart().getId());
            statusDto.setStatus(listProductCart.get(0).getCart().getStatusCart().getStatus());
            userDto.setId(listProductCart.get(0).getCart().getUser().getId());
            userDto.setUsername(listProductCart.get(0).getCart().getUser().getUsername());

            cartDto.setId(listProductCart.get(0).getCart().getId());
            cartDto.setDate(listProductCart.get(0).getCart().getFecha());
            cartDto.setStatusCart(statusDto);
            cartDto.setUser(userDto);

            for (ProductCart productCart : listProductCart) {
                ProductDto productDto = new ProductDto();

                ProductPriceDto productPriceDto = new ProductPriceDto();
                productPriceDto.setId(productCart.getProductPrice().getId());
                productPriceDto.setFecha(productCart.getProductPrice().getFecha());
                productPriceDto.setPrecio(productCart.getProductPrice().getPrecio());
                productPriceDto.setStatus(productCart.getProductPrice().getStatus());
                productDto.setId(productCart.getProductPrice().getProduct().getId());
                productDto.setDescripcion(productCart.getProductPrice().getProduct().getDescripcion());
                productDto.setImagen(productCart.getProductPrice().getProduct().getImagen());
                productDto.setNombre(productCart.getProductPrice().getProduct().getNombre());
                productPriceDto.setProduct(productDto);
                productPriceDto.setCantidad(productCart.getCantidad());

                listProductPriceDto.add(productPriceDto);
            }

            cartDto.setListProductPrice(listProductPriceDto);

            return new ResponseEntity<>(cartDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:5500")
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CartDto cartdto) {
        Cart newCart = null;
        try {

            // 1.- Status
            StatusCart statusCart = new StatusCart();
            statusCart.setId(cartdto.getStatusCart().getId());
            // 2.- User
            User user = new User();
            user.setId(cartdto.getUser().getId());
            // 3.- Cart
            Optional<Cart> opCart = cartService.getCartByUserId(cartdto.getUser().getId());
            if (opCart.isPresent()) {
                newCart = opCart.get();
                System.out.println("OBTIENE EL CARRITO");
                System.out.println(newCart.getFecha());
            } else {
                System.out.println("No hay id cart");
                System.out.println("CREANDO CARRITO");
                Cart cart = new Cart();
                cart.setFecha(cartdto.getDate());
                cart.setStatusCart(statusCart);
                cart.setUser(user);
                newCart = cartService.createCart(cart);
            }

            // 4.- ProductCart
            Integer quantity = 1;
            ProductCart productCart = new ProductCart();
            productCart = productCartService.getProductCartByIdProductPrice(newCart.getId(), cartdto.getUser().getId(),
                    cartdto.getProductPrice().getId());

            if (productCart == null) {
                ProductPriceDto productPriceDto = cartdto.getProductPrice();
                productCart = new ProductCart();
                productCart.setCart(newCart);
                productCart.setCantidad(quantity);
                ProductPrice productPrice = new ProductPrice();
                productPrice.setId(productPriceDto.getId());
                productCart.setProductPrice(productPrice);
            } else {
                quantity = productCart.getCantidad() + 1;
                productCart.setCantidad(quantity);
            }
            productCartService.createProductCart(productCart);

            return new ResponseEntity<>(newCart, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("hjlkhljkh  " + e.getMessage());
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
