package com.readowo.api.ReadOwo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.readowo.api.publishing.Models.Book;
import com.readowo.api.publishing.Models.Chapters;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    private String Name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userProfile")
    private Set<Book> books = new HashSet<>() ;
}
