package com.readowo.api.publishing.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Entity
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class Chapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    private String Title;
    private String Synopsis;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;


}
