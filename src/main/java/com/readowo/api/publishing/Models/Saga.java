package com.readowo.api.publishing.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.HashSet;
import java.util.Set;

@Entity
@With
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "saga")
public class Saga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    private String Title;
    private String Synopsis;
}
