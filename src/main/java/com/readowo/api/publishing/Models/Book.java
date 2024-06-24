package com.readowo.api.publishing.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.readowo.api.ReadOwo.Models.UserProfile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;
    private String Title ;
    private String Synopsis ;
    private String PublishedAt ;
    private String ThumbnailUrl ;

    @ManyToOne
    @JoinColumn(name = "user_profile_id", nullable = false)
    @JsonIgnore
    private UserProfile userProfile;

    private String language;
    private String saga;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Set<Chapters> chapters = new HashSet<>() ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Set<BookGenre> bookGenres = new HashSet<>() ;
}
