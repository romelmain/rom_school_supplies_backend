package com.rom.school_supplies.Entity;

import java.sql.Date;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private Integer id;

    private String password;

    private String username;

    private Date createAt;

    private Date updateAt;
}
