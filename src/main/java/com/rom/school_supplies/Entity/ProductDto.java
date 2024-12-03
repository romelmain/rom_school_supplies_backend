package com.rom.school_supplies.Entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {

    private Integer id;

    private String descripcion;

    private String imagen;

    private String nombre;

}
