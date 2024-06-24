package com.readowo.api.publishing.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@With
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    private String Name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
    private Set<BookGenre> bookGenres = new HashSet<>() ;
}
