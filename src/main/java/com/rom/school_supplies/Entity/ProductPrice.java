package com.rom.school_supplies.Entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "producto_precio")
public class ProductPrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productprice_sequence")
    @SequenceGenerator(name = "productprice_sequence", sequenceName = "productprice_sequence", allocationSize = 1)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    private double precio;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Product product;

}