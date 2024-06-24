package com.readowo.api.ReadOwo.dtos;

import com.readowo.api.ReadOwo.Models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserProfileDto {
    private String Name;
    private Long userId;
}
