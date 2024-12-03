package com.rom.school_supplies.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rom.school_supplies.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /*
     * @Query(value = "select a.id, a.nombre, a.descripcion, a.imagen, b.precio "
     * + "from productos a "
     * + "inner join producto_precio b on (a.id = b.id_producto) "
     * + "where b.status = 1", nativeQuery = true)
     * List<Product> getProducts();
     */
}
