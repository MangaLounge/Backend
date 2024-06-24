package com.readowo.api.ReadOwo.dtos;

import com.readowo.api.ReadOwo.Models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDto {
    private Long Id ;
    private String Name;
    private User user;
}
