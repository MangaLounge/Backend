package com.readowo.api.publishing.Services.IServices;

import com.readowo.api.publishing.Dtos.SaveGenreDtos;
import com.readowo.api.publishing.Models.Genre;
import com.readowo.api.publishing.Services.Communication.GenreResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IGenreService {

    List<Genre> listGenres();
    Genre findGenreById(Long genreId);
    Genre saveGenre(Genre genre);
    Genre updateGenre(Long id, Genre genre);
    ResponseEntity<?> deleteGenre(Long genreId);
}
