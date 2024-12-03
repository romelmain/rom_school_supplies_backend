package com.rom.school_supplies.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.io.Serializable;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "producto_carrito")
public class ProductCart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productcart_sequence")
    @SequenceGenerator(name = "productcart_sequence", sequenceName = "productcart_sequence", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "id_producto_precio")
    private ProductPrice productPrice;

}