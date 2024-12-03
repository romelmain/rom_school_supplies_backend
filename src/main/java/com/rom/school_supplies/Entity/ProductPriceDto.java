package com.rom.school_supplies.Entity;

import java.util.Date;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductPriceDto {

    private Integer id;

    private Date fecha;

    private double precio;

    private Boolean status;

    private Product product;

}
