package com.readowo.api.ReadOwo.dtos;

import com.readowo.api.ReadOwo.Models.UserProfile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private Long Id ;

    private String Name;
    private String email;

    private String password;

}
