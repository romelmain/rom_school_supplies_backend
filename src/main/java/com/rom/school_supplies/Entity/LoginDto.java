package com.rom.school_supplies.Entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginDto {

    private Integer cartId;

    private UserDto user;

}
