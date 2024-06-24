package com.readowo.api.publishing.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookGenre")
public class BookGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @JsonIgnore
    private Book book ;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    @JsonIgnore
    private  Genre genre ;
}
