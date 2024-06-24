package com.readowo.api.publishing.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SagaDtos {

    private Long id;
    private String Title;

    private String Synopsis;
}
