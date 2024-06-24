package com.readowo.api.publishing.Services.IServices;

import com.readowo.api.publishing.Dtos.SaveBookDtos;
import com.readowo.api.publishing.Dtos.SaveBookGenreDtos;
import com.readowo.api.publishing.Models.Book;
import com.readowo.api.publishing.Services.Communication.BookGenreResponse;
import com.readowo.api.publishing.Services.Communication.BookResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(Long bookId);
    Book saveBook(Book book);
    ResponseEntity<?> deleteBook(Long bookId);
    Book updateBook(Long id, Book book);

}
