package com.readowo.api.publishing.Services.IServices;


import com.readowo.api.publishing.Dtos.SaveBookGenreDtos;
import com.readowo.api.publishing.Dtos.SaveGenreDtos;
import com.readowo.api.publishing.Models.BookGenre;
import com.readowo.api.publishing.Services.Communication.BookGenreResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IBookGenreService {

    List<BookGenre> list();
    BookGenre findById(Long id);
    BookGenre saveBookGenre(BookGenre bookGenre);
    BookGenre updateBookGenre(Long id, BookGenre bookGenre);
    ResponseEntity<?> delete(Long bookGenreId);
}
