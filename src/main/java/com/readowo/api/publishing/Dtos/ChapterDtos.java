package com.readowo.api.publishing.Dtos;


import com.readowo.api.publishing.Models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDtos {

    private Long Id ;

    private String Title;
    private String Synopsis;

    private Book book;
}
