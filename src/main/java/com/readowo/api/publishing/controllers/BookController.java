package com.readowo.api.publishing.controllers;

import com.readowo.api.publishing.Dtos.*;
import com.readowo.api.publishing.Models.Book;
import com.readowo.api.publishing.Models.Chapters;
import com.readowo.api.publishing.Services.Communication.BookResponse;
import com.readowo.api.publishing.Services.IServices.IBookService;
import com.readowo.api.publishing.Services.ServicesImpl.BookServiceImpl;
import com.readowo.api.publishing.mapping.BookMapper;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/books", produces = "application/json")
public class BookController {
    private final IBookService bookService;
    private final BookMapper mapper;
    @Autowired
    public BookController(IBookService bookService, BookMapper mapper) {
        this.bookService = bookService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<BookDtos> getAllBooks() {
        return mapper.modelList(bookService.getAllBooks());
    }

    @GetMapping("{bookId}")
    public BookDtos getOneBook(@PathVariable Long bookId) {
        return mapper.toResource(bookService.getBookById(bookId));
    }
    @PostMapping
    public ResponseEntity<BookDtos> saveBook(@RequestBody SaveBookDtos saveBookDtos) {
        Book book = mapper.toModel(saveBookDtos);
        book.setId(null);
        Book savedBook = bookService.saveBook(book);
        return new ResponseEntity<>(mapper.toResource(savedBook), HttpStatus.CREATED);
    }
    @PutMapping("{bookId}")
    public BookDtos updateBook(@PathVariable Long bookId, @RequestBody SaveBookDtos saveBookDtos) {
        return mapper.toResource(bookService.updateBook(bookId, mapper.toModel(saveBookDtos)));
    }
    @DeleteMapping("{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
        return bookService.deleteBook(bookId);
    }
}
