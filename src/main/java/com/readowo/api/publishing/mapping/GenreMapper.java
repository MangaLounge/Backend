package com.readowo.api.publishing.mapping;

import com.readowo.api.mapping.EnhancedModelMapper;
import com.readowo.api.publishing.Dtos.GenreDtos;
import com.readowo.api.publishing.Dtos.LanguageDtos;
import com.readowo.api.publishing.Dtos.SaveGenreDtos;
import com.readowo.api.publishing.Dtos.SaveLanguageDtos;
import com.readowo.api.publishing.Models.Genre;
import com.readowo.api.publishing.Models.Language;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class GenreMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public GenreDtos toResource(Genre model){
        return mapper.map(model, GenreDtos.class);
    }
    public Genre toModel(SaveGenreDtos resource){
        return mapper.map(resource, Genre.class);
    }
    public List<GenreDtos> modelList(List<Genre> genreList) {
        return mapper.mapList(genreList, GenreDtos.class);
    }
}
