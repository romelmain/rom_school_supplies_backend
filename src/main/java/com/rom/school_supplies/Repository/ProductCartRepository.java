package com.rom.school_supplies.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rom.school_supplies.Entity.ProductCart;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {

}
