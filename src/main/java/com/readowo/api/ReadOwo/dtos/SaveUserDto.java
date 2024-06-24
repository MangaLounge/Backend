package com.readowo.api.ReadOwo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserDto {

    private String Name;
    private String email;

    private String password;
}
