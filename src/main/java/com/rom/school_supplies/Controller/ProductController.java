package com.rom.school_supplies.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rom.school_supplies.Entity.Message;
import com.rom.school_supplies.Entity.Product;
import com.rom.school_supplies.Entity.ProductPrice;
import com.rom.school_supplies.Service.MyConfigService;
import com.rom.school_supplies.Service.ProductPriceService;
import com.rom.school_supplies.Service.ProductService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductPriceService productPriceService;

    @Autowired
    private MyConfigService myConfigService;

    @CrossOrigin(origins = "http://localhost:5500")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            List<Product> products = productService.getAllProduct();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:5500")
    @GetMapping("/price")
    public ResponseEntity<?> getProductPrice() {
        try {
            List<ProductPrice> listProductPrice = productPriceService.getProductsPrice();
            return new ResponseEntity<>(listProductPrice, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:5500")
    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        try {
            ProductPrice productPrice = null;
            productPrice = productPriceService.getProductsPriceById(id);
            ResponseEntity responseEntity;
            if (productPrice != null) {
                responseEntity = new ResponseEntity<>(productPrice, HttpStatus.OK);
            } else {
                Message message = new Message();
                message.setMessage(myConfigService.getProductMessageNotFound());
                responseEntity = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
            }

            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Product dto) {
        try {
            // TODO Implement Your Logic To Save Data And Return Result Through
            // ResponseEntity
            return new ResponseEntity<>("Create Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Product dto) {
        try {
            // TODO Implement Your Logic To Update Data And Return Result Through
            // ResponseEntity
            return new ResponseEntity<>("Update Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            // TODO Implement Your Logic To Destroy Data And Return Result Through
            // ResponseEntity
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
