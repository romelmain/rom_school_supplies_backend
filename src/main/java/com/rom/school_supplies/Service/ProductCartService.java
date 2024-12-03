package com.rom.school_supplies.Service;

import org.springframework.stereotype.Service;

import com.rom.school_supplies.Entity.ProductCart;
import com.rom.school_supplies.Repository.ProductCartRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductCartService {

    private final ProductCartRepository productCartRepository;

    public ProductCartService(ProductCartRepository productCartRepository) {
        this.productCartRepository = productCartRepository;
    }

    public ProductCart createProductCart(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }

}
