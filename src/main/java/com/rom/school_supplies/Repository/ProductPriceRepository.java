package com.rom.school_supplies.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rom.school_supplies.Entity.ProductPrice;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {

    @Query(value = "select a.id, a.nombre, a.descripcion, a.imagen, b.precio,b.fecha,b.id_producto, b.status "
            + "from productos a "
            + "inner join producto_precio b on (a.id = b.id_producto) "
            + "where b.status = 1", nativeQuery = true)
    List<ProductPrice> getProductsPrice();

    @Query(value = "select a.id, a.nombre, a.descripcion, a.imagen, b.precio,b.fecha,b.id_producto, b.status "
            + "from productos a "
            + "inner join producto_precio b on (a.id = b.id_producto) "
            + "where b.status = 1 and a.id = :idProduct", nativeQuery = true)
    ProductPrice getProductsPriceById(@Param("idProduct") Integer idProduct);

}
