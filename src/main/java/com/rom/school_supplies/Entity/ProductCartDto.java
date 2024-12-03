package com.rom.school_supplies.Entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductCartDto {

    private Integer id;

    private ProductPrice productPrice;
}
