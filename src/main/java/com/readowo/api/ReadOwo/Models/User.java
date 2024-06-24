package com.readowo.api.ReadOwo.Models;

import com.readowo.api.publishing.Models.Chapters;
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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    private String Name;
    private String email;

    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<UserProfile> userProfiles = new HashSet<>();
}
