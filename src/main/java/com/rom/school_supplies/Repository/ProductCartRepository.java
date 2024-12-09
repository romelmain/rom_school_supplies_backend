package com.rom.school_supplies.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rom.school_supplies.Entity.ProductCart;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {

    @Query(value = "select a.id,a.id_producto_precio,a.id_carrito from producto_carrito a "
            + "inner join carrito b on (a.id_carrito = b.id) "
            + "inner join producto_precio c on (a.id_producto_precio = c.id) "
            + "inner join productos d on (c.id_producto = d.id) "
            + "where b.status = 1 and a.id_carrito = :idCart", nativeQuery = true)
    List<ProductCart> getActiveCart(@Param("idCart") Integer idCart);
}
