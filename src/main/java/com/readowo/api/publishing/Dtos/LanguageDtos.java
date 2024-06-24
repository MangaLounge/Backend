package com.readowo.api.publishing.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDtos {

    private Long id;
    private String Name;

    private String Abbreviation;
}
