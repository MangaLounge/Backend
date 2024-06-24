package com.readowo.api.publishing.controllers;


import com.readowo.api.publishing.Dtos.*;
import com.readowo.api.publishing.Models.Chapters;
import com.readowo.api.publishing.Models.Genre;
import com.readowo.api.publishing.Services.Communication.ChapterResponse;
import com.readowo.api.publishing.Services.Communication.GenreResponse;
import com.readowo.api.publishing.Services.IServices.IGenreService;
import com.readowo.api.publishing.Services.IServices.ISagaService;
import com.readowo.api.publishing.Services.ServicesImpl.GenreServiceImpl;
import com.readowo.api.publishing.mapping.GenreMapper;
import com.readowo.api.publishing.mapping.SagaMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/genre", produces = "application/json")
public class GenreController {
    private final IGenreService genreService;
    private final GenreMapper mapper;

    public GenreController(IGenreService genreService, GenreMapper mapper) {
        this.genreService = genreService;
        this.mapper = mapper;
    }
    @GetMapping
    public List<GenreDtos> getAllGenres() {
        return mapper.modelList(genreService.listGenres());
    }


    @GetMapping("{genreId}")
    public GenreDtos getOneGenre(@PathVariable Long genreId) {
        return mapper.toResource(genreService.findGenreById(genreId));
    }

    @PostMapping
    public ResponseEntity<GenreDtos> saveGenre(@RequestBody SaveGenreDtos saveGenreDtos) {
        return new ResponseEntity<>(mapper.toResource(genreService.saveGenre(mapper.toModel(saveGenreDtos))), HttpStatus.CREATED);
    }

    @PutMapping("{genreId}")
    public GenreDtos updateGenre(@PathVariable Long genreId, @RequestBody SaveGenreDtos saveGenreDtos) {
        return mapper.toResource(genreService.updateGenre(genreId, mapper.toModel(saveGenreDtos)));
    }
    @DeleteMapping("{genreId}")
    public ResponseEntity<?> deleteGenre(@PathVariable Long genreId) {
        return genreService.deleteGenre(genreId);
    }
}
