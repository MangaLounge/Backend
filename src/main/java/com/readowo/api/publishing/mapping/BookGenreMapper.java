package com.readowo.api.publishing.mapping;

import com.readowo.api.mapping.EnhancedModelMapper;
import com.readowo.api.publishing.Dtos.BookGenreDtos;
import com.readowo.api.publishing.Dtos.GenreDtos;
import com.readowo.api.publishing.Dtos.SaveBookGenreDtos;
import com.readowo.api.publishing.Dtos.SaveGenreDtos;
import com.readowo.api.publishing.Models.BookGenre;
import com.readowo.api.publishing.Models.Genre;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class BookGenreMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public BookGenreDtos toResource(BookGenre model){
        return mapper.map(model, BookGenreDtos.class);
    }
    public BookGenre toModel(SaveBookGenreDtos resource){
        return mapper.map(resource, BookGenre.class);
    }
    public List<BookGenreDtos> modelList(List<BookGenre> bookGenreList) {
        return mapper.mapList(bookGenreList, BookGenreDtos.class);
    }
}
