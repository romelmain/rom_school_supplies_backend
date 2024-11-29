package com.rom.school_supplies.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rom.school_supplies.Entity.Product;
import com.rom.school_supplies.Repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

}
