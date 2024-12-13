package com.rom.school_supplies.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rom.school_supplies.Entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(value = "select id,status,fecha,id_user from carrito where status = 1 and id_user = :userId", nativeQuery = true)
    Cart validateCart(@Param("userId") Integer userId);

}
