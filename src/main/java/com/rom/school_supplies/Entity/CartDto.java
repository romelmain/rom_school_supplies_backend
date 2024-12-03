package com.rom.school_supplies.Entity;

import java.time.LocalDateTime;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartDto {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    private StatusDto statusCart;

    private UserDto user;

    List<ProductPriceDto> productPrice;

}
