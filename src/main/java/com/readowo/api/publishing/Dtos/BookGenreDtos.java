package com.readowo.api.publishing.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.readowo.api.publishing.Models.Book;
import com.readowo.api.publishing.Models.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookGenreDtos {


    private Long Id ;

    private Book book ;

    private Genre genre ;
}
