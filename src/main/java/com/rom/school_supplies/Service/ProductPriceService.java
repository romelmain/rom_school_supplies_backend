package com.rom.school_supplies.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rom.school_supplies.Entity.ProductPrice;
import com.rom.school_supplies.Repository.ProductPriceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    public ProductPriceService(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }

    public List<ProductPrice> getProductsPrice() {
        return productPriceRepository.getProductsPrice();
    }

}
