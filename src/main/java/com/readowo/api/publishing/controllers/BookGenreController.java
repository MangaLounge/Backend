package com.readowo.api.publishing.controllers;


import com.readowo.api.publishing.Dtos.*;
import com.readowo.api.publishing.Models.BookGenre;
import com.readowo.api.publishing.Services.Communication.BookGenreResponse;
import com.readowo.api.publishing.Services.IServices.IBookGenreService;
import com.readowo.api.publishing.Services.ServicesImpl.BookGenreServiceImpl;
import com.readowo.api.publishing.mapping.BookGenreMapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/bookgenre", produces = "application/json")
public class BookGenreController {

    private final BookGenreMapper mapper;
    private final IBookGenreService bookGenreService;

    public BookGenreController(BookGenreServiceImpl bookGenreService , BookGenreMapper mapper) {
        this.bookGenreService = bookGenreService;
        this.mapper=mapper;
    }

    @GetMapping
    public List<BookGenreDtos> getAllBookGenres() {
        return mapper.modelList(bookGenreService.list());
    }

    @GetMapping("{bookgenreId}")
    public BookGenreDtos getOneBookGenre(@PathVariable Long bookgenreId) {
        return mapper.toResource(bookGenreService.findById(bookgenreId));
    }

    @PostMapping
    public ResponseEntity<BookGenreDtos> saveBookGenre(@RequestBody SaveBookGenreDtos saveBookGenreDtos) {
        return new ResponseEntity<>(mapper.toResource(bookGenreService.saveBookGenre(mapper.toModel(saveBookGenreDtos))), HttpStatus.CREATED);
    }

    @PutMapping("{bookgenreId}")
    public BookGenreDtos updateBookGenre(@PathVariable Long bookgenreId, @RequestBody SaveBookGenreDtos saveBookGenreDtos) {
        return mapper.toResource(bookGenreService.updateBookGenre(bookgenreId, mapper.toModel(saveBookGenreDtos)));
    }
    @DeleteMapping("{bookgenreId}")
    public ResponseEntity<?> deleteBookGenre(@PathVariable Long bookgenreId) {
        return bookGenreService.delete(bookgenreId);
    }
}


